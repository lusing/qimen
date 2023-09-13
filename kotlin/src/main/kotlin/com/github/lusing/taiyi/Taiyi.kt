package com.github.lusing.taiyi

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi

class Taiyi (var year: Int){
    val jiNianShu = 10155901 - 1984
    val gz = GanZhi(year)

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

    fun taiSui() : DiZhi{
        println("太岁为:${gz.mDz.getName()}")
        return gz.mDz
    }
}
