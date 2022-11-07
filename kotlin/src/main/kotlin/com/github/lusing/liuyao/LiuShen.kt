package com.github.lusing.liuyao

import com.github.lusing.qimen.WuXing

class LiuShen constructor(number: Int) : WuXing(number) {
    val ls: Int

    init {
        this.ls = number % 6
        when (this.ls) {
            QINGLONG -> {
                this.xing = MU
            }

            ZHUQUE -> {
                this.xing = HUO
            }

            GOUCHEN -> {
                this.xing = TU
            }

            TENGSHE -> {
                this.xing = TU
            }

            BAIHU -> {
                this.xing = JIN
            }

            XUANWU -> {
                this.xing = SHUI
            }
        }
    }

    companion object {
        const val QINGLONG = 0 // 青龍
        const val ZHUQUE = 1   // 朱雀
        const val GOUCHEN = 2  // 勾陈
        const val TENGSHE = 3  // 腾蛇
        const val BAIHU = 4    // 白虎
        const val XUANWU = 5   // 玄武
    }

    fun getName(): String {
        when (this.ls) {
            QINGLONG ->
                return "青龍"

            ZHUQUE ->
                return "朱雀"

            GOUCHEN ->
                return "勾陈"

            TENGSHE ->
                return "腾蛇"

            BAIHU ->
                return "白虎"

            XUANWU ->
                return "玄武"
        }
        return "达拉崩吧"
    }
}
