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

    private val dunJiaPan: DunJiaPan = DunJiaPan()

    /**
     * 地盘上的奇仪
     */
    private val tianPan_qiyi = arrayOfNulls<TianGan>(9)
    private val tianPan_BaMen = arrayOfNulls<BaMen>(8)
    private var mXunShou: TianGan? = null
    private val mKongMa = arrayOfNulls<String>(8)

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
        mDay = day
        mYang = yang
        setJu()
        setTianPan()
        dunJiaPan.display()
    }

    private fun setJu() {
        val yearNo = yearGZ.mDz.diZhi + 1
        val hourNo = hourGZ.mDz.diZhi + 1
        mJu = (yearNo + mMonth + mDay + hourNo) % 9
        dunJiaPan.setJu(mJu, mYang)
        dunJiaPan.mShiGan = hourGZ.mTg
    }

    private fun setTianPan() {
        mXunShou = findXunShou(hourGZ)
        println("旬首为$mXunShou")
        this.dunJiaPan.mXunShou = this.mXunShou!!
        this.dunJiaPan.findXunShou()
        val zhifu2 = this.dunJiaPan.getZhiFu()
        println("值符为:" + zhifu2)
        val shiGan2 = this.dunJiaPan.findShiGan()
        println("时干落${shiGan2}宫")
        this.dunJiaPan.setTianPan()
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
        when (findXunShou(hourGZ)!!.tianGan) {
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
        when ((dz - tg + 12) % 12) {
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

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append((YinYang(mYang)).toString()).append("遁").append(mJu)
            .append("局")
        return sb.toString()
    }
}
