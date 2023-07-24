package com.github.lusing.qimen

import com.github.lusing.liuyao.YongShen

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

    // 婚恋
    fun romance(yongShen: TianGan, isMan: Boolean) {
        println("==================断婚姻=======================")
        println("用神为：${yongShen.toString()}")
        println("${yongShen.getRomance()}")
        val cell_yong = this.dunJiaPan.getCell(yongShen)
        println("${cell_yong.baShen?.getRomance()}")
        println("${cell_yong.jiuXing?.getRomance()}")
        println("${cell_yong.baMen?.getRomance()}")

        if (cell_yong.diPanQiYi == cell_yong.tianPanQiYi) {
            println("伏吟局：呻吟不安，有重叠之意。表示婚恋不利。未婚者找对象波澜曲折，阴差阳错，晚婚之象。已婚者必然二婚或多婚。")
        }
        if (cell_yong.baShen!!.mShen == BaShen.FU) {
            println("用神遇值符，主婚姻会出现问题")
        }
        if (cell_yong.kongWang) {
            println("虚无缥缈，捉摸不定。用神遇空亡，对婚恋不利。")
        }
        if (cell_yong.tianPanQiYi.jigong != null) {
            println("寄人篱下，被人为奴。代表用神有双夫或双妻")
        }

        //与日干相合者为配偶
        val peiOu = yongShen.getHe()
        println("配偶为：${peiOu.toString()}")
        println("${peiOu.getRomance()}")

        if (yongShen.isYang == isMan) {
            println("正配的婚姻一般比较好")
        } else {
            println("反配夫妻不太好，婚姻容易出问题")
        }

        val cell_darling = this.dunJiaPan.getCell(peiOu)
        println("${cell_darling.baShen?.getRomance()}")
        println("${cell_darling.jiuXing?.getRomance()}")
        println("${cell_darling.baMen?.getRomance()}")

        if (cell_darling.diPanQiYi == cell_darling.tianPanQiYi) {
            println("伏吟局：呻吟不安，有重叠之意。表示婚恋不利。未婚者找对象波澜曲折，阴差阳错，晚婚之象。已婚者必然二婚或多婚。")
        }
        if (cell_darling.baShen?.mShen == BaShen.FU) {
            println("配偶遇值符，主婚姻会出现问题")
        }
        if (cell_darling.kongWang) {
            println("虚无缥缈，捉摸不定。配偶遇空亡，对婚恋不利。")
        }
        if (cell_darling.tianPanQiYi.jigong != null) {
            println("寄人篱下，被人为奴。代表用神有双夫或双妻")
        }


        println("=========================================")
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
