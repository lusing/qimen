package com.github.lusing.liuyao

import com.github.lusing.qimen.TianGan

/**
 * 六十四卦配六爻
 */
class Gua64 {
    val value: Int
    val riGan : TianGan
    lateinit var yaos: Array<Yao>
    lateinit var gong: Gua8

//    constructor(value: Int) {
//        this.value = value
//        var yao = Yao(8)
//        yaos = arrayOf(yao, yao, yao, yao, yao, yao)
//    }

//    constructor(lowNum: Int, highNum: Int) {
//        val lowGua = Gua8(lowNum)
//        val highGua = Gua8(highNum)
//        this.value = (highGua.value.shl(3)) + lowGua.value
//        var yao = Yao(8)
//        yaos = arrayOf(yao, yao, yao, yao, yao, yao)
//    }

    constructor(first: Int, second: Int, third: Int, fourth: Int, fifth: Int, sixth: Int, rg: Int) {
        var value = 0

        var yao = Yao(8)
        yaos = arrayOf(yao, yao, yao, yao, yao, yao)

        if (first % 2 == 1) {
            value = value.or(0b00000001)
            this.yaos[0].isYang = true
        } else {
            this.yaos[0].isYang = false
        }
        if (second % 2 == 1) {
            value = value.or(0b00000010)
            this.yaos[1].isYang = true
        } else {
            this.yaos[1].isYang = false
        }
        if (third % 2 == 1) {
            value = value.or(0b00000100)
            this.yaos[2].isYang = true
        } else {
            this.yaos[2].isYang = false
        }
        if (fourth % 2 == 1) {
            value = value.or(0b00001000)
            this.yaos[3].isYang = true
        } else {
            this.yaos[3].isYang = false
        }
        if (fifth % 2 == 1) {
            value = value.or(0b00010000)
            this.yaos[4].isYang = true
        } else {
            this.yaos[4].isYang = false
        }
        if (sixth % 2 == 1) {
            value = value.or(0b00100000)
            this.yaos[5].isYang = true
        } else {
            this.yaos[5].isYang = false
        }
        this.value = value
        this.riGan = TianGan(rg)
    }

    constructor(values: Array<Int>, rg:Int) {
        var value = 0
        if (values[0] % 2 == 1) value = value.or(0b00000001)
        if (values[1] % 2 == 1) value = value.or(0b00000010)
        if (values[2] % 2 == 1) value = value.or(0b00000100)
        if (values[3] % 2 == 1) value = value.or(0b00001000)
        if (values[4] % 2 == 1) value = value.or(0b00010000)
        if (values[5] % 2 == 1) value = value.or(0b00100000)

        var yao = Yao(8)
        yaos = arrayOf(yao, yao, yao, yao, yao, yao)

        for (i in 0..5) {
            this.yaos[i] = Yao(values[i])
        }
        this.value = value
        this.riGan = TianGan(rg)
    }

    constructor(yaos: Array<Yao>, rg: Int) {
        var value = 0
        if (yaos[0].isYang) value = value.or(0b00000001)
        if (yaos[1].isYang) value = value.or(0b00000010)
        if (yaos[2].isYang) value = value.or(0b00000100)
        if (yaos[3].isYang) value = value.or(0b00001000)
        if (yaos[4].isYang) value = value.or(0b00010000)
        if (yaos[5].isYang) value = value.or(0b00100000)
        this.value = value
        this.yaos = yaos
        this.riGan = TianGan(rg)
    }

    fun getBianGua(): Gua64 {
        var bianYao = this.yaos.clone()
        for (i in 0..5) {
            if (this.yaos[i].isChange) {
                bianYao[i].isYang = this.yaos[i].isYang.not()
                bianYao[i].isChange = false
            }
        }
        return Gua64(bianYao, this.riGan.tianGan)
    }

