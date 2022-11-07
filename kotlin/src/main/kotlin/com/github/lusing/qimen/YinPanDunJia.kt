package com.github.lusing.qimen

/**
 * 王凤林阴盘奇门遁甲
 *
 * @author Louis
 */
class YinPanDunJia(
    private val yearGZ: GanZhi, private val monthGZ: GanZhi, private val dayGZ: GanZhi, private val hourGZ: GanZhi,
    /**
     * 月份
     */
    private var mMonth: Int, day: Int, yang: Boolean
) {
    /**
     * 阴历日期
     */
    private val mDay: Int

    /**
     * 局数
     */
    private var mJu = 0

    /**
     * 阴遁还是阳遁
     */
    private val mYang: Boolean
    private val diPan_bagua = arrayOfNulls<BaGua>(8)

    /**
     * 地盘上的奇仪
     */
    private val diPan_qiyi = arrayOfNulls<TianGan>(9)
    private val tianPan_qiyi = arrayOfNulls<TianGan>(9)
    private val tianPan_Jiuxing = arrayOfNulls<JiuXing>(8)
    private val tianPan_BaMen = arrayOfNulls<BaMen>(8)
    private val baShen = arrayOfNulls<BaShen>(8)
    private val yinGan = arrayOfNulls<TianGan>(8)
    private var zhifu = -1
    private var mXunShou: TianGan? = null
    private val mKongMa = arrayOfNulls<String>(8)

    //final private int[] houTianBaGua = {1, 8, 3, 4, 9, 2, 7, 6};
    private val houTianBaGua_full = intArrayOf(1, 8, 3, 4, 9, 2, 7, 6, 5)
    private val yangDunOrder = intArrayOf(0, 5, 2, 3, 8, 7, 6, 1, 4)
    private val yinDunOrder = intArrayOf(0, 4, 1, 6, 7, 8, 3, 2, 5)

    /**
     *
     * @param ygz 年干支
     * @param mgz 月干支
     * @param dgz 日干支
     * @param hgz 时干支
     * @param month 阴历月份
     * @param day 阴历日期
     * @param yang 阳遁还是阴遁
     */
    init {
        mMonth = mMonth
        mDay = day
        mYang = yang
        setJu()
        setDiPan()
        setTianPan()
    }

    private fun setJu() {
        val yearNo = yearGZ.mDz.diZhi + 1
        val hourNo = hourGZ.mDz.diZhi + 1
        mJu = (yearNo + mMonth + mDay + hourNo) % 9
    }

    private fun getQiyi(i: Int): Int {
        when (i % 9) {
            0 -> return TianGan.WU
            1 -> return TianGan.JI
            2 -> return TianGan.GENG
            3 -> return TianGan.XIN
            4 -> return TianGan.REN
            5 -> return TianGan.GUI
            6 -> return TianGan.DING
            7 -> return TianGan.BING
            8 -> return TianGan.YI
        }
        return 0
    }

    private fun setTianPan() {
        val stg = hourGZ.mTg.tianGan
        mXunShou = findXunShou(hourGZ)
        println("旬首为$mXunShou")
        zhifu = -1
        val xunshou = mXunShou!!.tianGan
        for (i in diPan_qiyi.indices) {
            if (diPan_qiyi[i]!!.tianGan == xunshou) {
                zhifu = i
            }
        }
        println("值符为:" + JiuXing(zhifu))
        println("值使门为:" + BaMen(zhifu))

        //System.out.println("[值符落宫：]="+zhifu);
        //查找值符的后天八卦序数
        val htbgxs = houTianBaGua_full[zhifu]
        //System.out.println("[值符门后天八卦序数：]="+htbgxs);
        //时辰的天干落宫的后天八卦序数
        val sghtbg = (htbgxs + hourGZ.mTg.tianGan) % 9
        //System.out.println("[时辰天干落宫的后天八卦序数：]="+sghtbg);

        //通过时干的后天八卦序数反查位置
        var zhishimen = 0
        for (i3 in houTianBaGua_full.indices) {
            if (houTianBaGua_full[i3] == sghtbg) {
                zhishimen = i3
            }
        }

        //System.out.println("[值使门落宫：]="+zhishimen);
        for (i4 in 0..7) {
            tianPan_BaMen[(i4 + zhishimen) % 8] = BaMen(i4 + zhifu)
        }
        var shiganluogong = 0
        //值符随时干，查找时干落宫
        for (i6 in 0..7) {
            if (diPan_qiyi[i6]!!.tianGan == stg) {
                shiganluogong = i6
            }
        }
        for (i1 in 0..7) {
            tianPan_Jiuxing[(i1 + shiganluogong) % 8] = JiuXing(zhifu + i1)
            tianPan_qiyi[(i1 + shiganluogong) % 8] = diPan_qiyi[(zhifu + i1) % 8]
            baShen[(i1 + shiganluogong) % 8] = BaShen(i1)
            //this.tianPan_BaMen[(i1+)%8]=new BaMen(i1);
        }
        tianPan_qiyi[8] = diPan_qiyi[8]

        //排隐干
        var yingan = 0
        for (i5 in 0..7) {
            if (tianPan_BaMen[i5]?.men == zhifu) {
                yingan = i5
            }
        }
        println("[Debug]yingan=$yingan")
        for (i6 in 0..7) {
            yinGan[(yingan + i6) % 8] = diPan_qiyi[(shiganluogong + i6) % 8]
        }
        kongAndMa
        println("---------")
        println("|" + yinGan[3].toString() + mKongMa[3] + "  |" + yinGan[4].toString() + mKongMa[4] + "  |" + yinGan[5] + mKongMa[5] + "  |")
        println("|" + baShen[3].toString() + "  |" + baShen[4].toString() + "  |" + baShen[5] + "  |")
        println(
            "|" + tianPan_qiyi[3].toString() + tianPan_Jiuxing[3].toString() + "|" + tianPan_qiyi[4].toString() + tianPan_Jiuxing[4].toString() + "|"
                    + tianPan_qiyi[5].toString() + tianPan_Jiuxing[5] + "|"
        )
        println(
            ("|" + diPan_qiyi[3].toString() + tianPan_BaMen[3].toString() + "|" + diPan_qiyi[4].toString() + tianPan_BaMen[4].toString() + "|"
                    + diPan_qiyi[5].toString() + tianPan_BaMen[5] + "|")
        )
        println("---------")
        println("|" + yinGan[2].toString() + mKongMa[2] + "  |" + "  " + "  |" + yinGan[6] + mKongMa[6] + "  |")
        println("|" + baShen[2].toString() + " |" + "中 " + " |" + baShen[6] + " |")
        println(
            ("|" + tianPan_qiyi[2].toString() + tianPan_Jiuxing[2].toString() + "|" + tianPan_qiyi[8].toString() + "禽" + "|"
                    + tianPan_qiyi[6].toString() + tianPan_Jiuxing[6] + "|")
        )
        println(
            ("|" + diPan_qiyi[2].toString() + tianPan_BaMen[2].toString() + "|" + diPan_qiyi[8].toString() + "中" + "|"
                    + diPan_qiyi[6].toString() + tianPan_BaMen[6] + "|")
        )
        println("---------")
        println("|" + yinGan[1].toString() + mKongMa[1] + "  |" + yinGan[0].toString() + mKongMa[0] + "  |" + yinGan[7] + mKongMa[7] + "  |")
        println("|" + baShen[1].toString() + " |" + baShen[0].toString() + " |" + baShen[7] + " |")
        println(
            ("|" + tianPan_qiyi[1].toString() + tianPan_Jiuxing[1].toString() + "|" + tianPan_qiyi[0].toString() + tianPan_Jiuxing[0].toString() + "|"
                    + tianPan_qiyi[7].toString() + tianPan_Jiuxing[7] + "|")
        )
        println(
            ("|" + diPan_qiyi[1].toString() + tianPan_BaMen[1].toString() + "|" + diPan_qiyi[0].toString() + tianPan_BaMen[0].toString() + "|"
                    + diPan_qiyi[7].toString() + tianPan_BaMen[7] + "|")
        )
        println("---------")
        checkMenPo()
        checkJiXing()
    }

    /**
     * 检查是否有门迫 门迫为八门克所落之宫
     */
    private fun checkMenPo() {
        for (i in 0..7) {
            if (tianPan_BaMen[i]!!.isKe((diPan_bagua[i])!!)) {
                println("门迫：" + tianPan_BaMen[i] + "克" + diPan_bagua[i])
                println(tianPan_BaMen[i]!!.xing.toString() + "克" + diPan_bagua[i]!!.xing)
            }
        }
    }

    /**
     * 击刑：十干也所落之宫构成三刑。
     *
     *
     * 甲子戊落震三宫，子卯刑
     *
     *
     * 甲戌己落坤二宫，戌未刑
     *
     *
     * 甲申庚落艮八宫，申寅刑
     *
     *
     * 甲午辛落离九宫，午自刑
     *
     *
     * 甲辰壬落巽四宫，辰自刑
     *
     *
     * 甲寅癸落巽四宫，寅巳刑
     *
     *
     */
    private fun checkJiXing() {
        for (i in 0..7) {
            when (tianPan_qiyi[i]!!.tianGan) {
                TianGan.WU -> if (diPan_bagua[i]!!.gua == BaGua.ZHEN) {
                    println("甲子戊落震三宫，子卯刑")
                }

                TianGan.JI -> if (diPan_bagua[i]!!.gua == BaGua.KUN) {
                    println("甲戌己落坤二宫，戌未刑")
                }

                TianGan.GENG -> if (diPan_bagua[i]!!.gua == BaGua.GEN) {
                    println("甲申庚落艮八宫，申寅刑")
                }

                TianGan.XIN -> if (diPan_bagua[i]!!.gua == BaGua.LI) {
                    println("甲午辛落离九宫，午自刑")
                }

                TianGan.REN -> if (diPan_bagua[i]!!.gua == BaGua.XUN) {
                    println("甲辰壬落巽四宫，辰自刑")
                }

                TianGan.GUI -> if (diPan_bagua[i]!!.gua == BaGua.XUN) {
                    println("甲寅癸落巽四宫，寅巳刑")
                }
            }
        }
    }

    private val kongAndMa: Unit
        private get() {
            for (i in 0..7) {
                val sb = StringBuilder(2)
                if (isKongWang(i)) {
                    sb.append("空")
                }
                if (isMaXing(i)) {
                    sb.append("马")
                }
                mKongMa[i] = sb.toString()
            }
        }

    private fun isKongWang(gong: Int): Boolean {
        val xunshou = findXunShou(hourGZ)!!.tianGan
        when (xunshou) {
            TianGan.WU -> return gong == 7
            TianGan.JI -> return gong == 5 || gong == 6
            TianGan.GENG -> return gong == 4 || gong == 5
            TianGan.XIN -> return gong == 3
            TianGan.REN -> return gong == 1 || gong == 2
            TianGan.GUI -> return gong == 0 || gong == 1
        }
        return false
    }

    private fun isMaXing(gong: Int): Boolean {
        val shiZhi = hourGZ.mDz.diZhi
        when (shiZhi % 4) {
            0 -> return gong == 1
            1 -> return gong == 7
            2 -> return gong == 5
            3 -> return gong == 3
        }
        return false
    }

    /**
     * 寻找旬首
     *
     * @return
     */
    private fun findXunShou(shiZhu: GanZhi): TianGan? {
        val tg = shiZhu.mTg.tianGan
        val dz = shiZhu.mDz.diZhi

        //得到的差值是地支
        val value = (dz - tg + 12) % 12
        when (value) {
            0 ->                 //甲子戊
                return TianGan(TianGan.WU)

            10 ->                 //甲戌己
                return TianGan(TianGan.JI)

            8 ->                 //甲申庚
                return TianGan(TianGan.GENG)

            6 ->                 //甲午辛
                return TianGan(TianGan.XIN)

            4 ->                 //甲辰壬
                return TianGan(TianGan.REN)

            2 ->                 //甲寅癸
                return TianGan(TianGan.GUI)
        }
        return null
    }

    /**
     * 设置地盘六仪三奇
     */
    private fun setDiPan() {
        if (mYang) {
            //阳遁，后天八卦
            for (i in 0..8) {
                diPan_qiyi[(yangDunOrder[(i + mJu - 1) % 9]) % 9] = TianGan(getQiyi(i))
            }
        } else {
            //阴遁
            for (i in 0..8) {
                diPan_qiyi[(yinDunOrder[(i + mJu - 1) % 9]) % 9] = TianGan(getQiyi(i))
            }
        }
        for (i in 0..7) {
            diPan_bagua[i] = BaGua(i + 1)
        }
        println("---------")
        println("|" + diPan_qiyi[3].toString() + "|" + diPan_qiyi[4].toString() + "|" + diPan_qiyi[5] + "|")
        println("---------")
        println("|" + diPan_qiyi[2].toString() + "|" + diPan_qiyi[8].toString() + "|" + diPan_qiyi[6] + "|")
        println("---------")
        println("|" + diPan_qiyi[1].toString() + "|" + diPan_qiyi[0].toString() + "|" + diPan_qiyi[7] + "|")
        println("---------")
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append((YinYang(mYang)).toString()).append("遁").append(mJu)
            .append("局")
        return sb.toString()
    }
}
