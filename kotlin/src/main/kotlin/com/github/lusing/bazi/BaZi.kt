package com.github.lusing.bazi

import com.github.lusing.qimen.*

class BaZi(
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
    val nian: GanZhi
    val yue: GanZhi
    val ri: GanZhi
    val shi: GanZhi
    var wang: Int
    var qinYun: Int = qiyun
    var year: Int = cal
    var male: Boolean = male
    var sshen: Array<Array<ShiShen>>
    var siZhu: Array<GanZhi>

    init {
        this.nian = GanZhi(nianGan, nianZhi)
        this.yue = GanZhi(yueGan, yueZhi)
        this.ri = GanZhi(riGan, riZhi)
        this.shi = GanZhi(shiGan, shiZhi)
        this.wang = 0
        this.siZhu = arrayOf(nian, yue, ri, shi)
        this.sshen = arrayOf(emptyArray<ShiShen>(), emptyArray<ShiShen>())

        for (i in this.siZhu) {
            this.sshen[0] = this.sshen[0].plusElement(ShiShen.getShiShen(this.ri.mTg, i.mTg))
            this.sshen[1] = this.sshen[1].plusElement(ShiShen.getShiShen(this.ri.mTg, i.mDz.cangGan[0]))
        }
    }

    fun calcWang() {
        println("=================================================")
        for (i in this.sshen) {
            for (j in i) {
                print(j.toString())
            }
            println();
        }
//        var mu = 0
//        var huo = 0
//        var tu = 0
//        var jin = 0
//        var shui = 0

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
//        println(x)

        this.wang = result[(x + 4) % 5] + result[x % 5]
        println("旺: ${this.wang}")

        println(result[0] + result[1] + result[2] + result[3] + result[4])

        checkMuKu() // 查日主墓库
        checkCaiKu() // 查财库
        checkRoots() // 检查是否有根
        checkHeChongXingHai() // 检查合冲刑害

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
                (0..9).forEach { _ ->
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
        println("-------------------------------")
    }

    fun calcDaYun(gz: GanZhi): Int {
        var value: Double
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
        } else {
            println("日主弱")
        }

        if (des == 0) {
            println("从弱")
        } else if (des == 1) {
            println("身弱")
        } else if (des == 2) {
            println("身强")
        } else {
            println("从强")
        }
        checkYongShen(des)
    }

    // 检查用神和忌神

    fun checkYongShen(state: Int) {
        var yins = 0
        var bijies = 0
        var guans = 0
        var cais = 0
        var shishang = 0

        for (i in this.sshen) {
            for (j in i) {
                when (j.shiShen) {
                    ShiShen.ZHENGYIN -> yins++
                    ShiShen.PIANYIN -> yins++
                    ShiShen.ZHENGGUAN -> guans++
                    ShiShen.QISHA -> guans++
                    ShiShen.ZHENGCAI -> cais++
                    ShiShen.PIANCAI -> cais++
                    ShiShen.SHISHEN -> shishang++
                    ShiShen.SHANGGUAN -> shishang++
                    ShiShen.BIJIAN -> bijies++
                    ShiShen.JIECAI -> bijies++
                }
            }
        }
        //去掉日主自己
        bijies--

        when (state) {
            // 身弱用印比
            1 -> {
                // 查找有没有印星
                if (yins > 0) {
                    println("用神为印")
                    println("命中有印，忌神为财")
                }
                if (bijies > 0) {
                    println("用神为比劫")
                    println("命中有比劫，忌神为官杀")
                }
            }
            // 身强
            2 -> {
                // 查找有没有官杀
                if (guans > 0) {
                    println("命中有官杀，用神为官杀")
                    println("命中有官杀，忌神为食伤")
                } else {
                    if (shishang > 0) {
                        println("命中无官杀，用神为食伤")
                        println("忌神为印")
                    }
                }
                if (cais > 0) {
                    println("命中有财，用神为财")
                    println("忌神为比劫")
                }
            }
        }
    }

    fun isShengFu(x1: WuXing, x2: WuXing): Boolean {
        return x1.xing == x2.xing || x1.isSheng(x2)
    }

    fun checkMuKu() {
        for (gz in this.siZhu) {
            if (gz.mDz.getMuKu(this.ri.mTg.xing).diZhi == gz.mDz.diZhi) {
                if (gz.mDz.diZhi == DiZhi.CHEN) {
                    println("命中出生的时候旁边有河流、湖泊、水库等")
                } else if (gz.mDz.diZhi == DiZhi.XU) {
                    println("命中出生的时候旁边有学校、电影院、文化局等")
                } else if (gz.mDz.diZhi == DiZhi.CHOU) {
                    println("命中出生的时候旁边有银行")
                } else if (gz.mDz.diZhi == DiZhi.WEI) {
                    println("命中出生的时候旁边有公园")
                }
            }
        }
    }

    // 检查是否有财库
    fun checkCaiKu() {
        val cai = WuXing(this.ri.mTg.xing.xing + 2)
        for (gz in this.siZhu) {
            if (gz.mDz.getMuKu(cai).diZhi == gz.mDz.diZhi) {
                println("有财库,消费更保守,理财观念好")
            }
        }
    }

    // 检查是否有根
    fun checkRoots() {
        var roots = 0
        for (gz in this.siZhu) {
            //println(gz.mDz.cangGan)
            var xingList = gz.mDz.cangGan.map { tg: TianGan -> tg.xing.xing }
            //println(xingList)
            if (this.ri.mTg.xing.xing in xingList) {
                println("天干${this.ri.mTg.toString()}在地支${gz.mDz.toString()}中有根")
            }
        }
    }

    fun checkHeChongXingHai() {
//        for (gz1 in this.siZhu) {
//            for (gz2 in this.siZhu) {
//                var tg1 = gz1.mTg
//                var tg2 = gz2.mTg
//                var dz1 = gz1.mDz
//                var dz2 = gz2.mDz
//                if (tg1.isHe(tg2) != null) {
//                    println("${tg1.toString()}与${tg2.toString()}合")
//                }
//                if (tg1.isChong(tg2)) {
//                    println("${tg1.toString()}与${tg2.toString()}冲")
//                }
//            }
//        }
        for (i in (0..3)) {
            for (j in (0..i)) {
                if (i == j) {
                    continue
                }
                val gz1 = siZhu[i]
                val gz2 = siZhu[j]
                val tg1 = gz1.mTg
                val tg2 = gz2.mTg
                val dz1 = gz1.mDz
                val dz2 = gz2.mDz
                if (tg1.isHe(tg2) != null) {
                    println("${tg1.toString()}与${tg2.toString()}合")
                }
                if (tg1.isChong(tg2)) {
                    println("${tg1.toString()}与${tg2.toString()}冲")
                }
                if (dz1.isHe(dz2)) {
                    println("${dz1.toString()}与${dz2.toString()}合")
                }
                if (dz1.isChong(dz2)) {
                    println("${dz1.toString()}与${dz2.toString()}冲")
                }
                if (dz1.isHai(dz2)) {
                    println("${dz1.toString()}与${dz2.toString()}害")
                }
                if (dz1.isXing2(dz2)) {
                    println("${dz1.toString()}与${dz2.toString()}刑")
                }
            }
        }
    }
}
