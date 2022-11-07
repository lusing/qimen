package com.github.lusing.liuyao

class LiuQin {
    var lq: Int = XIONGDI

    fun getName() :String {
        when  (this.lq) {
            FUMU->
            return "父母"
            ZISUN->
            return "子孙"
            GUANGUI->
            return "官鬼"
            QICAI->
            return "妻财"
            XIONGDI->
            return "兄弟"
        }
        return ""
    }

    companion object {
        const val FUMU = 0    // 父母
        const val ZISUN = 1          // 子孫
        const val GUANGUI = 2        // 官鬼
        const val QICAI = 3          // 妻财
        const val XIONGDI = 4        // 兄弟
    }
}



