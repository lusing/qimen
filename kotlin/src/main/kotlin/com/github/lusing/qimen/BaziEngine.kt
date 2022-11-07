package com.github.lusing.qimen


/**
 * 天干代表所见到的表面，外性格。性格、行为举止、容颜、六亲状况、有钱、凶灾。
 *
 *
 * 地支代表内心，内环境。善恶、忠奸、心中想法。
 *
 * @author Louis
 */
class BaZiEngine {
    var year_tg = 0
    var year_dz = 0
    var month_tg = 0
    var month_dz = 0
    var day_tg = 0
    var day_dz = 0
    var hour_tg = 0
    var hour_dz = 0
    var tgs: Array<TianGan?> = arrayOf(null)
    var dzs: Array<DiZhi?> = arrayOf(null)

    constructor(
        y1: Int, y2: Int, m1: Int, m2: Int, d1: Int, d2: Int, h1: Int,
        h2: Int
    ) {
        year_tg = y1
        year_dz = y2
        month_tg = m1
        month_dz = m2
        day_tg = d1
        day_dz = d2
        hour_tg = h1
        hour_dz = h2
        tgs = arrayOfNulls(4)
        dzs = arrayOfNulls(4)
        tgs[0] = TianGan(y1)
        tgs[1] = TianGan(m1)
        tgs[2] = TianGan(d1)
        tgs[3] = TianGan(h1)
        dzs[0] = DiZhi(y2)
        dzs[1] = DiZhi(m2)
        dzs[2] = DiZhi(d2)
        dzs[3] = DiZhi(h2)
    }

    constructor(bas: IntArray?) {
        if (bas == null || bas.size != 8) {
            return
        } else {
            year_tg = bas[0]
            year_dz = bas[1]
            month_tg = bas[2]
            month_dz = bas[3]
            day_tg = bas[4]
            day_dz = bas[5]
            hour_tg = bas[6]
            hour_dz = bas[7]
            tgs = arrayOfNulls(4)
            dzs = arrayOfNulls(4)
            tgs[0] = TianGan(bas[0])
            tgs[1] = TianGan(bas[2])
            tgs[2] = TianGan(bas[4])
            tgs[3] = TianGan(bas[6])
            dzs[0] = DiZhi(bas[1])
            dzs[1] = DiZhi(bas[3])
            dzs[2] = DiZhi(bas[5])
            dzs[3] = DiZhi(bas[7])
        }
    }

    fun run(): String {
        val sb = StringBuilder()
        sb.append(checkLiuQin())
        sb.append(checkWuXing())
        sb.append(mangRenDuan())
        sb.append(checkBaZhuan())
        return sb.toString()
    }

