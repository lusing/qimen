package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi

class YongShen {
    var yongShen: Int = XIAN_SHEN

    constructor(yongShen: Int) {
        this.yongShen = yongShen
    }

    constructor(shiShen: DiZhi, yongShen: DiZhi) {
        //生用神为原神
        if (shiShen.isSheng(yongShen)) {
            println("[Debug]生用神为原神")
            this.yongShen = YUAN_SHEN
        }
        // 克用神为忌神
        if (shiShen.isKe(yongShen)) {
            println("[Debug]克用神为忌神")
            this.yongShen = JI_SHEN
        }
        if (yongShen.isKe(shiShen)) {
            println("[Debug]用神克者为仇神")
            this.yongShen = CHOU_SHEN
        }
        if (yongShen.isSheng(shiShen)) {
            println("[Debug]用神生者为闲神")
            this.yongShen = XIAN_SHEN
        }
        if (yongShen.xing.xing == shiShen.xing.xing) {
            println("[Debug]用神")
            this.yongShen = YONG_SHEN
        }
    }

    fun getName(): String {
        return when (this.yongShen) {
            XIAN_SHEN -> "闲神"
            YUAN_SHEN -> "原神"
            JI_SHEN -> "忌神"
            CHOU_SHEN -> "仇神"
            YONG_SHEN -> "用神"
            else -> ""
        }
    }

    companion object {
        const val YONG_SHEN = 0 // 用神
        const val YUAN_SHEN = 1 // 原神
        const val JI_SHEN = 2 // 忌神
        const val CHOU_SHEN = 3 // 仇神
        const val XIAN_SHEN = 4 // 闲神
    }
}