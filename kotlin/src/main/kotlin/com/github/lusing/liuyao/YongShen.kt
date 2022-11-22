package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi

class YongShen {
    var yongShen: Int = XIAN_SHEN

    constructor(yongShen: DiZhi, thisShen: DiZhi) {
        if (thisShen.isSheng(yongShen)) {
            this.yongShen = YUAN_SHEN
        }
        if (thisShen.isKe(yongShen)) {
            this.yongShen = JI_SHEN
        }
        if (yongShen.isKe(thisShen)) {
            this.yongShen = CHOU_SHEN
        }
        if (yongShen.isSheng(thisShen)) {
            this.yongShen = XIAN_SHEN
        }
    }

    fun getName() {
        when (this.yongShen) {
            XIAN_SHEN -> "闲神"
            YUAN_SHEN -> "原神"
            JI_SHEN -> "忌神"
            CHOU_SHEN -> "仇神"
            else -> "闲神"
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