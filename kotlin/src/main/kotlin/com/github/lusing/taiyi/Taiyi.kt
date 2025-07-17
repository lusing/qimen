package com.github.lusing.taiyi

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi

class Taiyi (var year: Int){
    val jinian = year + jiNianShu
    val gz = GanZhi(year)
    val taisui = getTaiSui()
    val heshen = getHeShen()
    val jishen = getJiShen(true)
    // 年家太乙的局数
    fun Ju() : Int{
        println("${year} 积年数：${jinian}")
        val A =  jinian % 360
        println("A=${A}")
        val B = A % 72
        println("B=${B}")
        return B
    }

    // 太岁

    fun getTaiSui() : DiZhi{
        println("太岁为:${gz.mDz.getName()}")
        return gz.mDz
    }

    // 合神

    fun getHeShen() : DiZhi {
        println("合神为:${taisui.getHe().getName()}")
        return taisui.getHe()
    }

    // 计神
    fun getJiShen(yang : Boolean) : DiZhi {
        //println(yang)
        val start = if(yang)  DiZhi.YIN else  DiZhi.SHEN
        //println(start)
        var js = DiZhi(12 - this.taisui.diZhi + start)
        println("计神为:${js.getName()}")
        return js
    }

    fun getTaiyi() : Int {
        return calcTaiyi(this.jinian % 24,true)
    }

    fun getWenChang() {
        val A = this.jinian % 18
        println("文昌要走${A}步")
    }

    companion object{
        const val jiNianShu = 10153917
        fun calcTaiyi(year:Int,yang: Boolean=true) : Int{
            var A= year - 1
            if(A<0){
                A=23
            }
            var B = A / 3
            var C = A % 3
            A = A+1
            B = B+1
            C = C+1
            if(B>=5){
                B=B+1
            }
            if(!yang){
                B=10-B
            }
            println("太乙在本輪${A}年,${B}宮,${C}年")
            return B
        }
    }
}
