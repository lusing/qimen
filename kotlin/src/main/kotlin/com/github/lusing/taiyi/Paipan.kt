package com.github.lusing.taiyi

class Paipan {
    fun paipan (year : Int) {
        val ty1 = Taiyi(year)
        println(ty1.Ju())
        println(ty1.getTaiSui())
        println(ty1.getHeShen())
        println(ty1.getJiShen(true))
        println(ty1.getTaiyi())
        println(ty1.getWenChang())
        val tyPan = TaiyiPan()
        tyPan.year(ty1)
        tyPan.walk()
    }
}