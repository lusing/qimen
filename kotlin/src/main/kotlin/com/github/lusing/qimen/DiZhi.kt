package com.github.lusing.qimen

class DiZhi(idz: Int) {
    val diZhi: Int

    init {
        diZhi = (idz + 12) % 12
    }

    fun getNext(): DiZhi {
        return DiZhi((diZhi + 1) % 12)
    }

    fun getPrev(): DiZhi {
        return DiZhi((diZhi + 11) % 12)
    }

    override fun toString(): String {
        return (sDiZhi[diZhi]).toString()
    }

    fun getName(): String {
        return this.toString()
    }

    val xing: WuXing
        get() {
            var xing = -1
            xing = when (diZhi) {
                YIN, MAO -> WuXing.MU
                SI, WU -> WuXing.HUO
                CHEN, XU, CHOU, WEI -> WuXing.TU
                SHEN, YOU -> WuXing.JIN
                HAI, ZI -> WuXing.SHUI
                else -> WuXing.MU
            }
            return WuXing(xing)
        }

    /**
     * 获取地支中的藏干
     * @return
     */
    val cangGan: List<TianGan>
        get() {
            var tgList = listOf<TianGan>()
            when (diZhi) {
                ZI -> tgList = tgList.plusElement(TianGan(TianGan.GUI))
                CHOU -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.JI), TianGan(TianGan.GUI), TianGan(TianGan.XIN)))
                }

                YIN -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.JIA), TianGan(TianGan.BING), TianGan(TianGan.WU)))
                }

                MAO -> tgList = tgList.plusElement(TianGan(TianGan.YI))
                CHEN -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.WU), TianGan(TianGan.JI), TianGan(TianGan.GUI)))
                }

                SI -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.BING), TianGan(TianGan.WU), TianGan(TianGan.GENG)))
                }

                WU -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.DING), TianGan(TianGan.JI)))
                }

                WEI -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.JI), TianGan(TianGan.YI), TianGan(TianGan.DING)))
                }

                SHEN -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.GENG), TianGan(TianGan.REN), TianGan(TianGan.WU)))
                }

                YOU -> tgList = tgList.plusElement(TianGan(TianGan.XIN))

                XU -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.WU), TianGan(TianGan.XIN), TianGan(TianGan.DING)))
                }

                HAI -> {
                    tgList = tgList.plus(listOf(TianGan(TianGan.REN), TianGan(TianGan.JIA)))
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

    // 相冲
    fun isChong(dz2: DiZhi): Boolean {
        return dz2.diZhi == (this.diZhi + 6) % 12
    }

    // 相害
    fun isHai(dz2: DiZhi): Boolean {
        return ((this.diZhi + dz2.diZhi) % 12) == 7
    }

    // 相刑
    fun isXing2(dz2: DiZhi): Boolean {
        val d1 = this.diZhi
        val d2 = dz2.diZhi

        // 自刑
        if (d1 == CHEN && d2 == CHEN) {
            println("${this.diZhi.toString()}自刑")
            return true
        }
        if (d1 == WU && d2 == WU) {
            println("${this.diZhi.toString()}自刑")
            return true
        }
        if (d1 == YOU && d2 == YOU) {
            println("${this.diZhi.toString()}自刑")
            return true
        }
        if (d1 == HAI && d2 == HAI) {
            println("${this.diZhi.toString()}自刑")
            return true
        }

        // 无礼之刑
        val wu_li_xing = arrayOf(ZI, MAO)
        if (d1 in wu_li_xing && d2 in wu_li_xing) {
            println("无礼之刑")
            return true
        }

        // 无恩之刑
        val wu_en_xing = arrayOf(YIN, SI, SHEN)
        if (d1 in wu_en_xing && d2 in wu_en_xing) {
            println("无恩之刑")
            return true
        }

        // 恃势之刑
        val shi_shi_xing = arrayOf(CHOU, XU, WEI)
        if (d1 in shi_shi_xing && d2 in shi_shi_xing) {
            println("恃势之刑")
            return true
        }

        return false
    }

    /*
     * 0与1合
     * 2与11合
     * 3与10合
     * 4与9合
     * 5与8合
     * 6与7合
     */
    fun isHe(dz2: DiZhi): Boolean {
        return (dz2.diZhi + this.diZhi + 12) % 12 == 1
    }

    fun getHe(): DiZhi {
        return DiZhi(13 - this.diZhi)
    }

    fun getMuKu(x: WuXing): DiZhi {
        when (x.xing) {
            WuXing.SHUI -> return DiZhi(CHEN) // 水库辰
            WuXing.MU -> return DiZhi(WEI) // 土库未
            WuXing.JIN -> return DiZhi(CHOU) // 金库丑
            else -> return DiZhi(XU) // 火土为戌
        }
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
