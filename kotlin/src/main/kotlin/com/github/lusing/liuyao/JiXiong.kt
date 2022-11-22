package com.github.lusing.liuyao

class JiXiong constructor(jx: Int) {
    val jixiong = jx % 2

    fun getName() {
        when (this.jixiong) {
            JI -> "吉"
            XIONG -> "凶"
            else -> "平"
        }
    }

    companion object {
        const val JI = 0
        const val XIONG = 1
    }
}