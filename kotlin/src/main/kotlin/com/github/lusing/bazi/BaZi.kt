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

    constructor(
        nianGan: Int,
        nianZhi: Int,
        yueGan: Int,
        yueZhi: Int,
        riGan: Int,
        riZhi: Int,
        shiGan: Int,
        shiZhi: Int
    ) {
        this.nian = GanZhi(nianGan, nianZhi)
        this.yue = GanZhi(yueGan, yueZhi)
        this.ri = GanZhi(riGan, riZhi)
        this.shi = GanZhi(shiGan, shiZhi)
        this.wang = 0


    }

    fun calcWang() {
        var mu = 0
        var huo = 0
        var tu = 0
        var jin = 0
        var shui = 0

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

        println("木: ${nianGan[0]}, 火: ${nianGan[1]}, 土: ${nianGan[2]}, 金: ${nianGan[3]}, 水: ${nianGan[4]}")
        println("木：${yueGan[0]}, 火: ${yueGan[1]}, 土: ${yueGan[2]}, 金: ${yueGan[3]}, 水: ${yueGan[4]}")
        println("木: ${riGan[0]}, 火: ${riGan[1]}, 土: ${riGan[2]}, 金: ${riGan[3]}, 水: ${riGan[4]}")
        println("木: ${shiGan[0]}, 火: ${shiGan[1]}, 土: ${shiGan[2]}, 金: ${shiGan[3]}, 水: ${shiGan[4]}")
        println("木: ${nianZhi[0]}, 火: ${nianZhi[1]}, 土: ${nianZhi[2]}, 金: ${nianZhi[3]}, 水: ${nianZhi[4]}")
        println("木: ${yueZhi[0]}, 火: ${yueZhi[1]}, 土: ${yueZhi[2]}, 金: ${yueZhi[3]}, 水: ${yueZhi[4]}")
        println("木: ${riZhi[0]}, 火: ${riZhi[1]}, 土: ${riZhi[2]}, 金: ${riZhi[3]}, 水: ${riZhi[4]}")
        println("木: ${shiZhi[0]}, 火: ${shiZhi[1]}, 土: ${shiZhi[2]}, 金: ${shiZhi[3]}, 水: ${shiZhi[4]}")
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
                result = addArray(result, calcTianGan(TianGan(TianGan.WU), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.REN), factor * 0.1))
            }

            DiZhi.YOU -> {
                result = calcTianGan(TianGan(TianGan.XIN), factor * 1.0)
            }

            DiZhi.XU -> {
                result = calcTianGan(TianGan(TianGan.WU), factor * 0.7)
                result = addArray(result, calcTianGan(TianGan(TianGan.DING), factor * 0.2))
                result = addArray(result, calcTianGan(TianGan(TianGan.XIN), factor * 0.1))
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
}