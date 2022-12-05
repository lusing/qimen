package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi

class WangXiang constructor(value: Int) {
    val wang = value

    fun getName(): String {
        return when (wang) {
            Wang -> "旺"
            CiWang -> "次旺"
            Xiang -> "相"
            XiuQiu -> "休囚"
            YuQi -> "余气"
            else -> "平平"
        }
    }

    companion object {
        val Wang = 0
        val CiWang = 1
        val Xiang = 2
        val XiuQiu = 3
        val YuQi = 4
        val PingPing = 5

        fun checkWang(yue: DiZhi, dz: DiZhi): Boolean {
            return dz.diZhi == yue.diZhi || yue.isSheng(dz)
        }
    }
}