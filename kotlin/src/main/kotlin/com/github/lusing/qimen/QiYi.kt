package com.github.lusing.qimen

class QiYi {
    lateinit var qiyi: TianGan
    var jigong: TianGan? = null // 寄宫奇仪

    override fun equals(other: Any?): Boolean {
        if (other !is QiYi) return false
        else
            return this.qiyi == other.qiyi && this.jigong == other.jigong
    }
}
