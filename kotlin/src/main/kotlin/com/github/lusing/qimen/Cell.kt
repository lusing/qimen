package com.github.lusing.qimen

class Cell {
    var id : Int = 0
    lateinit var baGua: BaGua
    var diPanQiYi: QiYi = QiYi()
    var tianPanQiYi: QiYi = QiYi()
    lateinit var diPanJiuXing : JiuXing
    var jiuXing: JiuXing? = null
    var baMen: BaMen? = null
    var baShen: BaShen? = null

    fun display() {
        //print("$baGua$id")
        print("${diPanQiYi.qiyi.toString()}${diPanQiYi.jigong?.toString() ?: ""}")
    }
}