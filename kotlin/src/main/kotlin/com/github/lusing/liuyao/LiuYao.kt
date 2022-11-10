package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin
import com.github.lusing.qimen.TianGan

class LiuYao constructor(gua: Gua64) {
    var benGua = gua
    lateinit var bianGua: Gua64
    fun paiPan() {
        this.bianGua = benGua.getBianGua()
        println(this.bianGua.getName())

        println("宫:${benGua.gong.getName()}")

        for (i in 0..5) {
            print("${benGua.yaos[i].liuShen.getName()} ")
            if (benGua.yaos[i].isYang) {
                print("- ")
            } else {
                print("= ")
            }
            print(benGua.yaos[i].lq.getName())
            print(benGua.yaos[i].naZhi.getName())
            var xing = benGua.yaos[i].naZhi.xing
            print(xing.toString())
            if (benGua.yaos[i].isShi) {
                print(" 世")
            } else if (benGua.yaos[i].isYing) {
                print(" 应")
            }
            println()
        }
    }
}
