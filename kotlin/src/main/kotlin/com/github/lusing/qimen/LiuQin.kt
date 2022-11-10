package com.github.lusing.qimen


open class LiuQin constructor(lq : Int){
    protected var liuqin = XIONGDI

    init {
        this.liuqin = lq
    }

    fun getName(): String {
        when (this.liuqin) {
            FUMU -> return "父母"

            ZISUN -> return "子孙"

            GUANGUI -> return "官鬼"

            QICAI -> return "妻财"

            XIONGDI -> return "兄弟"
        }
        return ""
    }

    companion object {
        const val XIONGDI = 0
        const val FUMU = 1
        const val ZISUN = 2
        const val GUANGUI = 3
        const val QICAI = 4

    }
}