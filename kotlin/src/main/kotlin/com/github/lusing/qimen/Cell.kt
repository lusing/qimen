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

    fun display() {
        //print("$baGua$id")
        print("${diPanQiYi.qiyi.toString()}${diPanQiYi.jigong?.toString() ?: ""}${jiuXing.toString()}${tianPanQiYi.qiyi.toString()}")
        print("${baShen}")
        print("${baMen}")
    }
}