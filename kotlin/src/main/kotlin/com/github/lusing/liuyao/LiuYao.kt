package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi

class LiuYao constructor(gua: Gua64, yueJian: Int, riJian : Int) {
    var benGua = gua
    val yueJian = DiZhi(yueJian)
    val riJian = DiZhi(riJian)
    lateinit var bianGua: Gua64
    fun paiPan() {
        print(this.benGua.getName())
        print("            ")
        this.bianGua = benGua.getBianGua()
        println(this.bianGua.getName())

        println("宫:${benGua.gong.getName()}")

        for (i in 5 downTo 0) {
            print("${benGua.yaos[i].liuShen.getName()} ")
            if (benGua.yaos[i].isYang) {
                print("-")
            } else {
                print("=")
            }
            if(benGua.yaos[i].isChange){
                print("*")
            }else{
                print(" ")
            }
            if (benGua.yaos[i].fuShen != null) {
                print(benGua.yaos[i].fuShen!!.lq.getName())
                print(benGua.yaos[i].fuShen!!.naZhi.getName())
                val xing2 = benGua.yaos[i].fuShen!!.naZhi.xing
                print(xing2.toString())
                print(" ")
            }else{
                print("       ")
            }

            print(benGua.yaos[i].lq.getName())
            print(benGua.yaos[i].naZhi.getName())
            var xing = benGua.yaos[i].naZhi.xing
            print(xing.toString())
            if (benGua.yaos[i].isShi) {
                print(" 世 ")
            } else if (benGua.yaos[i].isYing) {
                print(" 应 ")
            }else{
                print("   ")
            }

            if (this.bianGua.yaos[i].isYang) {
                print("- ")
            } else {
                print("= ")
            }
            print(this.bianGua.yaos[i].lq.getName())
            print(this.bianGua.yaos[i].naZhi.getName())
            val xing3 = this.bianGua.yaos[i].naZhi.xing
            print(xing3.toString())
            if (this.bianGua.yaos[i].isShi) {
                print(" 世")
            } else if (this.bianGua.yaos[i].isYing) {
                print(" 应")
            }
            println()
        }
    }
}