    private fun mangRenDuan(): String {
        val sb = StringBuilder()
        sb.append(shiZhuDuan())
        sb.append(checkRiZhu())
        //sb.append(checkShiShen())
        return sb.toString()
    }

//    private fun checkShiShen(): String {
//        val sb = StringBuilder()
//        val year_shishen_tg: Int = ShiShen.getShiShen(tgs[DAY]!!,tgs[YEAR]!!).shiShen
//        val year_shishen_dz: Int = ShiShen.getShiShen(tgs[DAY]!!, dzs[YEAR].getBenQin()).shiShen
//        val month_shishen_tg: Int = ShiShen.shiShen
//            .getShiShen()
//        val month_shishen_dz: Int = ShiShen.shiShen.getShiShen()
//        val day_shishen_dz: Int = ShiShen.shiShen
//            .getShiShen()
//        val hour_shishen_tg: Int = ShiShen.shiShen
//            .getShiShen()
//        val hour_shishen_dz: Int = ShiShen.shiShen.getShiShen()
//
//
//        if (year_shishen_tg == ShiShen.ZHENGGUAN
//            || year_shishen_dz == ShiShen.ZHENGGUAN
//        ) {
//            sb.append("年上正官，祖上比较富贵，有功名气象，有权势。")
//            if (day_shishen_dz != ShiShen.SHANGGUAN) {
//                // TODO: 判断冲
//                sb.append("少年学业比较好.（要断冲）")
//            }
//            if (year_shishen_tg == ShiShen.ZHENGGUAN
//                && year_shishen_dz == ShiShen.ZHENGGUAN
//            ) {
//                sb.append("从小读书非常用功，有成绩，如果不是头生子女，必然能接老人遗产。")
//            }
//        }
//        if (year_shishen_tg == ShiShen.ZHENGYIN
//            || year_shishen_dz == ShiShen.ZHENGYIN
//        ) {
//            sb.append("少年读书有成绩，老来也是个有福人。")
//        }
//        if (year_shishen_tg == ShiShen.QISHA
//            || year_shishen_dz == ShiShen.QISHA
//        ) {
//            sb.append("年上七杀，对父母有克。年上偏官不是头生子，幼年家中贫困。")
//        }
//        if (year_shishen_tg == ShiShen.PIANCAI
//            || year_shishen_dz == ShiShen.PIANCAI
//        ) {
//            sb.append("年上偏财，少年有福。")
//            if (year_shishen_tg == ShiShen.PIANCAI || year_shishen_dz == ShiShen.BIJIAN) {
//                sb.append("年上偏财支比肩，父母死在外边。")
//            }
//            if (year_shishen_tg == ShiShen.PIANCAI
//                && year_shishen_dz == ShiShen.PIANCAI
//            ) {
//                sb.append("幼年克父克母。")
//            }
//        }
//        if (year_shishen_tg == ShiShen.ZHENGCAI
//            || year_shishen_dz == ShiShen.ZHENGCAI
//        ) {
//            sb.append("年上正财祖来强，家大业大借祖光，下有营地分三处，内有一处有力量。")
//            if (month_shishen_tg == ShiShen.ZHENGCAI
//                || month_shishen_dz == ShiShen.ZHENGCAI
//            ) {
//                sb.append("月上正财同来现，不是两妻就俩娘。")
//            }
//        }
//        if (year_shishen_tg == ShiShen.SHANGGUAN
//            || year_shishen_dz == ShiShen.SHANGGUAN
//        ) {
//            sb.append("年上伤官命不佳，祖业漂零没有啥。")
//            if (month_shishen_tg == ShiShen.SHANGGUAN
//                || month_shishen_dz == ShiShen.SHANGGUAN
//            ) {
//                sb.append("月上再把伤官见，不是克爹就克娘，若遇财运尚可解，一生事业有发达。")
//            }
//            if (hour_shishen_tg == ShiShen.SHANGGUAN
//                || hour_shishen_dz == ShiShen.SHANGGUAN
//            ) {
//                sb.append("时上再把伤官见，刑妻克子定不养。")
//            }
//            if (year_shishen_tg == ShiShen.SHANGGUAN) {
//                sb.append("年干为伤官，不论喜忌，皆主祖业漂零父母辈贫困多灾。")
//            }
//        }
//        if (year_shishen_tg == ShiShen.SHISHEN
//            || year_shishen_dz == ShiShen.SHISHEN
//        ) {
//            sb.append("年上食神，主少年不缺衣食，财源丰厚有福气，还主为人多自在，少年吃些好东西。")
//            if (year_shishen_tg == ShiShen.SHISHEN
//                && year_shishen_dz == ShiShen.BIJIAN
//            ) {
//                sb.append("干上食神支比肩，此人养子定无疑。")
//            }
//        }
//        if (year_shishen_tg == ShiShen.PIANYIN
//            || year_shishen_dz == ShiShen.PIANYIN
//        ) {
//            sb.append("年上偏印命不强，不是离父就离娘，自幼与母无缘份，缺少家教在命上。")
//            if (year_shishen_tg == ShiShen.PIANYIN
//                || year_shishen_dz == ShiShen.BIJIAN
//            ) {
//                sb.append("支为比肩为养子，少年名誉不太好，父母命硬克不动，疾病口舌不顺当。")
//            }
//        }
//        if (year_shishen_tg == ShiShen.BIJIAN
//            || year_shishen_dz == ShiShen.BIJIAN
//        ) {
//            if (year_shishen_tg == ShiShen.BIJIAN) {
//                sb.append("年干比劫不利父。")
//            }
//            sb.append("年上比肩少远乡，生来就把父母克，父母命硬克不动，必有灾疾和口舌。祖业前程你没有，自力更生去生活，从小受苦受折磨.")
//        }
//        if (year_shishen_tg == ShiShen.JIECAI
//            || year_shishen_dz == ShiShen.JIECAI
//        ) {
//            sb.append("年上劫财，祖业贫穷，靠自力更生创家业，为人心高气傲，讲义气，争强好胜。")
//        }
//        if (tgs[YEAR]!!.tianGan == TianGan.REN && tgs[HOUR]!!.tianGan == TianGan.YI || tgs[YEAR]!!.tianGan == TianGan.YI && (tgs[HOUR]
//                .tianGan == TianGan.REN)
//        ) {
//            sb.append("主母亲为偏房")
//        }
//        if ((dzs[YEAR]!!.diZhi == DiZhi.XU || dzs[YEAR]!!.diZhi == DiZhi.XU)
//            && isYin(dzs[YEAR])
//        ) {
//            sb.append("主母亲或祖长多有宗教信仰或有懂五术玄学之人。")
//        }
//        sb.append("\n")
//        if (month_shishen_tg == ShiShen.ZHENGGUAN
//            || month_shishen_dz == ShiShen.ZHENGGUAN
//        ) {
//            sb.append("月上正官正气星，为人生来主聪明。")
//        }
//        if (month_shishen_tg == ShiShen.PIANGUAN
//            || month_shishen_dz == ShiShen.PIANGUAN
//        ) {
//            sb.append("月上偏官.")
//        }
//        if (month_shishen_tg == ShiShen.PIANYIN
//            || month_shishen_dz == ShiShen.PIANYIN
//        ) {
//            sb.append("月上偏印.")
//        }
//        if (month_shishen_tg == ShiShen.BIJIAN
//            || month_shishen_dz == ShiShen.BIJIAN
//        ) {
//            sb.append("月上比肩兄弟多，兄弟多了不相合，兄弟常常不和睦，自力更生把事谋。")
//        }
//        if (month_shishen_tg == ShiShen.JIECAI
//            || month_shishen_dz == ShiShen.JIECAI
//        ) {
//            sb.append("月上劫财，一生钱存不下，好为朋友破钱财，此人喜欢外表光华，爱穿爱戴投机取巧，不能和别人合伙做买卖，有钱就有事，好打架骂人。")
//        }
//        if (month_shishen_tg == ShiShen.SHISHEN
//            || month_shishen_dz == ShiShen.SHISHEN
//        ) {
//            sb.append("月柱有食神，为人人缘好，一生有贵人助")
//            if (month_shishen_dz == ShiShen.SHISHEN) {
//                sb.append("月支食神一般身体好。")
//            }
//        }
//        if (month_shishen_tg == ShiShen.SHANGGUAN
//            && month_shishen_dz == ShiShen.QISHA
//        ) {
//            sb.append("月柱干伤官支坐七杀，女命逢之喝三眼井水之命。")
//        }
//        sb.append("\n")
//        if (day_shishen_dz == ShiShen.SHANGGUAN) {
//            sb.append("女命日坐伤官不论喜忌，必克夫婚姻不顺。")
//        }
//        if (day_shishen_dz == ShiShen.BIJIAN
//            || day_shishen_dz == ShiShen.JIECAI
//        ) {
//            sb.append("男命坐比劫，必克妻，婚姻不顺。")
//        }
//        if (tgs[DAY]!!.tianGan == TianGan.JIA && dzs[DAY]!!.diZhi == DiZhi.YIN || tgs[DAY]!!.tianGan == TianGan.WU && (dzs[DAY]!!.diZhi == DiZhi.SHEN)) {
//            sb.append("女命甲寅、wu申日柱，夫有横死之灾。")
//        }
//        if (day_shishen_dz == ShiShen.PIANCAI) {
//            sb.append("男命日坐偏财者主自己风流，不喜正妻偏爱小妾。")
//        }
//        if (day_shishen_dz == ShiShen.PIANYIN) {
//            sb.append("男命日坐偏印必克妻且妻与母不合。")
//        }
//        if (dzs[DAY]!!.diZhi == dzs[MONTH]!!.diZhi) {
//            sb.append("主配偶漂亮或能力强")
//        } else {
//            when (dzs[DAY]!!.diZhi) {
//                DiZhi.ZI, DiZhi.WU, DiZhi.MAO, DiZhi.YOU -> sb.append("主配偶漂亮或能干")
//                DiZhi.YIN, DiZhi.SHEN, DiZhi.SI, DiZhi.HAI -> sb.append("主配偶长相一般，好说，聪明能干")
//                DiZhi.CHEN, DiZhi.XU, DiZhi.CHOU, DiZhi.WEI -> sb.append("主配偶朴素，敦厚。")
//            }
//        }
//        return sb.toString() + "\n"
//    }

