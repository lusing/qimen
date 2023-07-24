package com.github.lusing.qimen


/**
 *
 * @author Louis
 */
class BaMen(men: Int) : WuXing(getWuXing(men % 8)) {
    val men: Int

    init {
        this.men = men % 8
    }

    override fun toString(): String {
        return sBaMen[men].toString()
    }

    fun getRomance(): String {
        var str = ""
        when (this.men) {
            XIU -> str = "柔顺平静、休闲懒散、追求时尚、语音温和、多有能人提携、喜欢旅游"

            SHENG -> str = "敦厚老实、做事规矩、前途美好、经济观念强、诚恳守信用、职业为生产管理、经营、贸易之人"

            SHANG -> str =
                "雷厉风行、勤勉奋进、多动少静、直爽性急、自尊心强、易伤害对方、性情急躁、说话不计后果。职业为运动员、军人、军警、渔猎、机械设备、兵工、车船、技术制造使用有关"

            DU -> str =
                "动作缓慢、朝气不足、思想保守、不爱说话。职业上为从事与技术有关的工作等"

            JING3 -> str =
                "美貌漂亮、化妆打扮、虚荣心强、自我欣赏、喜欢表演、能说会道、脸色红润、知书达理。职业则从事影视、广告、图书、电子、文化艺术、美容美体等"

            SI -> str =
                "保守内向、循规蹈矩、思想束缚、固执迟钝、一心一意。一般从事宗教工作，或从事地产、不动产、屠宰、医院等有关行业"

            JING1 -> str =
                "声音宏亮、一鸣惊人、热情大方、惊恐不安、心跳加速。一般从事教师、律师、歌手、乐器、音响、播音员、导游、营销人员、娱乐场所等行业"

            KAI -> str =
                "豁达爽朗、谈吐不凡、坦诚无私、开诚布公、性情愉快、意识活跃、思想开放、暴露、性感、通情达理、讲情重义、自尊心强、勤奋好学、讲义气、不拘小节、开放"
        }
        return str
    }

    companion object {
        /**
         * 休门 五行属水
         */
        const val XIU = 0
        const val SHENG = 1
        const val SHANG = 2
        const val DU = 3
        const val JING3 = 4
        const val SI = 5
        const val JING1 = 6
        const val KAI = 7
        const val sBaMen = "休生伤杜景死惊开"
        private fun getWuXing(men: Int): Int {
            var xing = 0
            when (men % 8) {
                XIU -> xing = SHUI
                SHENG, SI -> xing = TU
                SHANG, DU -> xing = MU
                JING3 -> xing = HUO
                JING1, KAI -> xing = JIN
            }
            return xing
        }
    }
}
