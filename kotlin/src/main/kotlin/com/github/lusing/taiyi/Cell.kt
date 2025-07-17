package com.github.lusing.taiyi

import com.github.lusing.qimen.DiZhi

class Cell {
    var gongNum : Int = 0
    var name : String = ""
    var jianShenName : String = ""
    var dz : DiZhi? = null
    val shenList = mutableListOf<XingShen>()
    constructor(num: Int, name: String,jcName: String,diZhi: DiZhi?=null){
        this.gongNum = num
        this.name = name
        this.jianShenName = jcName
        this.dz = diZhi
    }

    fun printShen(){
        for(i in shenList){
            print(i.name)
            print("<br>")
        }
    }
}