    private fun checkRiZhu(): String {
        val sTG = tgs[DAY]
        val sDZ = dzs[DAY]
        val sb = StringBuilder()
        val ritg = sTG!!.tianGan
        when (ritg) {
            TianGan.JIA -> {
                sb.append("甲木日干：有组织能力，刚强，自律严厉，有领导才能，能获得多数人信赖\n")
                sb.append("偏财临身：能挣能花，从不计较个人得失，自主力强不依赖他人\n")
            }

            TianGan.YI -> {
                sb.append("乙木日干：外表懦弱谨慎，但内心固执，较为拘泥保守，感情脆弱\n")
                sb.append("正财临身：花钱多算计，计较个人利益，一心想财\n")
            }

            TianGan.BING -> {
                sb.append("丙火日干：文明有礼，美而敦厚，热情有朝气，活泼开朗乐天，但缺少毅力恒心，易被误解为好表现。\n")
                sb.append("七杀临身：性急躁，易发脾气，直来直去，易惹事非，孤刚斗狠，心高气傲，行为放纵\n")
            }

            TianGan.DING -> {
                sb.append("丁火日干：外柔内进，思想缜密，文明有礼，畏挫折，能胜不能败。\n")
                sb.append("谨小慎微，积极进取，稳重老成，奉公守法，责任心强。\n")
            }

            TianGan.WU -> {
                sb.append("诚实厚重，有社交力，喜打扮，没主见，与人处不久。\n")
                sb.append("偏印临身：耍小聪明，心胸狭窄，内中算计，性格多疑，感情用事\n")
            }

            TianGan.JI -> {
                sb.append("己土日干：为人心细，有规律，度量小，猜忌心强，好胜好强\n")
                sb.append("正印临身：仁慈宽厚，劳心劳累，多愁善感，宽以待人\n")
            }

            TianGan.GENG -> {
                sb.append("庚金日干：金主义者，略具文才，有经济手腕，善于处事，重物质享受\n")
                sb.append("比肩临身：朋友多，意志坚强，率真有重，内外团结，为人豪爽\n")
            }

            TianGan.XIN -> {
                sb.append("辛金日干：缺少魅力，顽固，能排除万难完成人，聪明\n")
                sb.append("劫财临身：刻板固执，打抱不平，常惹事非，花钱大，自高自大，一生操劳\n")
            }

            TianGan.REN -> {
                sb.append("壬水日干：有团结人的能力，能说服人，性暴，度量人，依赖性强，个性散乱，漫不经心\n")
                sb.append("食神临身：气质高雅，思想脱俗，反应快速，多才多艺\n")
            }

            TianGan.GUI -> {
                sb.append("正直廉洁，勤勉，处不顺境也会开拓道路，有生命力，能吃苦。\n")
                sb.append("伤官临身：不服约束，傲慢无礼，好表现自己，喜欢空想，行为诡秘，易受挫折\n")
            }
        }
        if (sTG.xing.xing == sDZ!!.xing!!.xing) {
            sb.append("日柱比运转，克妻，主婚姻不顺\n")
        }
        if (sTG.xing.isSheng(sDZ.xing!!)) {
            sb.append("日干生日支夫妻感情好\n")
        }
        return sb.toString() + "\n"
    }

    private fun shiZhuDuan(): String {
        val stg = tgs[HOUR]!!.tianGan
        val sdz = dzs[HOUR]!!.diZhi
        val sb = StringBuilder()
        when (sdz) {
            DiZhi.ZI, DiZhi.WU, DiZhi.MAO, DiZhi.YOU -> sb.append("时初出生先亡父，时末先亡母，时中间多富饶\n")
            DiZhi.YIN, DiZhi.SHEN, DiZhi.SI, DiZhi.HAI -> sb.append("时正兄弟四五个，时初时末也成双\n")
            DiZhi.CHEN, DiZhi.XU, DiZhi.CHOU, DiZhi.WEI -> sb.append("时正多者先亡父，时初时末先亡母，兄弟少或无兄弟。此时辰出生的人克六亲\n")
        }
        when (stg) {
            TianGan.JIA, TianGan.YI -> sb.append("成家之后才能富贵，发达\n")
            TianGan.BING, TianGan.DING -> sb.append("晚年家中多事，多烦恼\n")
            TianGan.WU, TianGan.JI -> sb.append("自己富了发达了，但是六亲沾不到光\n")
            TianGan.GENG, TianGan.XIN -> sb.append("一生多于动中谋生，善于交际门路广\n")
            TianGan.REN, TianGan.GUI -> sb.append("一生做事多阻逆，多波折\n")
        }
        return sb.toString() + "\n"
    }

    private fun checkBaZhuan(): String {
        val sb = StringBuilder()
        if (isBaZhuan(tgs[DAY], dzs[DAY])) {
            sb.append("日柱有淫欲煞，主有不正之妻\n")
        }
        if (isBaZhuan(tgs[HOUR], dzs[HOUR])) {
            sb.append("时柱有淫欲煞，主有不正之子\n")
        }
        if (isJiuChou(tgs[DAY], dzs[DAY]) || isJiuChou(
                tgs[HOUR],
                dzs[HOUR]
            )
        ) {
            sb.append("九丑，主夫妻不睦\n")
        }
        if (isRiZuoShangGuan) {
            sb.append("日坐伤官，主风流好色\n")
        }
        if (isYinYangChaCuo) {
            sb.append("阴阳差错日，主婚姻不顺\n")
        }
        if (isShiEDaBai) {
            sb.append("十恶大败，主败祖业\n")
        }
        return sb.toString()
    }

    private fun isBaZhuan(tg: TianGan?, dz: DiZhi?): Boolean {
        val tg1 = tg!!.tianGan
        val dz1 = dz!!.diZhi
        return if (((tg1 == TianGan.JIA && dz1 == DiZhi.YIN)
                    || (tg1 == TianGan.YI && dz1 == DiZhi.MAO)
                    || (tg1 == TianGan.JI && dz1 == DiZhi.WEI)
                    || (tg1 == TianGan.DING && dz1 == DiZhi.WEI)
                    || (tg1 == TianGan.GENG && dz1 == DiZhi.SHEN)
                    || (tg1 == TianGan.XIN && dz1 == DiZhi.YOU)
                    || (tg1 == TianGan.WU && dz1 == DiZhi.XU)
                    || (tg1 == TianGan.GUI && dz1 == DiZhi.CHOU))
        ) {
            true
        } else {
            false
        }
    }

