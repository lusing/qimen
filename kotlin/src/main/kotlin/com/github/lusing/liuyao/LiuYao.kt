package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin

class LiuYao constructor(gua: Gua64, yueJian: Int, riJian: Int, yongShen: Int) {
    var benGua = gua
    val yueJian = DiZhi(yueJian)
    val riJian = DiZhi(riJian)
    val yongShen = LiuQin(yongShen)
    lateinit var bianGua: Gua64
    fun paiPan() {
        print(this.benGua.getName())
        print("            ")
        this.bianGua = benGua.getBianGua()
        println(this.bianGua.getName())

        //println("宫:${benGua.gong.getName()}")

        for (i in 5 downTo 0) {
            print("${benGua.yaos[i].liuShen.getName()} ")
            if (benGua.yaos[i].isYang) {
                print("-")
            } else {
                print("=")
            }
            if (benGua.yaos[i].isChange) {
                print("*")
            } else {
                print(" ")
            }
            if (benGua.yaos[i].fuShen != null) {
                print(benGua.yaos[i].fuShen!!.lq.getName())
                print(benGua.yaos[i].fuShen!!.naZhi.getName())
                val xing2 = benGua.yaos[i].fuShen!!.naZhi.xing
                print(xing2.toString())
                print(" ")
            } else {
                print("       ")
            }

            print(benGua.yaos[i].lq.getName())
            print(benGua.yaos[i].naZhi.getName())
            var xing = benGua.yaos[i].naZhi.xing
            print(xing.toString())
            if (benGua.yaos[i].isShi) {
                print(" 世 ")
            } else if (benGua.yaos[i].isYing) {
                print(" 应 ")
            } else {
                print("   ")
            }

            if (this.bianGua.yaos[i].isYang) {
                print("- ")
            } else {
                print("= ")
            }
            print(this.bianGua.yaos[i].lq.getName())
            print(this.bianGua.yaos[i].naZhi.getName())
            val xing3 = this.bianGua.yaos[i].naZhi.xing
            print(xing3.toString())
            if (this.bianGua.yaos[i].isShi) {
                print(" 世")
            } else if (this.bianGua.yaos[i].isYing) {
                print(" 应")
            }
            println()
        }
        checkYongShen()
        checkAll()
    }

    fun getYaoName(yao: Yao): String {
        var name = ""
        name = name.plus(yao.lq.getName())
        name = name.plus(yao.naZhi.getName())
        var xing = yao.naZhi.xing
        name = name.plus(xing.toString())
        return name
    }

    fun checkYongShen() {
        var yongshen: Yao? = null
        var level = 0
        var yaoSet = setOf<Yao>()
        var isFuShen = false
        for (i in 0..5) {
            if (this.benGua.yaos[i].lq == this.yongShen) {
                println("用神在本卦第${i + 1}爻")
                val yao = this.benGua.yaos[i]
                println(this.getYaoName(yao))
                yaoSet = yaoSet.plus(yao)
            }
        }
        if (yaoSet.size > 1) {
            for (yao in yaoSet) {
                if (yao.isChange) {
                    yongshen = yao
                }
            }
        } else if (yaoSet.size == 1) {
            yongshen = yaoSet.first()
        } else {
            for (i in 0..5) {
                if (this.benGua.yaos[i].fuShen != null) {
                    yongshen = this.benGua.yaos[i]
                    isFuShen = true
                }
            }
        }
        if (yongshen != null) {
            var yao1 = yongshen!!
            if (isFuShen) {
                println("用神为伏神${this.getYaoName(yao1.fuShen!!)}")
            } else {
                println("用神为${this.getYaoName(yao1)}")
            }

            if (isFuShen) {
                var wang = this.checkYueJian(yao1.fuShen!!)
                this.checkFuShen(yao1, wang)
            } else {
                this.checkYueJian(yao1)
            }
        }
    }

    fun checkAll() {
        println("====全体爻的情况：")
        for (i in 0..5) {
            val yao = this.benGua.yaos[i]
            print(this.getYaoName(yao))
            if (yao.isShi) {
                println("持世")
            } else if (yao.isYing) {
                println("为应")
            }
            var wang = this.checkYueJian(yao)
            if (yao.isChange) {
                print("动:")
                var bianYao = this.bianGua.yaos[i]
                println(this.getYaoName(bianYao))
                this.checkBian(yao, bianYao, wang)
            }
            if (yao.fuShen != null) {
                print("伏神：")
                wang = this.checkYueJian(yao)
                this.checkBian(yao, yao.fuShen!!, wang)
            }
        }
    }

