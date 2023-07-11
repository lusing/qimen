package com.github.lusing.qimen

class Cell {
    var id : Int = 0
    var baGua: BaGua? = null
    var diPanQiYi: QiYi? = null
    var tianPanQiYi: QiYi? = null
    var jiuXing: JiuXing? = null
    var baMen: BaMen? = null
    var baShen: BaShen? = null

    fun display() {
        println("ID: $id")
        println("八卦：$baGua")
    }
}