    private fun isJiuChou(tg: TianGan?, dz: DiZhi?): Boolean {
        val tg1 = tg!!.tianGan
        val dz1 = dz!!.diZhi
        return if (((tg1 == TianGan.REN && dz1 == DiZhi.ZI)
                    || (tg1 == TianGan.REN && dz1 == DiZhi.WU)
                    || (tg1 == TianGan.WU && dz1 == DiZhi.ZI)
                    || (tg1 == TianGan.WU && dz1 == DiZhi.WU)
                    || (tg1 == TianGan.JI && dz1 == DiZhi.YOU)
                    || (tg1 == TianGan.JI && dz1 == DiZhi.MAO)
                    || (tg1 == TianGan.YI && dz1 == DiZhi.YOU)
                    || (tg1 == TianGan.YI && dz1 == DiZhi.MAO)
                    || (tg1 == TianGan.XIN && dz1 == DiZhi.MAO))
        ) {
            true
        } else {
            false
        }
    }

    private val isRiZuoShangGuan: Boolean
        get() {
            val tg1 = tgs[DAY]!!.tianGan
            val dz1 = dzs[DAY]!!.diZhi
            return ((tg1 == TianGan.JIA && dz1 == DiZhi.ZI)
                        || (tg1 == TianGan.YI && dz1 == DiZhi.SI)
                        || (tg1 == TianGan.GENG && dz1 == DiZhi.WU)
                        || (tg1 == TianGan.XIN && dz1 == DiZhi.HAI)
                        || (tg1 == TianGan.JIA && dz1 == DiZhi.WU)
                        || (tg1 == TianGan.GENG && dz1 == DiZhi.ZI)
                        || (tg1 == TianGan.GUI && dz1 == DiZhi.HAI))
        }
    private val isYinYangChaCuo: Boolean
        private get() {
            val tg1 = tgs[DAY]!!.tianGan
            val dz1 = dzs[DAY]!!.diZhi
            return ((tg1 == TianGan.XIN && dz1 == DiZhi.MAO)
                    || (tg1 == TianGan.REN && dz1 == DiZhi.CHEN)
                    || (tg1 == TianGan.GUI && dz1 == DiZhi.SI)
                    || (tg1 == TianGan.BING && dz1 == DiZhi.WU)
                    || (tg1 == TianGan.DING && dz1 == DiZhi.WEI)
                    || (tg1 == TianGan.WU && dz1 == DiZhi.SHEN)
                    || (tg1 == TianGan.XIN && dz1 == DiZhi.YOU)
                    || (tg1 == TianGan.REN && dz1 == DiZhi.XU)
                    || (tg1 == TianGan.GUI && dz1 == DiZhi.HAI)
                    || (tg1 == TianGan.BING && dz1 == DiZhi.ZI)
                    || (tg1 == TianGan.DING && dz1 == DiZhi.CHOU)
                    || (tg1 == TianGan.WU && dz1 == DiZhi.YIN))
        }
    private val isShiEDaBai: Boolean
        private get() {
            val tg1 = tgs[DAY]!!.tianGan
            val dz1 = dzs[DAY]!!.diZhi
            return if (((tg1 == TianGan.JIA && dz1 == DiZhi.CHEN)
                        || (tg1 == TianGan.YI && dz1 == DiZhi.SI)
                        || (tg1 == TianGan.REN && dz1 == DiZhi.SHEN)
                        || (tg1 == TianGan.BING && dz1 == DiZhi.SHEN)
                        || (tg1 == TianGan.DING && dz1 == DiZhi.HAI)
                        || (tg1 == TianGan.GENG && dz1 == DiZhi.CHEN)
                        || (tg1 == TianGan.GUI && dz1 == DiZhi.HAI)
                        || (tg1 == TianGan.WU && dz1 == DiZhi.XU)
                        || (tg1 == TianGan.XIN && dz1 == DiZhi.SI)
                        || (tg1 == TianGan.JI && dz1 == DiZhi.CHOU))
            ) {
                true
            } else {
                false
            }
        }

    private fun checkLiuQin(): String {
        val sb = StringBuilder()
        sb.append("日主：" + tgs[2] + "\n")
        sb.append(
            tgs[0].toString() + dzs[0] + " " + tgs[1] + dzs[1] + " "
                    + tgs[2] + dzs[2] + " " + tgs[3] + dzs[3] + "\n"
        )
        sb.append(
            ((tgs[0].toString() + " " + ShiShen.getShiShen(tgs[2]!!, tgs[0]!!)
                    ).toString() + "\n")
        )
        sb.append(
            ((tgs[1].toString() + " " + ShiShen.getShiShen(tgs[2]!!, tgs[0]!!)
                    ).toString() + "\n")
        )
        sb.append(
            ((tgs[3].toString() + " " + ShiShen.getShiShen(tgs[2]!!, tgs[0]!!)
                    ).toString() + "\n")
        )

        sb.append("命宫：").append(DiZhi.getMingGong((dzs[1])!!, (dzs[3])!!)).append("\n")
        var yins = 0
        var bis = 0
        var cais = 0
        var guans = 0
        var shangs = 0
        val tgFull: ArrayList<TianGan> = ArrayList<TianGan>()
        tgs[YEAR]?.let { tgFull.add(it) }
        tgs[MONTH]?.let { tgFull.add(it) }
        tgs[HOUR]?.let { tgFull.add(it) }
        for (i in YEAR..HOUR) {
            tgFull.addAll(dzs[i]!!.cangGan)
        }
        for (tg: TianGan in tgFull) {
            when (ShiShen.getShiShen(tgs[DAY]!!, tg).shiShen) {
                ShiShen.ZHENGYIN, ShiShen.PIANYIN -> yins++
                ShiShen.BIJIAN, ShiShen.JIECAI -> bis++
                ShiShen.ZHENGCAI, ShiShen.PIANCAI -> cais++
                ShiShen.ZHENGGUAN, ShiShen.QISHA -> guans++
                ShiShen.SHISHEN, ShiShen.SHANGGUAN -> shangs++
            }
        }
        sb.append(
            ("共有食伤:" + shangs + "个，财:" + cais + "个，官:" + guans + "个，印:"
                    + yins + "个，根比：" + bis + "个\n")
        )
        return sb.toString()
    }

    private fun checkWuXing(): String {
        val sb = StringBuilder()
        for (i in tgs.indices) {
            sb.append(tgs[i]!!.xing.toString() + dzs[i]!!.xing + "\t")
        }
        sb.append("\n")
        val br = checkWangShuai()
        sb.append(br)
        sb.append(getYongShen(br))
        return sb.toString()
    }

