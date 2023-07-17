package com.github.lusing.qimen

class Cell {
    var id: Int = 0
    lateinit var baGua: BaGua
    var diPanQiYi: QiYi = QiYi()
    var tianPanQiYi: QiYi = QiYi()
    var diPanJiuXing: JiuXing? = null
    var diPanBaMen: BaMen? = null
    var jiuXing: JiuXing? = null
    var baMen: BaMen? = null
    var baShen: BaShen? = null
    var yinGan: QiYi = QiYi()
    var maXing: Boolean = false
    var kongWang: Boolean = false


    /**
     * 检查是否有门迫 门迫为八门克所落之宫
     */
    fun checkMenPo(): Boolean {
        return if (this.baMen!!.isKe(this.baGua)) {
            println("门迫：${baMen!!.toString()}克${baGua.toString()}")
            true
        } else {
            false
        }
    }

    fun checkJiXing() {
        // 戊三己二庚刑八，辛九壬四癸半八
        when (tianPanQiYi.qiyi.tianGan) {
            TianGan.WU -> if (this.baGua.gua == BaGua.ZHEN) {
                println("甲子戊落震三宫，子卯刑")
            }

            TianGan.JI -> if (this.baGua.gua == BaGua.KUN) {
                println("甲戌己落坤二宫，戌未刑")
            }

            TianGan.GENG -> if (this.baGua.gua == BaGua.GEN) {
                println("甲申庚落艮八宫，申寅刑")
            }

            TianGan.XIN -> if (this.baGua.gua == BaGua.LI) {
                println("甲午辛落离九宫，午自刑")
            }

            TianGan.REN -> if (this.baGua.gua == BaGua.XUN) {
                println("甲辰壬落巽四宫，辰自刑")
            }

            TianGan.GUI -> if (this.baGua.gua == BaGua.XUN) {
                println("甲寅癸落巽四宫，寅巳刑")
            }
        }
    }

    fun getKongWang(): String {
        return if (this.kongWang) "空" else " "
    }

    fun checkRuMu(): Boolean {
        when (tianPanQiYi.qiyi.tianGan) {
            TianGan.JIA, TianGan.GUI ->
                return if (this.id == 2) {
                    println("${this.tianPanQiYi.qiyi.toString()}落坤二宫入墓")
                    true
                } else {
                    false
                }

            TianGan.XIN, TianGan.REN ->
                return if (this.id == 4) {
                    println("${this.tianPanQiYi.qiyi.toString()}落巽四宫入墓")
                    true
                } else {
                    false
                }

            TianGan.YI, TianGan.BING, TianGan.WU ->
                return if (this.id == 6) {
                    println("${this.tianPanQiYi.qiyi.toString()}落乾六宫入墓")
                    true
                } else {
                    false
                }

            TianGan.DING, TianGan.JI, TianGan.GENG ->
                return if (this.id == 8) {
                    println("${this.tianPanQiYi.qiyi.toString()}落艮八宫入墓")
                    true
                } else {
                    false
                }

            else -> return false
        }
    }

    fun getYinGan(): String {
        var s = ""
        s += yinGan.qiyi.toString()
        s += yinGan.jigong?.toString() ?: " "
        return s
    }

    fun getQiYi(): String {
        var s = ""
        s += diPanQiYi.qiyi.toString()
        s += diPanQiYi.jigong?.toString() ?: " "
        return s
    }

    fun getTianPanQiYi(): String {
        var s = ""
        s += tianPanQiYi.qiyi.toString()
        s += tianPanQiYi.jigong?.toString() ?: " "
        return s
    }

    fun getMaXing(): String {
        return if (this.maXing) "马" else " "
    }

    fun display() {
        //print("$baGua$id")
        print("${getQiYi()}${jiuXing.toString()}${tianPanQiYi.qiyi.toString()}")
        print("${baShen}")
        print("${baMen}")
    }
}