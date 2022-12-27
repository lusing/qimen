package com.github.lusing.bazi

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi
import com.github.lusing.qimen.TianGan
import com.github.lusing.qimen.WuXing

class BaZi {
    val nian: GanZhi
    val yue: GanZhi
    val ri: GanZhi
    val shi: GanZhi
    var wang: Int
    var male: Boolean
    var qinYun: Int
    var year: Int

    constructor(
        nianGan: Int,
        nianZhi: Int,
        yueGan: Int,
        yueZhi: Int,
        riGan: Int,
        riZhi: Int,
        shiGan: Int,
        shiZhi: Int,
        male: Boolean,
        qiyun: Int = 0,
        cal: Int = 0
    ) {
        this.nian = GanZhi(nianGan, nianZhi)
        this.yue = GanZhi(yueGan, yueZhi)
        this.ri = GanZhi(riGan, riZhi)
        this.shi = GanZhi(shiGan, shiZhi)
        this.wang = 0
        this.male = male
        this.qinYun = qiyun
        this.year = cal
    }

    fun calcWang() {
        var mu = 0
        var huo = 0
        var tu = 0
        var jin = 0
        var shui = 0

        checkLingDiZhu()

        var nianGan = calcTianGan(this.nian.mTg, 1.0)
        var yueGan = calcTianGan(this.yue.mTg, 1.0)
        var riGan = calcTianGan(this.ri.mTg, 1.0)
        var shiGan = calcTianGan(this.shi.mTg, 1.0)

        var nianZhi = calcDiZhi(this.nian.mDz, 1.0)
        var yueZhi = calcDiZhi(this.yue.mDz, 1.5)
        var riZhi = calcDiZhi(this.ri.mDz, 1.0)
        var shiZhi = calcDiZhi(this.shi.mDz, 1.0)

        var result = this.addArray(nianGan, this.addArray(yueGan, this.addArray(riGan, shiGan)))
        result = this.addArray(result, this.addArray(nianZhi, this.addArray(yueZhi, this.addArray(riZhi, shiZhi))))
        println("木: ${result[0]}, 火: ${result[1]}, 土: ${result[2]}, 金: ${result[3]}, 水: ${result[4]}")

        println(this.ri.mTg.getName())
        val x = this.ri.mTg.xing.xing
        println(x)

        this.wang = result[(x + 4) % 5] + result[x % 5]
        println("旺: ${this.wang}")

        println(result[0] + result[1] + result[2] + result[3] + result[4])

//        println("木: ${nianGan[0]}, 火: ${nianGan[1]}, 土: ${nianGan[2]}, 金: ${nianGan[3]}, 水: ${nianGan[4]}")
//        println("木：${yueGan[0]}, 火: ${yueGan[1]}, 土: ${yueGan[2]}, 金: ${yueGan[3]}, 水: ${yueGan[4]}")
//        println("木: ${riGan[0]}, 火: ${riGan[1]}, 土: ${riGan[2]}, 金: ${riGan[3]}, 水: ${riGan[4]}")
//        println("木: ${shiGan[0]}, 火: ${shiGan[1]}, 土: ${shiGan[2]}, 金: ${shiGan[3]}, 水: ${shiGan[4]}")
//        println("木: ${nianZhi[0]}, 火: ${nianZhi[1]}, 土: ${nianZhi[2]}, 金: ${nianZhi[3]}, 水: ${nianZhi[4]}")
//        println("木: ${yueZhi[0]}, 火: ${yueZhi[1]}, 土: ${yueZhi[2]}, 金: ${yueZhi[3]}, 水: ${yueZhi[4]}")
//        println("木: ${riZhi[0]}, 火: ${riZhi[1]}, 土: ${riZhi[2]}, 金: ${riZhi[3]}, 水: ${riZhi[4]}")
//        println("木: ${shiZhi[0]}, 火: ${shiZhi[1]}, 土: ${shiZhi[2]}, 金: ${shiZhi[3]}, 水: ${shiZhi[4]}")
    }

    fun checkDaYun() {
        println("大运：")
        val yang = this.nian.mTg.isYang
        var year = this.nian.add(this.qinYun)
        var sui = this.qinYun
        if (yang == this.male) {
            var dy = this.yue.getNext()
            for (i in 0..9) {
                print("${dy.getName()}")
                var dyfen = calcDaYun(dy)
                println(dyfen)
                dy = dy.getNext()
                for (j in 0..9) {
                    print("----${year.getName()}")
                    if (this.year != 0) {
                        print(" ${this.year + sui}年")
                    }
                    print(" ${sui}岁 ")
                    print((dyfen * 0.6 + calcDaYun(year) * 0.4).toInt())
                    print(" ")
                    println(checkTaoHua(year))
                    year = year.getNext()
                    sui++
                }
            }
        } else {
            var dy = this.yue.getPrev()
            for (i in 0..9) {
                print("${dy.getName()} ")
                var dyfen = calcDaYun(dy)
                println(dyfen)
                dy = dy.getPrev()
                (0..9).forEach { j ->
                    print("----${year.getName()}")
                    if (this.year != 0) {
                        print(" ${this.year + sui}年")
                    }
                    print(" ${sui}岁 ")
                    print((dyfen * 0.6 + calcDaYun(year) * 0.4).toInt())
                    print(" ")
                    println(checkTaoHua(year))
                    year = year.getNext()
                    sui++
                }
            }
        }
    }