    /**
     * 取用神
     */
    private fun getYongShen(br: BaziResult): String {
        val sb = StringBuilder()
        when (br.status) {
            BaziResult.RUO -> sb.append("身弱用印比\n")
            BaziResult.WANG -> sb.append("身旺用财官伤\n")
            BaziResult.CONG_QIANG -> sb.append("印比帮扶为用神\n")
            BaziResult.CONG_RUO -> sb.append("财官伤食都是用神\n")
            BaziResult.JIA_CONG -> sb.append("随岁运变化而变\n")
            else -> {}
        }
        return sb.toString()
    }

    /**
     * 检查日主的旺衰
     */
    private fun checkWangShuai(): BaziResult {

        // 先算算根印各有多少个
        var yins = 0
        var gens = 0
        for (i in YEAR..HOUR) {
            if (isYin(dzs[i])) {
                yins++
            }
            if (isGen(dzs[i])) {
                gens++
            }
        }
        // System.out.println("本命共有根" + gens + "个，印" + yins + "个");
        /**
         * 九. 印或根在命局地支中一次也不出现
         */
        // 新23
        if (yins == 0 && gens == 0) {
            return if (isAllBiOrYin) {
                BaziResult(BaziResult.RUO, "新图23-弱，扶抑格")
            } else {
                // TODO
                BaziResult(BaziResult.CONG_RUO, "新图23-从弱格")
            }
        }
        /**
         * 八.印在命局地支四次出现
         */
        // 新22
        if (yins == 4) {
            return BaziResult(BaziResult.RUO, "新图22-从印格")
        }
        /**
         * 七.根四次在地支出现或根印混杂在地支中出现4次
         */
        // 新21
        if (gens + yins == 4) {
            return BaziResult(BaziResult.CONG_QIANG, "新图21-从强格")
        }
        /**
         * 六.印三次在命局地支出现
         */
        if (yins == 3) {
            // TODO:
            if (isCai(dzs[YEAR]) || isCai(dzs[MONTH]) || isCai(dzs[HOUR])) {
                return BaziResult(BaziResult.WANG, "新图20-特殊格局")
            } else if (isGuan(dzs[YEAR]) || isGuan(dzs[HOUR])) {
                return BaziResult(BaziResult.WANG, "新图20-特殊格局")
            } else if (isGuan(dzs[MONTH])) {
                return if (isTouBenQi(dzs.get(MONTH))) {
                    BaziResult(BaziResult.JIA_CONG, "新图20-本气透出，假从印格")
                } else {
                    BaziResult(
                        BaziResult.CONG_QIANG,
                        "新图20-本气不透，从印格"
                    )
                }
            } else if (isGuan(dzs[DAY])) {
                return if (isTouBenQi(dzs.get(DAY))) {
                    BaziResult(BaziResult.JIA_CONG, "新图20-本气透出，假从印格")
                } else {
                    BaziResult(
                        BaziResult.CONG_QIANG,
                        "新图20-本气不透，从印格"
                    )
                }
            }
        }
        /**
         * 五.根三次或 根印三次在命局地支出现
         */
        if (gens + yins == 3) {
            if (isCai(dzs[YEAR]) || isGuan(dzs[YEAR]) || isShang(dzs[YEAR])) {
                return BaziResult(BaziResult.WANG, "新图16-扶抑格身旺")
            } else if ((isCai(dzs[HOUR]) || isGuan(dzs[HOUR])
                        || isShang(dzs[HOUR]))
            ) {
                return BaziResult(BaziResult.WANG, "新图16-扶抑格身旺")
            } else if (isCai(dzs[MONTH])) {
                if (isYin(dzs[YEAR]) || isYin(dzs[DAY])) {
                    return BaziResult(BaziResult.WANG, "新图17-财一次被克，身旺")
                } else {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(BaziResult.JIA_CONG, "新图17-假从强格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_QIANG,
                            "新图17-真从强格"
                        )
                    }
                }
            } else if (isGuan(dzs[MONTH])) {
                if (isYin(dzs[YEAR]) || isYin(dzs[DAY])) {
                    return BaziResult(BaziResult.WANG, "新图18-不从，按扶抑身旺论命")
                } else {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(BaziResult.JIA_CONG, "新图18-假从强格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_QIANG,
                            "新图18-真从强格"
                        )
                    }
                }
            } else if (isShang(dzs[MONTH])) {
                if (isYin(dzs[YEAR]) || isYin(dzs[DAY])) {
                    return BaziResult(
                        BaziResult.WANG,
                        "新图19-食伤一次被克，不以从强格，身旺"
                    )
                } else {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(BaziResult.JIA_CONG, "新图19-假从强格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_QIANG,
                            "新图19-真从强格"
                        )
                    }
                }
            } else if (isCai(dzs[DAY])) {
                if (isYin(dzs[MONTH]) || isYin(dzs[HOUR])) {
                    return BaziResult(BaziResult.WANG, "新图17-财一次被克，身旺")
                } else {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(BaziResult.JIA_CONG, "新图17-假从强格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_QIANG,
                            "新图17-真从强格"
                        )
                    }
                }
            } else if (isGuan(dzs[DAY])) {
                if (isYin(dzs[MONTH]) || isYin(dzs[HOUR])) {
                    return BaziResult(BaziResult.WANG, "新图18-不从，按扶抑身旺论命")
                } else {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(BaziResult.JIA_CONG, "新图18-假从强格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_QIANG,
                            "新图18-真从强格"
                        )
                    }
                }
            } else if (isShang(dzs[DAY])) {
                if (isYin(dzs[MONTH]) || isYin(dzs[HOUR])) {
                    return BaziResult(
                        BaziResult.WANG,
                        "新图19-食伤一次被克，不以从强格，身旺"
                    )
                } else {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(BaziResult.JIA_CONG, "新图19-假从强格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_QIANG,
                            "新图19-真从强格"
                        )
                    }
                }
            }
        }

        // 新8. 印星临年月以弱论。即使天干印比一片也弱。地支中印星同时出现两个，不论在何位置均以弱论。
        if (yins == 2) {
            return BaziResult(BaziResult.RUO, "新图8-印星两次出现，不论组合，不看天干，皆以弱论")
        }
        /**
         * **一，根印或根根组合，两次在地支中出现**
         */
        if (yins + gens == 2) {

            // 1.1 根印相邻，两次在地支中出现
            // 图1,2 根印帮扶
            // 1.2.日主在月令得根或印一次便是有旺的可能，再得年支或日支根一次便以旺论, 不必再看天干。
            // 新图1
            // 年和月支不能共同为印，否则为弱
            if (isGenYin(dzs[MONTH]) && isGenYin(dzs[YEAR])) {
                return BaziResult(BaziResult.WANG, "新图1")
            }

            // 新图2
            if (isGenYin(dzs[MONTH]) && isGenYin(dzs[DAY])) {
                return BaziResult(BaziResult.WANG, "新图2")
            }

            // 新图3，图4
            if (isGenYin(dzs[DAY]) && isGenYin(dzs[HOUR])) {
                return if (isAllBiOrYin) {
                    // 4. 如果天干全是印比则以身旺论。
                    BaziResult(BaziResult.WANG, "新图4")
                } else {
                    // 3.日主根印临日时支以身弱论命。
                    BaziResult(BaziResult.RUO, "新图3")
                }
            }
            // 新图5
            if (isGenYin(dzs[YEAR]) && isGenYin(dzs[DAY])) {
                // 年干与月干为印比
                if (isYinBi(tgs[YEAR]) && isYinBi(tgs[MONTH])) {
                    return BaziResult(BaziResult.WANG, "新图5-年干与月干为印比")
                } else return if (isWuHe(tgs.get(YEAR), tgs.get(MONTH))) {
                    BaziResult(
                        BaziResult.WANG,
                        "新图5-年干与月干得天干五合，合化后为印比"
                    )
                } else {
                    BaziResult(BaziResult.RUO, "新图5-年支和日支同时得根印,弱")
                }
            }

            // 新图6
            if (isGenYin(dzs[MONTH]) && isGenYin(dzs[HOUR])) {
                // 年干与月干为印比
                if (isYinBi(tgs[MONTH]) && isYinBi(tgs[HOUR])) {
                    return BaziResult(BaziResult.WANG, "新图6-月干与时干为印比")
                } else if (isWuHe(tgs[MONTH], tgs[DAY]) && isYinBi(tgs[HOUR])) {
                    return BaziResult(
                        BaziResult.WANG,
                        "新图6-月干与日主得天干五合，合化后为印比"
                    )
                } else return if (isWuHe(tgs.get(DAY), tgs.get(HOUR)) && isYinBi(tgs.get(MONTH))) {
                    BaziResult(
                        BaziResult.WANG,
                        "新图6-时干与日主得天干五合，合化后为印比"
                    )
                } else {
                    BaziResult(BaziResult.RUO, "新图6-月支和时支同时得根印,弱")
                }
            }

            // 新图7
            if (isGenYin(dzs[YEAR]) && isGenYin(dzs[HOUR])) {
                // 年干与月干为印比
                if ((isYinBi(tgs[YEAR]) && isYinBi(tgs[MONTH])
                            && isYinBi(tgs[HOUR]))
                ) {
                    return BaziResult(BaziResult.WANG, "新图7-年干月干与时干为印比")
                } else if (isWuHe(tgs[YEAR], tgs[MONTH]) && isYinBi(tgs[HOUR])) {
                    return BaziResult(
                        BaziResult.WANG,
                        "新图7-年干与月干得天干五合，合化后为印比"
                    )
                } else if ((isYinBi(tgs[YEAR]) && isWuHe(
                        tgs[MONTH],
                        tgs[DAY]
                    )
                            && isYinBi(tgs[HOUR]))
                ) {
                    return BaziResult(
                        BaziResult.WANG,
                        "新图7-月干与日主得天干五合，合化后为印比"
                    )
                } else return if ((isYinBi(tgs.get(YEAR)) && isWuHe(tgs.get(DAY), tgs.get(HOUR))
                            && isYinBi(tgs.get(MONTH)))
                ) {
                    BaziResult(
                        BaziResult.WANG,
                        "新图7-时干与日主得天干五合，合化后为印比"
                    )
                } else {
                    BaziResult(BaziResult.RUO, "新图7-月支和时支同时得根印,弱")
                }
            }
        }
        /**
         * 三. 根单独一次在命局地支中出现
         */
        if (gens == 1) {
            // 1. 根在年支或时支单独出现一次
            if (isGen(dzs[YEAR])) {
                if (dzs[YEAR]!!.isSheng((dzs[MONTH])!!)) {
                    return if (isTouBenQi(dzs.get(YEAR))) {
                        BaziResult(BaziResult.RUO, "新图9-本气透出，身弱扶抑格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_RUO,
                            "新图9-本气未透出，从弱"
                        )
                    }
                } else {
                    return BaziResult(BaziResult.RUO, "新图9-未被月支泄，身弱")
                }
            } else if (isGen(dzs[HOUR])) {
                if (dzs[HOUR]!!.isSheng((dzs[DAY])!!)) {
                    return if (isTouBenQi(dzs.get(HOUR))) {
                        BaziResult(BaziResult.RUO, "新图9-本气透出，身弱扶抑格")
                    } else {
                        BaziResult(
                            BaziResult.CONG_RUO,
                            "新图9-本气未透出，从弱"
                        )
                    }
                } else {
                    return BaziResult(BaziResult.RUO, "新图9-未被月支泄，身弱")
                }
            } else if (isGen(dzs[MONTH])) {
                if (dzs[YEAR]!!.isKe((dzs[MONTH])!!) && dzs[DAY]!!
                        .isKe((dzs[MONTH])!!)
                ) {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(
                            BaziResult.JIA_CONG,
                            "新图12-本气透出，按假从论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.CONG_RUO,
                            "新图12-本气未透出，按从格论命"
                        )
                    }
                } else if ((dzs[MONTH]!!.isSheng((dzs[YEAR])!!)
                            && dzs[MONTH]!!.isSheng((dzs[DAY])!!))
                ) {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(
                            BaziResult.JIA_CONG,
                            "新图13-本气透出，按假从论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.CONG_RUO,
                            "新图13-本气未透出，按从格论命"
                        )
                    }
                } else if ((dzs[MONTH]!!.isKe((dzs[YEAR])!!)
                            && dzs[MONTH]!!.isKe((dzs[DAY])!!))
                ) {
                    return BaziResult(
                        BaziResult.CONG_RUO,
                        "新图14-3-本气未透出，按从格论命"
                    )
                } else if (((dzs[YEAR]!!.isKe((dzs[MONTH])!!) && dzs[MONTH]!!.isSheng((dzs[DAY])!!))
                            || (dzs[DAY]!!.isKe((dzs[MONTH])!!) && dzs[MONTH]!!
                        .isSheng((dzs[YEAR])!!)))
                ) {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(
                            BaziResult.RUO,
                            "新图14-本气透出，按扶抑格身弱论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.CONG_RUO,
                            "新图14-本气未透出，按假从格论命"
                        )
                    }
                } else if (((dzs[MONTH]!!.isKe((dzs[YEAR])!!) && dzs[MONTH]!!
                        .isSheng((dzs[DAY])!!))
                            || (dzs[MONTH]!!.isKe((dzs[DAY])!!) && dzs[MONTH]!!
                        .isSheng((dzs[YEAR])!!)))
                ) {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(
                            BaziResult.RUO,
                            "新图14-2-一泄一耗，本气透出，按扶抑格身弱论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.JIA_CONG,
                            "新图14-2-一泄一耗，本气未透出，按假从格论命"
                        )
                    }
                } else if (((dzs[YEAR]!!.isKe((dzs[MONTH])!!) && dzs[MONTH]!!
                        .isKe((dzs[DAY])!!))
                            || (dzs[DAY]!!.isKe((dzs[MONTH])!!) && dzs[MONTH]!!
                        .isKe((dzs[YEAR])!!)))
                ) {
                    return BaziResult(BaziResult.RUO, "新图14-1,一克一耗，以扶抑身弱论命")
                }
            } else if (isGen(dzs[DAY])) {
                if (dzs[MONTH]!!.isKe((dzs[DAY])!!) && dzs[HOUR]!!
                        .isKe((dzs[DAY])!!)
                ) {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(
                            BaziResult.JIA_CONG,
                            "新图12-被两次克，本气透出，按假从论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.CONG_RUO,
                            "新图12-被两次克，本气未透出，按从格论命"
                        )
                    }
                } else if ((dzs[DAY]!!.isSheng((dzs[MONTH])!!)
                            && dzs[DAY]!!.isSheng((dzs[HOUR])!!))
                ) {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(
                            BaziResult.JIA_CONG,
                            "新图13-本气透出，按假从论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.CONG_RUO,
                            "新图13-本气未透出，按从格论命"
                        )
                    }
                } else if ((dzs[DAY]!!.isKe((dzs[MONTH])!!)
                            && dzs[DAY]!!.isKe((dzs[HOUR])!!))
                ) {
                    return BaziResult(
                        BaziResult.CONG_RUO,
                        "新图14-3-本气未透出，按从格论命"
                    )
                } else if (((dzs[MONTH]!!.isKe((dzs[DAY])!!) && dzs[DAY]!!
                        .isSheng((dzs[HOUR])!!))
                            || (dzs[HOUR]!!.isKe((dzs[DAY])!!) && dzs[DAY]!!
                        .isSheng((dzs[MONTH])!!)))
                ) {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(
                            BaziResult.RUO,
                            "新图14-一克一泄，本气透出，按扶抑格身弱论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.JIA_CONG,
                            "新图14-一克一泄，本气未透出，按假从格论命"
                        )
                    }
                } else if (((dzs[DAY]!!.isKe((dzs[MONTH])!!) && dzs[DAY]!!
                        .isSheng((dzs[HOUR])!!))
                            || (dzs[DAY]!!.isKe((dzs[HOUR])!!) && dzs[DAY]!!
                        .isSheng((dzs[MONTH])!!)))
                ) {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(
                            BaziResult.RUO,
                            "新图14-2-一泄一耗，本气透出，按扶抑格身弱论命"
                        )
                    } else {
                        BaziResult(
                            BaziResult.JIA_CONG,
                            "新图14-2-一泄一耗，本气未透出，按假从格论命"
                        )
                    }
                } else if (((dzs[MONTH]!!.isKe((dzs[DAY])!!) && dzs[DAY]!!
                        .isKe((dzs[HOUR])!!))
                            || (dzs[HOUR]!!.isKe((dzs[DAY])!!) && dzs[DAY]!!
                        .isKe((dzs[MONTH])!!)))
                ) {
                    return BaziResult(BaziResult.RUO, "新图14-1,一克一耗，以扶抑身弱论命")
                }
            }
        }
        /**
         * 四.印单独一次在命局地支出现
         */
        if (yins == 1) {
            if (isYin(dzs[YEAR]) || isYin(dzs[HOUR])) {
                return BaziResult(BaziResult.RUO, "新图15-1,身弱")
            } else if (isYin(dzs[MONTH])) {
                var yin_kes = 0
                if (dzs[YEAR]!!.isKe((dzs[MONTH])!!)) {
                    yin_kes++
                }
                if (dzs[DAY]!!.isKe((dzs[MONTH])!!)) {
                    yin_kes++
                }
                if (yin_kes == 1) {
                    return if (isTouBenQi(dzs.get(MONTH))) {
                        BaziResult(BaziResult.JIA_CONG, "图15-2,假从")
                    } else {
                        BaziResult(BaziResult.CONG_RUO, "图15-2,论从")
                    }
                } else return if (yin_kes == 2) {
                    BaziResult(BaziResult.CONG_RUO, "图15-3,从弱")
                } else {
                    BaziResult(BaziResult.RUO, "图15-4,身弱?")
                }
            } else if (isYin(dzs[DAY])) {
                var yin_kes = 0
                if (dzs[MONTH]!!.isKe((dzs[DAY])!!)) {
                    yin_kes++
                }
                if (dzs[HOUR]!!.isKe((dzs[DAY])!!)) {
                    yin_kes++
                }
                if (yin_kes == 1) {
                    return if (isTouBenQi(dzs.get(DAY))) {
                        BaziResult(BaziResult.JIA_CONG, "图15-2,假从")
                    } else {
                        BaziResult(BaziResult.CONG_RUO, "图15-2,论从")
                    }
                } else return if (yin_kes == 2) {
                    BaziResult(BaziResult.CONG_RUO, "图15-3,从弱")
                } else {
                    BaziResult(BaziResult.RUO, "图15-4,身弱?")
                }
            }
        }

        // 8.年支或时支临印星以身弱论
        if (isYin(dzs[YEAR]) || isYin(dzs[HOUR])) {
            return BaziResult(BaziResult.RUO, "图8")
        }

        // 9.根在年支或时支出现一个以身弱论
        // 根的本气如透出，则不从弱
        if (isGen(dzs[YEAR]) || isGen(dzs[HOUR])) {
            if (isGen(dzs[YEAR])) {
                return if (isGen(dzs.get(YEAR)!!.benQin)) {
                    BaziResult(BaziResult.WANG, "图9-3,本气透出")
                } else {
                    BaziResult(BaziResult.RUO, "图9")
                }
            } else if (isGen(dzs[HOUR])) {
                return if (isGen(dzs.get(HOUR)!!.benQin)) {
                    BaziResult(BaziResult.WANG, "图9-3")
                } else {
                    BaziResult(BaziResult.RUO, "图9")
                }
            }
        }

        // 10. 印星在月日地支中一次出现，一次被克从弱。本气秀出假从。两次被克从弱，即使本气透出也从弱。
        var kes_m = 0
        if (dzs[YEAR]!!.isKe((dzs[MONTH])!!)) {
            kes_m++
        }
        if (dzs[DAY]!!.isKe((dzs[MONTH])!!)) {
            kes_m++
        }
        var kes_d = 0
        if (dzs[MONTH]!!.isKe((dzs[DAY])!!)) {
            kes_d++
        }
        if (dzs[HOUR]!!.isKe((dzs[DAY])!!)) {
            kes_d++
        }
        if (isYin(dzs[MONTH])) {
            return if (isGen(dzs.get(MONTH)!!.benQin) && kes_m == 1) {
                BaziResult(BaziResult.WANG, "图10-月支被克一次，假从弱")
            } else {
                BaziResult(BaziResult.RUO, "图10-月支被克" + kes_m + "次")
            }
        } else if (isYin(dzs[DAY])) {
            return if (isGen(dzs.get(DAY)!!.benQin) && kes_m == 1) {
                BaziResult(BaziResult.WANG, "图10-日支被克一次，假从弱")
            } else {
                BaziResult(BaziResult.RUO, "图10-日支被克" + kes_m + "次")
            }
        }
        return BaziResult(BaziResult.UNKNOWN, "暂时还处理不了")
    }

    private fun isGen(dz: DiZhi?): Boolean {
        return dz!!.xing!!.xing == tgs[DAY]!!.xing.xing
    }

    private fun isYin(dz: DiZhi?): Boolean {
        return dz!!.xing!!.isSheng(tgs[DAY]!!.xing)
    }

    private fun isCai(dz: DiZhi?): Boolean {
        return tgs[DAY]!!.xing.isKe((dz!!.xing)!!)
    }

    private fun isGuan(dz: DiZhi?): Boolean {
        return dz!!.xing!!.isKe(tgs[DAY]!!.xing)
    }

    private fun isShang(dz: DiZhi?): Boolean {
        return tgs[DAY]!!.xing.isSheng((dz!!.xing)!!)
    }

    private fun isGenYin(dz: DiZhi?): Boolean {
        return isGen(dz) || isYin(dz)
    }

    private fun isBi(tg: TianGan?): Boolean {
        return tgs[DAY]!!.xing.xing == tg!!.xing.xing
    }

    private fun isGen(tg: TianGan): Boolean {
        return tgs[DAY]!!.tianGan == tg.tianGan
    }

    private fun isYin(tg: TianGan?): Boolean {
        return tg!!.isSheng((tgs[DAY])!!)
    }

    private fun isGen(xing: WuXing?): Boolean {
        return if (xing == null) {
            false
        } else {
            tgs.get(DAY)!!.xing.xing == xing.xing
        }
    }

    private fun isYin(xing: WuXing?): Boolean {
        return if (xing == null) false else xing.isSheng(tgs.get(DAY)!!.xing)
    }

    private fun isGenYin(xing: WuXing?): Boolean {
        return isGen(xing) || isYin(xing)
    }

    private fun isYinBi(tg: TianGan?): Boolean {
        return isYin(tg) || isBi(tg)
    }

    private fun isWuHe(tg1: TianGan?, tg2: TianGan?): Boolean {
        return isGenYin(tg1!!.isHe((tg2)!!))
    }

    private val isAllBiOrYin: Boolean
        private get() {
            var result = true
            for (i in YEAR..HOUR) {
                result = result && (isYin(tgs[i]) || isBi(tgs[i]))
            }
            return result
        }

    /**
     * 11.年支和日支同时得根印，只有两种组合为旺 12.根印在月时和年时时，以此类推
     *
     * @param dz1
     * @param dz2
     * @return
     */
    private fun method_5(c1: Int, c2: Int): BaziResult {
        if (isGenYin(dzs[c1]) && isGenYin(dzs[c2])) {
            // 年干与月干为印比
            if (isYinBi(tgs[YEAR]) && isYinBi(tgs[MONTH])) {
                return BaziResult(BaziResult.WANG, "新图5-年干与月干为印比")
            } else return if (isWuHe(tgs.get(YEAR), tgs.get(MONTH))) {
                BaziResult(BaziResult.WANG, "新图5-年干与月干得天干五合，合化后为印比")
            } else {
                BaziResult(BaziResult.RUO, "新图5-年支和日支同时得根印,弱")
            }
        } else {
            return BaziResult(BaziResult.UNKNOWN, "")
        }
    }

    private fun method_13(c1: Int, c2: Int): BaziResult {
        if (isGenYin(dzs[c1]) && isGenYin(dzs[c2])) {
            if (isYinBi(tgs[MONTH]) && isYinBi(tgs[HOUR])) {
                return BaziResult(BaziResult.WANG, "图13-月干与时干为印比")
            } else if (isWuHe(tgs[MONTH], tgs[DAY])) {
                return BaziResult(BaziResult.WANG, "图13-月干与日干得天干五合，合化后为印比")
            } else if (isWuHe(tgs[DAY], tgs[HOUR])) {
                return BaziResult(BaziResult.WANG, "图13-日干与时干得天干五合，合化后为印比")
            } else return if (isWuHe(tgs.get(MONTH), tgs.get(HOUR))) {
                BaziResult(BaziResult.WANG, "图13-月干与时干得天干五合，合化后为印比")
            } else {
                BaziResult(BaziResult.RUO, "图13-月支和时支同时得根印,弱")
            }
        } else {
            return BaziResult(BaziResult.UNKNOWN, "")
        }
    }

    private fun isTouBenQi(dz: DiZhi?): Boolean {
        val qi = dz!!.benQin.tianGan
        return (tgs[YEAR]!!.tianGan == qi) || (tgs[MONTH]!!.tianGan == qi
                ) || (tgs[HOUR]!!.tianGan == qi)
    }

    companion object {
        val YEAR = 0
        val MONTH = 1
        val DAY = 2
        val HOUR = 3
    }
}
