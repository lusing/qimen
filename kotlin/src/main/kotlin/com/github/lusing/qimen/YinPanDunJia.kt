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
    private var mXunShou: TianGan? = null


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
        dunJiaPan.mShiZhi = hourGZ.mDz
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
