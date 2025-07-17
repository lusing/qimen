package com.github.lusing.taiyi

class XingShen(id: Int) {
    val name = getName(id)
    companion object {
        const val TAI_YI = 0
        const val WEN_CHANG = 1
        const val SHI_JI = 2
        const val ZHU_DAJIANG = 3
        const val ZHU_CANJIANG = 4
        const val KE_DAJIANG = 5
        const val KE_CANJIANG = 6
        const val DING_DAJIANG = 7
        const val DING_CANJIANG = 8
        const val JUN_JI = 9
        const val CHEN_JI = 10
        const val MIN_JI = 11
        const val WU_FU = 12
        const val DA_YOU = 13
        const val XIAO_YOU = 14
        const val SI_SHEN = 15
        const val TIAN_YI = 16
        const val DI_YI = 17
        const val ZHI_FU = 18
        const val FEI_FU = 19

        fun getName(index: Int): String {
            return when (index) {
                TAI_YI -> "太乙"
                WEN_CHANG -> "文昌"
                SHI_JI -> "始击"
                ZHU_DAJIANG -> "主大将"
                ZHU_CANJIANG -> "主参将"
                KE_DAJIANG -> "客大将"
                KE_CANJIANG -> "客参将"
                DING_DAJIANG -> "定大将"
                DING_CANJIANG -> "定参将"
                JUN_JI -> "君基"
                CHEN_JI -> "臣基"
                MIN_JI -> "民基"
                WU_FU -> "五福"
                DA_YOU -> "大游"
                XIAO_YOU-> "小游"
                SI_SHEN -> "四神"
                TIAN_YI -> "天乙"
                DI_YI -> "地乙"
                ZHI_FU -> "直符"
                FEI_FU -> "飞符"
                else -> "未知"
            }
        }
    }
}