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
        val B = A % 60
        println("B=${B}")
        val C = B % 72
        println("C=${C}")
        return C
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

    fun getTaiyi()  {
        val A = this.jinian % 24
        var B = A
        var C = 0
        if (A>3){
            B = A / 3
            C = B % 3
        }
        println(this.jinian)
        println("太乙要走的宫位数=${A},${B},${C}")
        val D = 1 + B
        println("落宫${D}宫,第${C+1}年")
    }


    fun getWenChang() {
        val A = this.jinian % 18
        println("文晶要走${A}步")
    }

    companion object{
        const val jiNianShu = 10155901 - 1984
    }
}
