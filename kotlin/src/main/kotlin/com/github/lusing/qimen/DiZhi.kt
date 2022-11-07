package com.github.lusing.qimen

class DiZhi(idz: Int) {
    val diZhi: Int

    init {
        diZhi = (idz + 12) % 12
    }

    override fun toString(): String {
        return (sDiZhi[diZhi]).toString()
    }

    val xing: WuXing?
        get() {
            var xing = -1
            xing = when (diZhi) {
                YIN, MAO -> WuXing.MU
                SI, WU -> WuXing.HUO
                CHEN, XU, CHOU, WEI -> WuXing.TU
                SHEN, YOU -> WuXing.JIN
                HAI, ZI -> WuXing.SHUI
                else -> return null
            }
            return WuXing(xing)
        }

    /**
     * 获取地支中的藏干
     * @return
     */
    val cangGan: ArrayList<TianGan>
        get() {
            val tgList = ArrayList<TianGan>()
            when (diZhi) {
                ZI -> tgList.add(TianGan(TianGan.GUI))
                CHOU -> {
                    tgList.add(TianGan(TianGan.JI))
                    tgList.add(TianGan(TianGan.GUI))
                    tgList.add(TianGan(TianGan.XIN))
                }
                YIN -> {
                    tgList.add(TianGan(TianGan.JIA))
                    tgList.add(TianGan(TianGan.BING))
                    tgList.add(TianGan(TianGan.WU))
                }
                MAO -> tgList.add(TianGan(TianGan.YI))
                CHEN -> {
                    tgList.add(TianGan(TianGan.WU))
                    tgList.add(TianGan(TianGan.JI))
                    tgList.add(TianGan(TianGan.GUI))
                }
                SI -> {
                    tgList.add(TianGan(TianGan.BING))
                    tgList.add(TianGan(TianGan.WU))
                    tgList.add(TianGan(TianGan.GENG))
                }
                WU -> {
                    tgList.add(TianGan(TianGan.DING))
                    tgList.add(TianGan(TianGan.JI))
                }
                WEI -> {
                    tgList.add(TianGan(TianGan.JI))
                    tgList.add(TianGan(TianGan.YI))
                    tgList.add(TianGan(TianGan.DING))
                }
                SHEN -> {
                    tgList.add(TianGan(TianGan.GENG))
                    tgList.add(TianGan(TianGan.REN))
                    tgList.add(TianGan(TianGan.WU))
                }
                YOU -> tgList.add(TianGan(TianGan.XIN))
                XU -> {
                    tgList.add(TianGan(TianGan.WU))
                    tgList.add(TianGan(TianGan.XIN))
                    tgList.add(TianGan(TianGan.DING))
                }
                HAI -> {
                    tgList.add(TianGan(TianGan.REN))
                    tgList.add(TianGan(TianGan.JIA))
                }
                else -> {}
            }
            return tgList
        }

    //System.out.println(this.toString()+"的本气为"+new TianGan(tg).toString());
    val benQin: TianGan
        get() {
            var tg = -1
            when (diZhi) {
                ZI -> tg = TianGan.GUI
                CHOU -> tg = TianGan.JI
                YIN -> tg = TianGan.JIA
                MAO -> tg = TianGan.YI
                CHEN -> tg = TianGan.WU
                SI -> tg = TianGan.BING
                WU -> tg = TianGan.DING
                WEI -> tg = TianGan.JI
                SHEN -> tg = TianGan.GENG
                YOU -> tg = TianGan.XIN
                XU -> tg = TianGan.WU
                HAI -> tg = TianGan.REN
                else -> {}
            }
            //System.out.println(this.toString()+"的本气为"+new TianGan(tg).toString());
            return TianGan(tg)
        }

    fun isKe(dz2: DiZhi): Boolean {
        return xing!!.isKe(dz2.xing!!)
    }

    fun isSheng(dz2: DiZhi): Boolean {
        return xing!!.isSheng(dz2.xing!!)
    }

    companion object {
        /**
         * 子
         */
        const val ZI = 0

        /**
         * 丑
         */
        const val CHOU = 1

        /**
         * 寅
         */
        const val YIN = 2

        /**
         * 卯
         */
        const val MAO = 3

        /**
         * 辰
         */
        const val CHEN = 4

        /**
         * 巳
         */
        const val SI = 5

        /**
         * 午
         */
        const val WU = 6

        /**
         * 未
         */
        const val WEI = 7

        /**
         * 申
         */
        const val SHEN = 8

        /**
         * 酉
         */
        const val YOU = 9

        /**
         * 戌
         */
        const val XU = 10

        /**
         * 亥
         */
        const val HAI = 11
        const val sDiZhi = "子丑寅卯辰巳午未申酉戌亥"
        fun isHe(dz1: Int, dz2: Int): WuXing {
            var xing = -1
            if (dz1 == YIN && dz2 == HAI) {
                xing = WuXing.MU
            } else if (dz1 == MAO && dz2 == XU) {
                xing = WuXing.HUO
            }
            return WuXing(xing)
        }

        /**
         * 通过月地支和时地支计算命宫
         * @param yueDZ - 月地支
         * @param shiDZ - 时地支
         * @return 命宫地支
         */
        fun getMingGong(yueDZ: DiZhi, shiDZ: DiZhi): DiZhi {
            val dzsum = yueDZ.diZhi - 1 + shiDZ.diZhi - 1
            return DiZhi((14 - dzsum + 1) % 12)
        }
    }
}
