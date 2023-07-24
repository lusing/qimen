package com.github.lusing.qimen

class BaShen(shen: Int) {
    val mShen: Int

    init {
        mShen = shen % 8
    }

    override fun toString(): String {
        return (sBaShen[mShen].toString())
    }

    fun getConcept(): String {
        var str = ""
        when (this.mShen) {
            FU -> str =
                "直觉力、高贵的、高档的、稀有的、有组织能力的、名牌的、重点的、高尚的、有影响力的、服众的、威严的、德高望重的"

            SHE -> str =
                "缠绕、惊恐、虚惊、怪异、虚幻、梦境、变来变去、反反复复、虚诈、虚伪、华而不实、闪烁不定、光怪陆离、耀眼、娇艳、猜疑、狠毒、纠缠、变化、拐弯抹角"

            YIN -> str =
                "提升、护佑、隐避、藏匿、喜庆、贞祥、淫乱、阴私、隐私、密谋、缜密、诅咒、哭泣、忧疑、欺诈、口舌、私通、策划、遮盖、暗处、雕刻"

            LIU -> str =
                "欢乐、祥和、仁慈、包容、合作、联合、交易、谈判、结婚、众多、收拢、关闭、平和、共同、适合、合抱、重叠、相聚、聚集"

            BAI -> str = "凶猛、威严、阻隔、斗争、权力、刚毅、冷酷、严肃、艳丽、强硬、官司、伤灾、牢狱、疾病、死亡、技术过硬、道路"
            XUAN -> str = "深奥、玄虚、不可靠、不可捉摸、玄妙、神秘、幻想、领悟、理解、智慧、偷盗、偷情、谍言、阴谋、诡计"
            DI -> str = "矮小、稳定、厚重、柔顺、文静、恭敬、谦卑、吝啬、消极、哭泣、自私、模糊、旧物、博大、包容、关怀、缓慢、困惑"
            TIAN -> str = "高大、天空、虚无、高处、极端、重要、主宰、意志、灵魂、自然、高大、聪明、光明、恩赐、幸福、豪放、美丽"
        }
        return str
    }

    fun getRomance(): String {
        var str = ""
        when (this.mShen) {
            FU -> str =
                "浪漫、气质高雅、雍容华贵、性格直爽、不怒而威、道貌岸然、有名望、有管理能力、不屈居人下、多得能人帮助、有靠山"

            SHE -> str =
                "反复变化、奸诈虚假、三心二意、阴阳怪气、男主水蛇腰、女主身材苗条、清秀、大脑门、头发黄。螣蛇也主智慧、才能出众、聪明、善变、感情不固定、缠人、追求人死缠烂打、粘上就不容易摆脱"

            YIN -> str =
                "思想细腻、性情温顺、自私隐瞒、暗中行事、面白、品相极佳、十指如葱、少说多做、策划能力强。感情细腻、会照顾人、喜欢暗中做事、喜欢独处、悄悄话。感情上暗中喜欢，暗恋。内心有阴暗面、爱哭泣"

            LIU -> str =
                "随和温顺、慈祥乐观、人缘极佳、身绵如玉、手如佛掌、眼睛细长。测婚临六合就在一起了，六合为合上，结婚。和气、和蔼、爱笑、阳光、六合是兔子，有兔牙，招人喜爱，可爱、伴侣多"

            BAI -> str =
                "威严霸道、武断狂傲、硬、厉害、用鞭子抽人、本领过人、脸圆项粗、豹头环眼、脸白身净、虎背熊腰。过硬的职业技能、干什么事都愿出头之人、做事猛烈、对待异性情感炙烈，张口就说"

            XUAN -> str =
                "神秘莫测、口若悬河、奸诈虚假、暗有私情、贼眉鼠眼、弯背含胸、视物昏花。聪明智巧、道法高明、神秘、好忽悠人、有技巧，或懂玄学、偷东西、说谎话、有迷惑性"

            DI -> str =
                "沉稳安静、敦厚笃实、节俭勤恳、身材矮小、脸方唇厚、手指粗短。发展稳定、事业稳固、稳重、沉静、谈朋友发展慢，不能大胆进取、但相对稳固"

            TIAN -> str =
                "志向高远、心高气傲、性情不定、高大英俊、威严威猛。主远见卓识、发展空间大、技术超群、好高骛远、胆大、谈天说地、虚幻"
        }
        return str
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

    private fun getWuXing(shen: Int): Int {
        var xing = 0
        when (shen % 8) {
            FU -> xing = WuXing.MU
            SHE -> xing = WuXing.HUO
            YIN -> xing = WuXing.JIN
            LIU -> xing = WuXing.MU
            BAI -> xing = WuXing.JIN
            XUAN -> xing = WuXing.SHUI
            DI -> xing = WuXing.TU
            TIAN -> xing = WuXing.JIN
        }
        return xing
    }
}