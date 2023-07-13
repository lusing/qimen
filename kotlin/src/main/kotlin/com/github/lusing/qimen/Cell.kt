package com.github.lusing.qimen

class Cell {
    var id : Int = 0
    lateinit var baGua: BaGua
    var diPanQiYi: QiYi = QiYi()
    var tianPanQiYi: QiYi = QiYi()
    var diPanJiuXing : JiuXing? = null
    var diPanBaMen : BaMen? = null
    var jiuXing: JiuXing? = null
    var baMen: BaMen? = null
    var baShen: BaShen? = null
    var yinGan : QiYi = QiYi()
    var maXing : Boolean = false

    fun getYinGan() : String{
        var s = ""
        s += yinGan.qiyi.toString()
        s += yinGan.jigong?.toString() ?: " "
        return s
    }

    fun getQiYi() : String{
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

    fun getMaXing() : String{
        return if (this.maXing) "马" else " "
    }

    fun display() {
        //print("$baGua$id")
        print("${getQiYi()}${jiuXing.toString()}${tianPanQiYi.qiyi.toString()}")
        print("${baShen}")
        print("${baMen}")
    }
}