package com.github.lusing.qimen

class BaShen(shen: Int) {
    private val mShen: Int

    init {
        mShen = shen % 8
    }

    override fun toString(): String {
        return (sBaShen[mShen].toString())
    }

    companion object {
        const val FU = 0
        const val SHE = 1
        const val YIN = 2
        const val LIU = 3
        const val BAI = 4
        const val XUAN = 5
        const val DI = 6
        const val TIAN = 7
        const val sBaShen = "符蛇阴六白玄地天"
    }
}