    fun checkFuShen(yao: Yao, wang: Int) {
        if (yao.naZhi.isSheng(yao.fuShen!!.naZhi)) {
            println("飞神生伏神")
            if (wang >= 0) {
                println("用旺逢生：锦上添花，吉")
            } else {
                println("用衰逢生：危中有救，吉")
            }
        } else if (yao.naZhi.isSheng(yao.fuShen!!.naZhi)) {
            println("飞神克伏神")
            if (wang >= 0) {
                println("用旺受克：易有不利，凶")
            } else {
                println("用衰受克：屋漏逢雨，凶")
            }
        }
    }

    fun checkBian(yao: Yao, bianYao: Yao, wang: Int) {
        // 化进：寅化卯，丑化辰，申化酉，未化戌称为化进
        if (yao.naZhi.diZhi == DiZhi.YIN && bianYao.naZhi.diZhi == DiZhi.MAO) {
            println("化进")
        } else if (yao.naZhi.diZhi == DiZhi.CHOU && bianYao.naZhi.diZhi == DiZhi.CHEN) {
            println("化进")
        } else if (yao.naZhi.diZhi == DiZhi.SHEN && bianYao.naZhi.diZhi == DiZhi.YOU) {
            println("化进")
        } else if (yao.naZhi.diZhi == DiZhi.WEI && bianYao.naZhi.diZhi == DiZhi.XU) {
            println("化进")
        }

        // 卯化寅，辰化丑，酉化申，戌化未称为化退
        if (yao.naZhi.diZhi == DiZhi.MAO && bianYao.naZhi.diZhi == DiZhi.YIN) {
            println("化退")
        } else if (yao.naZhi.diZhi == DiZhi.CHEN && bianYao.naZhi.diZhi == DiZhi.CHOU) {
            println("化退")
        } else if (yao.naZhi.diZhi == DiZhi.YOU && bianYao.naZhi.diZhi == DiZhi.SHEN) {
            println("化退")
        } else if (yao.naZhi.diZhi == DiZhi.XU && bianYao.naZhi.diZhi == DiZhi.WEI) {
            println("化退")
        }

        // 变爻回头冲动爻，称为反吟，代表多有反复
        if (bianYao.naZhi.isChong(yao.naZhi)) {
            println("反吟")
        }

        // 变爻与动爻地支相同，称为伏吟，代表痛苦煎熬
        if (bianYao.naZhi.diZhi == yao.naZhi.diZhi) {
            println("伏吟")
        }

        if (bianYao.naZhi.isKe(yao.naZhi)) {
            println("动爻克变爻:(")
            if (wang >= 0) {
                println("用旺受克：易有不利，凶")
            } else {
                println("用衰受克：屋漏逢雨，凶")
            }
        } else if (bianYao.naZhi.isSheng(yao.naZhi)) {
            println("动爻生变爻:)")
            if (wang >= 0) {
                println("用旺逢生：锦上添花，吉")
            } else {
                println("用衰逢生：危中有救，吉")
            }
        }
    }

    fun checkYueJian(yao: Yao): Int {
        var value = 0
        if (this.yueJian.isChong(yao.naZhi)) {
            println("爻被月建冲为最衰")
            value -= 50
        } else if (yao.naZhi.xing.xing == this.yueJian.xing.xing) {
            println("爻五行同月建为最旺")
            value += 50
        } else if (this.yueJian.isHe(yao.naZhi)) {
            println("爻地支合月建为次旺")
            value += 30
        } else if (this.yueJian.isSheng(yao.naZhi)) {
            println("爻被月建生为再旺")
            value += 20
        } else if (yao.naZhi.isSheng(this.yueJian)) {
            println("爻生月建为衰")
            value -= 10
        } else if (yao.naZhi.isKe(this.yueJian)) {
            println("爻克月建为衰")
            value -= 10
        } else if (this.yueJian.isKe(yao.naZhi)) {
            println("爻被月建克为更衰")
            value -= 20
        }


        if (yao.naZhi.xing.xing == this.riJian.xing.xing) {
            println("爻五行同日建为最旺")
            value += 50
        } else if (this.riJian.isSheng(yao.naZhi)) {
            println("爻被日建生为次旺")
            value += 20
        } else if (yao.naZhi.isSheng(this.riJian)) {
            println("爻生日建为衰")
            value -= 10
        } else if (yao.naZhi.isKe(this.riJian)) {
            println("爻克日建为衰")
            value -= 10
        } else if (this.riJian.isKe(yao.naZhi)) {
            println("爻被日建克为更衰")
            value -= 20
        }
        print(value)
        if (value > 0) {
            println("爻为旺")
        } else if (value < 0) {
            println("爻为衰")
        } else {
            println("爻为平")
        }
        return value
    }
}