    fun calcDaYun(gz: GanZhi): Int {
        var value = 0.0
        var gan = gz.mTg
        var zhi = gz.mDz
        var ri = this.ri.mTg

        if (gan.xing.xing == ri.xing.xing || gan.isSheng(ri)) {
            value = 40 * 0.8
        } else {
            value = 40 * 0.3
        }

        if (zhi.xing.xing == ri.xing.xing || zhi.xing.isSheng(ri.xing)) {
            value += 60 * 0.8
        } else {
            value += 60 * 0.3
        }
        return value.toInt()
    }

    fun calcTianGan(tg: TianGan, factor: Double): Array<Int> {
        var result = arrayOf(0, 0, 0, 0, 0)
        if (tg.xing.xing == WuXing.MU) {
            result[0] = (40.0 * factor).toInt()
        } else if (tg.xing.xing == WuXing.HUO) {
            result[1] = (40.0 * factor).toInt()
        } else if (tg.xing.xing == WuXing.TU) {
            result[2] = (40.0 * factor).toInt()
        } else if (tg.xing.xing == WuXing.JIN) {
            result[3] = (40.0 * factor).toInt()
        } else if (tg.xing.xing == WuXing.SHUI) {
            result[4] = (40.0 * factor).toInt()
        }
        return result
    }

    fun calcDiZhi(dz: DiZhi, factor2: Double): Array<Int> {
        var result = arrayOf(0, 0, 0, 0, 0)
        var factor = 2.5 * factor2
        when (dz.diZhi) {
            DiZhi.ZI -> {
                result = calcTianGan(TianGan(TianGan.GUI), factor)
            }

            DiZhi.CHOU -> {
                result = calcTianGan(TianGan(TianGan.JI), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.GUI), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.XIN), factor * 0.1))
            }

            DiZhi.YIN -> {
                result = calcTianGan(TianGan(TianGan.JIA), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.BING), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.WU), factor * 0.1))
            }

            DiZhi.MAO -> {
                result = calcTianGan(TianGan(TianGan.YI), factor * 1.0)
            }

            DiZhi.CHEN -> {
                result = calcTianGan(TianGan(TianGan.WU), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.YI), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.GUI), factor * 0.1))
            }

            DiZhi.SI -> {
                result = calcTianGan(TianGan(TianGan.BING), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.WU), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.GENG), factor * 0.1))
            }

            DiZhi.WU -> {
                result = calcTianGan(TianGan(TianGan.DING), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.JI), factor * 0.3))
            }

            DiZhi.WEI -> {
                result = calcTianGan(TianGan(TianGan.JI), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.DING), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.YI), factor * 0.1))
            }

            DiZhi.SHEN -> {
                result = calcTianGan(TianGan(TianGan.GENG), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.REN), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.WU), factor * 0.1))
            }

            DiZhi.YOU -> {
                result = calcTianGan(TianGan(TianGan.XIN), factor * 1.0)
            }

            DiZhi.XU -> {
                result = calcTianGan(TianGan(TianGan.WU), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.XIN), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.DING), factor * 0.1))
            }

            DiZhi.HAI -> {
                result = calcTianGan(TianGan(TianGan.REN), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.JIA), factor * 0.3))
            }
        }
        return result
    }

    fun addArray(a: Array<Int>, b: Array<Int>): Array<Int> {
        var result = arrayOf(0, 0, 0, 0, 0)
        for (i in 0..4) {
            result[i] = a[i] + b[i]
        }
        return result
    }

    // 桃花
    fun checkTaoHua(gz: GanZhi): String {
        val riGan = this.ri.mTg
        val riZhi = this.ri.mDz
        val ngan = gz.mTg
        val nzhi = gz.mDz
        var result = ""

        if (riGan.isKe(ngan)) {
            result = result.plus(" 桃花年")
        }

        if (riZhi.isChong(nzhi)) {
            result = result.plus(" 烂桃花")
        }

        if (riZhi.isHe(nzhi)) {
            result = result.plus(" 好桃花")
        }

        if (riZhi.diZhi == nzhi.diZhi) {
            result = result.plus(" 婚恋年")
        }

        return result
    }

    private fun checkLingDiZhu() {
        // 得令：得月令之五行本气生助为得令
        val ling = this.yue.mDz
        val riZhu = this.ri.mTg

        var des = 0

        if (isShengFu(ling.xing, riZhu.xing)) {
            println("得令")
            des++
        } else {
            println("不得令")
        }

        // 得地：得非月令地支之五行本气本助为得地
        var count = 0
        val nZhi = this.nian.mDz
        val rZhi = this.ri.mDz
        val sZhi = this.shi.mDz

        if (isShengFu(nZhi.xing, riZhu.xing)) {
            count++
        }
        if (isShengFu(rZhi.xing, riZhu.xing)) {
            count++
        }
        if (isShengFu(sZhi.xing, riZhu.xing)) {
            count++
        }
        if (count >= 2) {
            println("得地")
            des++
        } else {
            println("不得地")
        }

        // 得助：得天干之生助为得助
        val nGan = this.nian.mTg
        val yGan = this.yue.mTg
        val sGan = this.shi.mTg

        var count2 = 0
        if (isShengFu(nGan.xing, riZhu.xing)) {
            count2++
        }
        if (isShengFu(yGan.xing, riZhu.xing)) {
            count2++
        }
        if (isShengFu(sGan.xing, riZhu.xing)) {
            count2++
        }

        if (count2 >= 2) {
            println("得助")
            des++
        } else {
            println("不得助")
        }

        if (des >= 2) {
            println("日主旺")
        }else{
            println("日主弱")
        }
    }

    fun isShengFu(x1: WuXing, x2: WuXing): Boolean {
        return x1.xing == x2.xing || x1.isSheng(x2)
    }
}
