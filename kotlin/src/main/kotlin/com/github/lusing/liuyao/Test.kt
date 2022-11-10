package com.github.lusing.liuyao

import com.github.lusing.qimen.TianGan

class Test {
    fun test(){
        //val gua = Gua64(0b001111)
        var yaos = arrayOf(6, 7, 7, 7, 7, 8)
        val gua = Gua64(yaos, TianGan.JIA)
        println(gua.getName())
        gua.debug()
//        var bianGua = gua.getBianGua()
//        println(bianGua.getName())
//        bianGua.debug()

        var liuyao1 = LiuYao(gua)
        liuyao1.paiPan()
    }
}
