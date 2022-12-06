package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi
import com.github.lusing.qimen.LiuQin

class LiuYao {

    var benGua: Gua64
    val yueJian: DiZhi
    val riJian: DiZhi
    var yongShen: LiuQin?
    var isShi: Boolean
    var isYing: Boolean
    var ganZhi: GanZhi
    var xunKongs: String
    lateinit var bianGua: Gua64

    constructor(gua: Gua64, yueJian: Int, riJian: Int, yongShen: Int) {
        this.benGua = gua
        this.yueJian = DiZhi(yueJian)
        this.riJian = DiZhi(riJian)
        this.ganZhi = GanZhi(this.benGua.riGan, this.riJian)
        this.xunKongs = ganZhi.getXunKongNames()
        if (yongShen in LiuQin.XIONGDI..LiuQin.QICAI) {
            this.yongShen = LiuQin(yongShen)
            this.isShi = false
            this.isYing = false
        } else if (yongShen == Yao.SHI_YAO) {
            this.yongShen = null
            this.isShi = true
            this.isYing = false
        } else if (yongShen == Yao.YING_YAO) {
            this.yongShen = null
            this.isShi = false
            this.isYing = true
        } else {
            this.yongShen = null
            this.isShi = false
            this.isYing = false
        }
    }

    fun paiPan() {
        this.bianGua = benGua.getBianGua()
        println("${this.yueJian.getName()}月${this.benGua.riGan}${this.riJian.getName()}日${this.yongShen?.getName()}为用神")
        println("旬空：${this.xunKongs}")
        print(this.benGua.getName())
        print("    ==>        ")
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

            if (benGua.yaos[i].isChange) {
                benGua.yaos[i].bianYao = this.bianGua.yaos[i]
            }
        }
        checkYongShen()
        checkAll()
        val isHe1 = this.checkLiuHe(this.benGua)
        val isChong1 = this.checkLiuChong(this.benGua)
        val isHe2 = this.checkLiuHe(this.bianGua)
        val isChong2 = this.checkLiuChong(this.bianGua)
        if (isHe1) {
            if (isHe2) {
                println("六合化六合")
            } else if (isChong2) {
                println("六合化六冲")
            } else {
                println("六合")
            }
        }
        if (isChong1) {
            if (isHe2) {
                println("六冲化六合")
            } else if (isChong2) {
                println("六冲化六冲")
            } else {
                println("六冲")
            }
        }
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
        var shiYao: Yao? = null
        var isFuShen = false
        var whatShen: YongShen = YongShen(YongShen.XIAN_SHEN)

        for (i in 0..5) {
            if (this.benGua.yaos[i].isShi) {
                shiYao = this.benGua.yaos[i]
                break
            }
        }

        assert(shiYao == null)

