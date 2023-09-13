package com.github.lusing.taiyi

class Gong (gong :Int){
    init{
        val mGong = gong + 16 % 16
    }

    companion object{
        const val QIAN = 0
        const val HAI = 1
        const val ZI = 2
        const val CHOU = 3
        const val GEN = 4
        const val YIN = 5
        const val MAO = 6
        const val CHEN = 7
        const val XUN = 8
        const val SI = 9
        const val WU = 10
        const val WEI = 11
        const val KUN = 12
        const val SHEN = 13
        const val YOU = 14
        const val XU = 15

        fun getName(index :Int) : String{
            return when(index){
                QIAN -> "乾"
                HAI -> "亥"
                ZI -> "子"
                CHOU -> "丑"
                GEN -> "艮"
                YIN -> "寅"
                MAO -> "卯"
                CHEN -> "辰"
                XUN -> "巽"
                SI -> "巳"
                WU -> "午"
                WEI -> "未"
                KUN -> "坤"
                SHEN -> "申"
                YOU -> "酉"
                XU -> "戌"
                else -> "未知"
            }            
        }
    }
}