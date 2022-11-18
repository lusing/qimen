package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin
import com.github.lusing.qimen.TianGan
import com.github.lusing.qimen.WuXing

class Test {
    fun test() {
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

        val yaos2 = arrayOf(7, 8, 8, 6, 8, 8)
        val gua2 = Gua64(yaos2, TianGan.JI)
        val ly2 = LiuYao(gua2, DiZhi.MAO, DiZhi.MAO, LiuQin.XIONGDI)
        //val bgua = ly2.benGua.getBianGua()
        //bgua.debug()
        //ly2.paiPan()

        val yao3 = arrayOf(7, 8, 7, 6, 7, 8)
        val gua3 = Gua64(yao3, TianGan.BING)
        val ly3 = LiuYao(gua = gua3, yueJian = DiZhi.CHEN, riJian = DiZhi.SHEN, yongShen = LiuQin.XIONGDI)
        ly3.paiPan()

        val yao4 = arrayOf(7, 8, 8, 8, 8, 8)
        val gua4 = Gua64(yao4, TianGan.BING)
        val ly4 = LiuYao(gua = gua4, yueJian = DiZhi.MAO, riJian = DiZhi.CHEN, yongShen = LiuQin.FUMU)
        ly4.paiPan()

        // TODO:这个世应安的不对
        val yao5 = arrayOf(7, 6, 8, 8, 7, 7)
        val gua5 = Gua64(yao5, TianGan.WU)
        val ly5 = LiuYao(gua = gua5, yueJian = DiZhi.CHOU, riJian = DiZhi.ZI, yongShen = LiuQin.QICAI)
        ly5.paiPan()
    }
}
