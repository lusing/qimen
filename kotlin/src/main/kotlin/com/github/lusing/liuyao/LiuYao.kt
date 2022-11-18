package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin

class LiuYao constructor(gua: Gua64, yueJian: Int, riJian : Int, yongShen: Int) {
    var benGua = gua
    val yueJian = DiZhi(yueJian)
    val riJian = DiZhi(riJian)
    val yongShen = LiuQin(yongShen)
    lateinit var bianGua: Gua64
    fun paiPan() {
        print(this.benGua.getName())
        print("            ")
        this.bianGua = benGua.getBianGua()
        println(this.bianGua.getName())

        //println("宫:${benGua.gong.getName()}")

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
        checkYongShen()
    }

    fun getYaoName(yao: Yao) :String{
        var name = ""
        name = name.plus(yao.lq.getName())
        name = name.plus(yao.naZhi.getName())
        var xing = yao.naZhi.xing
        name = name.plus(xing.toString())
        return name
    }

    fun checkYongShen(){
        var yongshen: Yao? = null
        var level = 0
        var yaoSet = setOf<Yao>()
        for(i in 0..5){
            if(this.benGua.yaos[i].lq == this.yongShen){
                println("用神在本卦第${i+1}爻")
                val yao = this.benGua.yaos[i]
                println(this.getYaoName(yao))
                yaoSet = yaoSet.plus(yao)
            }
        }
        if(yaoSet.size > 1){
            for (yao in yaoSet){
                if(yao.isChange){
                    println("取动爻${this.getYaoName(yao)}为用神")
                    yongshen = yao
                }
            }
        }
        if (yongshen != null){
            var yao1 = yongshen!!
            this.checkJueJian(yao1)
        }
    }

    fun checkJueJian(yao: Yao){
        var value = 0
        if(yao.naZhi.xing.xing == this.yueJian.xing.xing){
            println("爻五行同月建为最旺")
            value += 50
        }else if(this.yueJian.isHe(yao.naZhi)) {
            println("爻地支合月建为次旺")
            value += 30
        }else if(this.yueJian.isSheng(yao.naZhi)) {
            println("爻被月建生为再旺")
            value += 20
        }else if(yao.naZhi.isSheng(this.yueJian)) {
            println("爻生月建为衰")
            value -= 10
        }else if(yao.naZhi.isKe(this.yueJian)) {
            println("爻克月建为衰")
            value -= 10
        }else if(this.yueJian.isKe(yao.naZhi)){
            println("爻被月建克为更衰")
            value -= 20
        }
        if(this.yueJian.isChong(yao.naZhi)) {
            println("爻被月建冲为最衰")
            value -= 50
        }

        if(yao.naZhi.xing.xing == this.riJian.xing.xing) {
            println("爻五行同日建为最旺")
            value += 50
        }else if(this.riJian.isSheng(yao.naZhi)) {
            println("爻被日建生为次旺")
            value += 20
        }else if(yao.naZhi.isSheng(this.riJian)) {
            println("爻生日建为衰")
            value -= 10
        }else if(yao.naZhi.isKe(this.riJian)) {
            println("爻克日建为衰")
            value -= 10
        }else if(this.riJian.isKe(yao.naZhi)) {
            println("爻被日建克为更衰")
            value -= 20
        }
        println(value)
        if(value > 0){
            println("爻为旺")
        }else if(value < 0) {
            println("爻为衰")
        }else{
            println("爻为平")
        }
    }
}