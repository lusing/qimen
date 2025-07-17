package com.github.lusing.taiyi

class Cell {
    var gongNum : Int = 0
    var name : String = ""
    var jianShenName : String = ""
    val shenList = mutableListOf<XingShen>()
    constructor(num: Int, name: String,jcName: String){
        this.gongNum = num
        this.name = name
        this.jianShenName = jcName
    }

    fun printShen(){
        for(i in shenList){
            print(i.name)
            print("<br>")
        }
    }
}