    fun debug() {
        for (i in 0..5) {
            print("yao ${i + 1} is ${if (this.yaos[i].isYang) "阳" else "阴"}")
            print("yao ${i + 1} is ${if (this.yaos[i].isChange) "动" else "静"}")
            println("爻")
        }
    }

    fun getGuaArray(): Array<Boolean> {
        val result = arrayOf(false, false, false, false, false, false)
        if (value.and(0b00000001) == 0b00000001) result[0] = true
        if (value.and(0b00000010) == 0b00000010) result[1] = true
        if (value.and(0b00000100) == 0b00000100) result[2] = true
        if (value.and(0b00001000) == 0b00001000) result[3] = true
        if (value.and(0b00010000) == 0b00010000) result[4] = true
        if (value.and(0b00100000) == 0b00100000) result[5] = true
        return result
    }

    /*
     * 取下卦
     */
    fun getLow(): Gua8 {
        val value = this.value.and(0b000111)
        //fmt.Printf("%b", value)
        var gua = Gua8(value)
        gua.value = value
        return gua
    }

    fun getHigh(): Gua8 {
        var value = this.value.and(0b111000)
        value.ushr(3)
        var gua = Gua8(value)
        gua.value = value
        return gua
    }

    override fun toString(): String {
        return this.getName()
    }

    fun getName(): String {
        when (this.value) {
            0b000000 -> return "坤为地"
            0b000001 -> return "地雷复"
            0b000010 -> return "地水师"
            0b000011 -> return "地泽临"
            0b000100 -> return "地山谦"
            0b000101 -> return "地火明夷"
            0b000110 -> return "地风升"
            0b000111 -> return "地天泰"
            0b001000 -> return "雷地豫"
            0b001001 -> return "震为雷"
            0b001010 -> return "雷水解"
            0b001011 -> return "雷泽归妹"
            0b001100 -> return "雷山小过"
            0b001101 -> return "雷火丰"
            0b001110 -> return "雷风恒"
            0b001111 -> return "雷天大壮"
            0b010000 -> return "水地比"
            0b010001 -> return "水雷屯"
            0b010010 -> return "坎为水"
            0b010011 -> return "水泽节"
            0b010100 -> return "水山蹇"
            0b010101 -> return "水火既济"
            0b010110 -> return "水风井"
            0b010111 -> return "水天需"
            0b011000 -> return "泽地萃"
            0b011001 -> return "泽雷随"
            0b011010 -> return "泽水困"
            0b011011 -> return "兑为泽"
            0b011100 -> return "泽山咸"
            0b011101 -> return "泽火革"
            0b011110 -> return "泽风大过"
            0b011111 -> return "泽天夬"
            0b100000 -> return "山地剥"
            0b100001 -> return "山雷颐"
            0b100010 -> return "山水蒙"
            0b100011 -> return "山泽损"
            0b100100 -> return "艮为山"
            0b100101 -> return "山火贲"
            0b100110 -> return "山风蛊"
            0b100111 -> return "山天大畜"
            0b101000 -> return "火地晋"
            0b101001 -> return "火雷噬嗑"
            0b101010 -> return "火水未济"
            0b101011 -> return "火泽睽"
            0b101100 -> return "火山旅"
            0b101101 -> return "离为火"
            0b101110 -> return "火风鼎"
            0b101111 -> return "火天大有"
            0b110000 -> return "风地观"
            0b110001 -> return "风雷益"
            0b110010 -> return "风水涣"
            0b110011 -> return "风泽中孚"
            0b110100 -> return "风山渐"
            0b110101 -> return "风火家人"
            0b110110 -> return "巽为风"
            0b110111 -> return "风天小畜"
            0b111000 -> return "天地否"
            0b111001 -> return "天雷无妄"
            0b111010 -> return "天水讼"
            0b111011 -> return "天泽履"
            0b111100 -> return "天山遁"
            0b111101 -> return "天火同人"
            0b111110 -> return "天风姤"
            0b111111 -> return "乾为天"
            else -> return "周文王也不知道"
        }
    }
}