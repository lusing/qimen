package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin
import com.github.lusing.qimen.TianGan

class Test {
    fun test(){
        //val gua = Gua64(0b001111)
        var yaos = arrayOf(6, 7, 7, 7, 7, 8)
        val gua = Gua64(yaos, TianGan.JIA)
        //println(gua.getName())
        //gua.debug()
//        var bianGua = gua.getBianGua()
//        println(bianGua.getName())
//        bianGua.debug()

        var liuyao1 = LiuYao(gua, DiZhi.MAO, DiZhi.MAO, LiuQin.XIONGDI)
        //liuyao1.paiPan()

        val yaos2 = arrayOf(7,8,8,6,8,8)
        val gua2 = Gua64(yaos2, TianGan.JI)
        val ly2 = LiuYao(gua2, DiZhi.MAO,DiZhi.MAO,LiuQin.XIONGDI)
        //val bgua = ly2.benGua.getBianGua()
        //bgua.debug()
        ly2.paiPan()
    }
}
