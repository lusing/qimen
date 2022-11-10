package com.github.lusing.liuyao

class Test {
    fun test(){
        //val gua = Gua64(0b001111)
        var yaos = arrayOf(6, 6, 6, 9, 9, 9)
        val gua = Gua64(yaos)
        println(gua.getName())
        gua.debug()
        var bianGua = gua.getBianGua()
        println(bianGua.getName())
        bianGua.debug()
    }
}
