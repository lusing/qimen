package com.github.lusing.liuyao

import com.github.lusing.qimen.WuXing


class Gua8 : WuXing {
    var value: Int
        set

    /*
     * 根据先天八卦数起卦
     */
    constructor(guaNum: Int) : super(WuXing.TU) {
        val value = (guaNum - 1) % 8
        var value8 = value.and(0b111)
        //println("Input value:"+value8.toString(2))
        value8 = value8.inv().and(0b111)
        val value0 = value8 and 0b001
        val value1 = (value8 and 0b010).ushr(1)
        val value2 = (value8 and 0b100).ushr(2)
        val result = (value0.shl(2)) + (value1.shl(1)) + value2
        //println("Output value:"+result.toString(2))
        this.value = result
        super.xing = getXing()
    }
    
    constructor(first :Boolean, second :Boolean, third :Boolean) : super(WuXing.TU) {
        var value = 0
        if (first) value = value.or(0b001)
        if (second) value = value.or(0b010)
        if (third) value = value.or(0b100)
        this.value = value
        super.xing = getXing()
    }

    fun getXing() :Int {
        return when (this.value) {
            0b000-> (WuXing.TU)
            0b001-> (WuXing.MU)
            0b010-> (WuXing.SHUI)  // 坎 水
            0b011-> (WuXing.JIN) // 兑 金
            0b100->(WuXing.TU) // 艮 土
            0b101->(WuXing.HUO) // 离 火
            0b110->(WuXing.MU) // 巽 木
            0b111->(WuXing.JIN) // 乾 金
            else -> (WuXing.TU)
        }
    }

    fun getName() :String{
        return when (value) {
            0b000 -> ("坤")
            0b001 -> ("震")
            0b010 -> ("坎")
            0b011 -> ("兑")
            0b100 -> ("艮")
            0b101 -> ("离")
            0b110 -> ("巽")
            0b111 -> ("乾")
            else -> ("")
        }
    }

    override fun toString(): String {
        return this.getName()
    }
}
