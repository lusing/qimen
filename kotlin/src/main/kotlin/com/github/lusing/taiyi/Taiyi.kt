package com.github.lusing.taiyi

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi

class Taiyi (var year: Int){
    val jiNianShu = 10155901 - 1984
    val gz = GanZhi(year)
    val taisui = getTaiSui()
    val heshen = getHeShen()
    val jishen = getJiShen(false)

    // 年家太乙的局数
    fun Ju() : Int{
        val jinian = year + jiNianShu
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
        val start = if(yang)  {DiZhi.YIN} else  DiZhi.SHEN
        var js = DiZhi(12 - this.taisui.diZhi + start)
        println("计神为:${js.getName()}")
        return js
    }
}