        // 世爻为用神
        if (this.isShi) {
            println("用神持世")
            yongshen = shiYao
            whatShen = YongShen(YongShen.YONG_SHEN)
        } else if (this.isYing) {
            for (i in 0..5) {
                if (this.benGua.yaos[i].isYing) {
                    yongshen = this.benGua.yaos[i]
                    break
                }
            }
            whatShen = YongShen(shiYao!!.naZhi, yongshen!!.naZhi)
        } else {
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
                var fu = this.checkFuShen(yao1)
                var shengke = this.checkShengKe(yao1.fuShen!!, wang, fu)
                whatShen = YongShen(shiYao!!.naZhi, yongshen!!.naZhi)
                println("${whatShen.getName()}持世")
            } else {
                var yongWang = this.checkYueJian(yao1)
                var shengke = this.checkShengKe(yao1, yongWang)
                whatShen = YongShen(shiYao!!.naZhi, yongshen!!.naZhi)
                println("${whatShen.getName()}持世")
                var shiWang = this.checkYueJian(shiYao)
                this.checkDeShi(whatShen, yongWang, shiWang)
            }
        }
    }

    fun checkDeShi(whatShen: YongShen, yongShenWang: Int, shiYaoWang: Int): JiXiong {
        if (whatShen.yongShen == YongShen.YONG_SHEN) {
            //用神持世：按世爻旺衰来直接断吉凶
            println("用神持世：按世爻旺衰来直接断吉凶")
            println("为事体临身之象，说明所测的事情与求测人比较贴近，比较熟练，求测人有近水楼台的好处")
            println("得：世爻在月日旺相有气，且又无动爻变爻来伤克。如果再遇到原神动而生世，则为源远流长之象；如遇到原神休囚受伤者，则为难以长久之象")
            println("失：世或用爻有一个在月日休囚无气，或旬空月破，并受变动爻的克伤")
            if (shiYaoWang > 0) {
                println("世爻旺，吉")
                return JiXiong(JiXiong.JI)
            } else {
                println("世爻衰，凶")
                return JiXiong(JiXiong.XIONG)
            }
        } else if (whatShen.yongShen == YongShen.YUAN_SHEN) {
            println("原神持世：自己追求目标，世旺用旺则以得断，有一方衰则断某方有问题，双方都衰则以失断")
            println("说明求测人会一直费心着做事，而且自己在得到这件事前要先投入本钱与精力的。")
            println("得：世爻在月日旺相有气，且又无动爻变爻来伤克。如果再遇到世爻动而生用，说明经过求测者的努力，也能成就其事")
            println("失：世或用爻有一个在月日休囚无气，或旬空月破，并受变动爻的克伤")
            if (shiYaoWang < 0 && yongShenWang < 0) {
                println("世爻衰，用神衰，凶")
                JiXiong(JiXiong.XIONG)
            } else {
                println("世爻旺，用神旺，吉")
                JiXiong(JiXiong.JI)
            }
        } else if (whatShen.yongShen == YongShen.CHOU_SHEN) {
            println("仇神持世：世爻用神均中平以上为得，世强用衰为意愿强而目标差，世衰用强为能力不足而先补能力，世用双衰为失")
            println("为事体克身之象，除了求财求物与出门游玩享乐求子者为吉象外，其它都是不利之象。它代表因为求测者的能力与环境不适应，而使所测之事对求测者造成压力，所测之事阻力重重，求测者有独木难支之感")
            println("占治病去忧游玩求子时，用神旺相克世者，为得象")
            println("占求财索物时，用爻世爻均旺相有气者")
            println("世爻用爻间有动爻通关生世者，此为化煞生身，为成象")
            println("仇神持世者，都为用神克世，所以除了以上三种类型外，仇神持世者都为事体不成，甚至是因事引祸之象")
            if (shiYaoWang < 0 && yongShenWang < 0) {
                println("世爻衰，用神衰，凶")
                JiXiong(JiXiong.XIONG)
            } else {
                println("世爻旺，用神旺，吉")
                JiXiong(JiXiong.JI)
            }
        } else if (whatShen.yongShen == YongShen.JI_SHEN) {
            //六静卦忌神持世为失
            if (this.benGua.value == this.bianGua.value) {
                println("六静卦忌神持世为失")
                return JiXiong(JiXiong.XIONG)
            }
            println("忌神持世：世爻克用神，这是世爻追逐用神之意，除用神过衰外，一般为得。防用力过猛，世爻和用神均中平以上为得，世强用衰为意愿强而目标差，世衰用强为能力不足而先补能力，世用双衰为失")
            println("为自身见阻之象，说明求测者根本没有素质与环境去适合自己想做之事，凡遇到忌神持世者，多数都是事件难成之象的")
            println("占求财索物时")
            println(
                "  - 用神临月日动来冲世者，或月日做用神来冲世者\n" +
                        "  - 用神动来合世者\n" +
                        "  - 世爻动化用神者\n" +
                        "  - 世爻入墓不克用神者"
            )
            println("失：忌临身而多谋少成，所以除了以上四种类型外，忌神持世者一般都是多谋少成之象")
            if (shiYaoWang < 0 && yongShenWang < 0) {
                println("世爻衰，用神衰，凶")
                JiXiong(JiXiong.XIONG)
            } else {
                println("世爻旺，用神旺，吉")
                JiXiong(JiXiong.JI)
            }
        } else if (whatShen.yongShen == YongShen.XIAN_SHEN) {
            println("闲神持世：（用神生世爻）只要用神不为衰，则为得")
            println("为事体生身之象，说明所测的事情比较能够帮助求测人，求测人容易在其中获得好处，求测人有先天有利的环境与条件，可以称得上是唾手可得")
            println("得：世爻在月日旺相有气，且又无动爻变爻来伤克。如果再遇到用爻动而生世，则更为大吉之象")
            println("失：世或用爻有一个在月日休囚无气，或旬空月破，并受变动爻的克伤")
            if (yongShenWang < 0) {
                println("用神衰，凶")
                JiXiong(JiXiong.XIONG)
            } else {
                println("用神旺，吉")
                JiXiong(JiXiong.JI)
            }
        }
        return JiXiong(JiXiong.JI)
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
            val isXunKong = this.ganZhi.isXunKong(yao.naZhi)
            if (isXunKong) {
                println("旬空")
            }
            var wang = this.checkYueJian(yao)
            if (yao.isChange) {
                print("动:")
                var bianYao = this.bianGua.yaos[i]
                println(this.getYaoName(bianYao))
                if (yao.bianYao == null) {
                    yao.bianYao = bianYao
                }
                this.checkBian(yao)
            } else {
                //判断暗动
                if (wang < 0) {
                    if (yao.naZhi.isChong(this.riJian)) {
                        println("暗动，可以冲克其它静爻")
                    }
                }
            }
            this.checkShengKe(yao, wang)
            if (yao.fuShen != null) {
                print("伏神：")
                wang = this.checkYueJian(yao)
                var fuYao = this.checkFuShen(yao)
                this.checkShengKe(yao, wang, fuYao)
            }
            println("-------------")
        }
    }

    // 检查伏神被飞神生与克的状态
    fun checkFuShen(yao: Yao): Int {
        if (yao.naZhi.isSheng(yao.fuShen!!.naZhi)) {
            println("飞神生伏神")
            return 1
        } else if (yao.naZhi.isKe(yao.fuShen!!.naZhi)) {
            println("飞神克伏神")
            return -1
        }
        return 0
    }

    fun checkBian(yao: Yao): Int {
        var result = 0;
        // 化进：寅化卯，丑化辰，申化酉，未化戌称为化进
        if (yao.naZhi.diZhi == DiZhi.YIN && yao.bianYao!!.naZhi.diZhi == DiZhi.MAO) {
            println("化进")
        } else if (yao.naZhi.diZhi == DiZhi.CHOU && yao.bianYao!!.naZhi.diZhi == DiZhi.CHEN) {
            println("化进")
        } else if (yao.naZhi.diZhi == DiZhi.SHEN && yao.bianYao!!.naZhi.diZhi == DiZhi.YOU) {
            println("化进")
        } else if (yao.naZhi.diZhi == DiZhi.WEI && yao.bianYao!!.naZhi.diZhi == DiZhi.XU) {
            println("化进")
        }

        // 卯化寅，辰化丑，酉化申，戌化未称为化退
        if (yao.naZhi.diZhi == DiZhi.MAO && yao.bianYao!!.naZhi.diZhi == DiZhi.YIN) {
            println("化退")
        } else if (yao.naZhi.diZhi == DiZhi.CHEN && yao.bianYao!!.naZhi.diZhi == DiZhi.CHOU) {
            println("化退")
        } else if (yao.naZhi.diZhi == DiZhi.YOU && yao.bianYao!!.naZhi.diZhi == DiZhi.SHEN) {
            println("化退")
        } else if (yao.naZhi.diZhi == DiZhi.XU && yao.bianYao!!.naZhi.diZhi == DiZhi.WEI) {
            println("化退")
        }

        // 变爻回头冲动爻，称为反吟，代表多有反复
        if (yao.bianYao!!.naZhi.isChong(yao.naZhi)) {
            println("反吟")
        }

        // 变爻与动爻地支相同，称为伏吟，代表痛苦煎熬
        if (yao.bianYao!!.naZhi.diZhi == yao.naZhi.diZhi) {
            println("伏吟")
        }

        if (yao.bianYao!!.naZhi.isHe(yao.naZhi)) {
            println("动爻合变爻！")
            result = 1
        } else if (yao.bianYao!!.naZhi.isChong(yao.naZhi)) {
            println("动爻冲变爻！")
        } else if (yao.bianYao!!.naZhi.isKe(yao.naZhi)) {
            println("动爻克变爻:(")
            result = -1
        } else if (yao.bianYao!!.naZhi.isSheng(yao.naZhi)) {
            println("动爻生变爻:)")
            result = 1
        }
        return result
    }

    fun checkYueJian(yao: Yao): Int {
        var value = 0
        if (this.yueJian.isChong(yao.naZhi)) {
            println("月破")
            value -= 50
        } else if (yao.naZhi.xing.xing == this.yueJian.xing.xing) {
            println("月旺")
            value += 50
        } else if (this.yueJian.isHe(yao.naZhi)) {
            println("爻与月建相合")
            value += 30
        } else if (this.yueJian.isSheng(yao.naZhi)) {
            println("月相")
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
        if (yao.naZhi.isHe(this.riJian)) {
            println("爻与日建相合")
        } else if (yao.naZhi.isChong(this.riJian)) {
            //println("爻与日建相冲")
            if(value>=0){
                println("暗动")
            }else{
                println("日破")
            }
        }

        return value
    }

    fun checkLiuChong(gua: Gua64): Boolean {
        if (gua.yaos[0].naZhi.isChong(gua.yaos[3].naZhi) && gua.yaos[1].naZhi.isChong(gua.yaos[4].naZhi) && gua.yaos[2].naZhi.isChong(
                gua.yaos[5].naZhi
            )
        ) {
            println("${gua.getName()} 六冲卦")
            return true
        } else {
            return false
        }
    }

    fun checkLiuHe(gua: Gua64): Boolean {
        if (gua.yaos[0].naZhi.isHe(gua.yaos[3].naZhi) && gua.yaos[1].naZhi.isHe(gua.yaos[4].naZhi) && gua.yaos[2].naZhi.isHe(
                gua.yaos[5].naZhi
            )
        ) {
            println("${gua.getName()} 六合卦")
            return true
        } else {
            return false
        }
    }

    fun checkShengKe(yao: Yao, wang: Int, fuYao: Int = 0): Pair<Int, Int> {
        var shengs = 0;
        var kes = 0;
        for (i in 0..5) {
            if (this.benGua.yaos[i].isChange) {
                if (this.benGua.yaos[i].naZhi.isHe(yao.naZhi)) {
                    println("动爻${this.getYaoName(this.benGua.yaos[i])}合爻${this.getYaoName(yao)}")
                } else if (this.benGua.yaos[i].naZhi.isHe(yao.naZhi)) {
                    println("动爻${this.getYaoName(this.benGua.yaos[i])}冲爻${this.getYaoName(yao)}")
                } else if (this.benGua.yaos[i].naZhi.isSheng(yao.naZhi)) {
                    shengs++;
                    println("动爻${this.getYaoName(this.benGua.yaos[i])}生爻${this.getYaoName(yao)}")
                } else if (this.benGua.yaos[i].naZhi.isKe(yao.naZhi)) {
                    println("动爻${this.getYaoName(this.benGua.yaos[i])}克爻${this.getYaoName(yao)}")
                    kes++;
                }
            }
        }
        if (yao.isChange) {
            var bian = this.checkBian(yao)
            if (bian > 0) {
                shengs++
            } else if (bian < 0) {
                kes++
            }
        }

        if (fuYao > 0) {
            shengs++
        } else if (fuYao < 0) {
            kes++
        }

        println("[Debug]生爻数：${shengs},克爻数：${kes}");
        if (wang >= 0) {
            if (shengs > 0) {
                if (wang == 100) {
                    println("用神旺极：刚脆则折，凶。")
                } else {
                    println("用旺逢生：锦上添花，吉")
                }
            }
            if (kes > 0) {
                println("用旺受克：易有不利，凶")
            } else if (shengs == 0) {
                println("用旺无克：平平无奇，平")
            }
        } else {
            if (shengs > 0) {
                println("用衰逢生：危中有救，吉")
            } else if (kes > 0) {
                println("用衰受克：屋漏逢雨，凶")
            } else if (shengs == 0) {
                if (wang <= -70) {
                    println("用神弱极，衰极无救,凶")
                } else {
                    println("用衰无克：勉力支撑，吉")
                }
            }
        }
        return Pair(shengs, kes)
    }
}