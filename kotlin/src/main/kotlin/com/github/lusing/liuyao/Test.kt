package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin
import com.github.lusing.qimen.TianGan
import com.github.lusing.qimen.WuXing

class Test {
    fun test() {
        //val gua = Gua64(0b001111)
        //var yaos = arrayOf(6, 7, 7, 7, 7, 8)
        //val gua = Gua64(yaos, TianGan.JIA)
        //println(gua.getName())
        //gua.debug()
//        var bianGua = gua.getBianGua()
//        println(bianGua.getName())
//        bianGua.debug()

        //var liuyao1 = LiuYao(gua, DiZhi.MAO, DiZhi.MAO, LiuQin.XIONGDI)
        //liuyao1.paiPan()


//
//        val yao3 = arrayOf(7, 8, 7, 6, 7, 8)
//        val gua3 = Gua64(yao3, TianGan.BING)
//        val ly3 = LiuYao(gua = gua3, yueJian = DiZhi.CHEN, riJian = DiZhi.SHEN, yongShen = LiuQin.XIONGDI)
//        //ly3.paiPan()

// ==== 吉凶判断 ====

        // 卯月丙辰日，占父亲的病。父母为用神。用旺逢生，吉。Pass
//        val yao4 = arrayOf(7, 8, 8, 8, 8, 8)
//        val gua4 = Gua64(yao4, TianGan.BING)
//        val ly4 = LiuYao(gua = gua4, yueJian = DiZhi.MAO, riJian = DiZhi.CHEN, yongShen = LiuQin.FUMU)
//        ly4.paiPan()

        // 丑月戊子日，某人觉得心惊肉跳，占吉凶。用旺受克，易有不利。凶。Pass
//        val yao5 = arrayOf(7, 6, 8, 8, 7, 7)
//        val gua5 = Gua64(yao5, TianGan.WU)
//        val ly5 = LiuYao(gua = gua5, yueJian = DiZhi.CHOU, riJian = DiZhi.ZI, yongShen = Yao.SHI_YAO)
//        ly5.paiPan()

        // 卯月己卯日，弟弟为已经判为重罪的兄长问卦，想知道母亲去朝廷喊冤的话，能否把兄长救出。用衰逢生，危中有救。Pass
//        val yaos2 = arrayOf(7, 8, 8, 6, 8, 8)
//        val gua2 = Gua64(yaos2, TianGan.JI)
//        val ly2 = LiuYao(gua2, DiZhi.MAO, DiZhi.MAO, LiuQin.XIONGDI)
//        ly2.paiPan()

        // 丑月庚子日，测父亲疾病。用旺无克，平而无伤。用神双现，没有取近的。Pass.
//        val yao6 = arrayOf(8, 7, 7, 7, 7, 7)
//        val gua6 = Gua64(yao6, TianGan.GENG)
//        val ly6 = LiuYao(gua = gua6, yueJian = DiZhi.CHOU, riJian = DiZhi.ZI, yongShen = LiuQin.FUMU)
//        ly6.paiPan()

        // 巳月乙酉日，测父亲身体。用衰受克：屋漏逢雨，凶。Pass
//        val yao7 = arrayOf(8, 7, 7, 6, 7, 7)
//        val gua7 = Gua64(yao7, TianGan.YI)
//        val ly7 = LiuYao(gua = gua7, yueJian = DiZhi.SI, riJian = DiZhi.YOU, yongShen = LiuQin.FUMU)
//        ly7.paiPan()

        // 酉月丙辰日，测孩子疾病
        // 用衰无克，勉力支撑。Pass
//        val yao8 = arrayOf(8, 7, 7, 8, 8, 8)
//        val gua8 = Gua64(yao8, TianGan.BING)
//        val ly8 = LiuYao(gua = gua8, yueJian = DiZhi.YOU, riJian = DiZhi.CHEN, yongShen = LiuQin.ZISUN)
//        ly8.paiPan()

        // 戌月丁卯日，占官司胜败
        // 用神弱极，衰极无救
//        val yao9 = arrayOf(7, 7, 7, 8, 8, 8)
//        val gua9 = Gua64(yao9, TianGan.DING)
//        val ly9 = LiuYao(gua = gua9, yueJian = DiZhi.XU, riJian = DiZhi.MAO, yongShen = Yao.SHI_YAO)
//        ly9.paiPan()

        // 巳月戊午日，一老人自测病。用神旺极
//        val yao10 = arrayOf(6, 7, 8, 7, 8, 7)
//        val gua10 = Gua64(yao10, TianGan.WU)
//        val ly10 = LiuYao(gua = gua10, yueJian = DiZhi.SI, riJian = DiZhi.WU, yongShen = Yao.SHI_YAO)
//        ly10.paiPan()

        // 得失占

        // 未月丁巳日，一个刚刚离婚的男子后悔了，占问能否复合
        // 冲中逢合
//        val yao11 = arrayOf(9, 8, 7, 7, 8, 7)
//        val gua11 = Gua64(yao11, TianGan.DING)
//        val ly11 = LiuYao(gua = gua11, yueJian = DiZhi.WEI, riJian = DiZhi.SI, yongShen = LiuQin.QICAI)
//        ly11.paiPan()

        // 丑月戊寅日，一男子占孩子上学发展如何
        // 合而化冲
//        val yao12 = arrayOf(6, 6, 6, 7, 7, 7)
//        val gua12 = Gua64(yao12, TianGan.WU)
//        val ly12 = LiuYao(gua = gua12, yueJian = DiZhi.CHOU, riJian = DiZhi.YIN, yongShen = LiuQin.FUMU)
//        ly12.paiPan()

        // 申月乙巳日，一男测考试成绩。吉
        // 用神持世。TODO: 一生一克
//        val yao13 = arrayOf(8, 7, 7, 7, 9, 6)
//        val gua13 = Gua64(yao13, TianGan.YI)
//        val ly13 = LiuYao(gua = gua13, yueJian = DiZhi.SHEN, riJian = DiZhi.SI, yongShen = Yao.SHI_YAO)
//        ly13.paiPan()

        // 戌月丁卯日，某人问一生能否得到官职
        // 忌神持世，六静卦忌神持世为失
        // 自带属性，没有变化。子孙持世，休问功名
//        val yao14 = arrayOf(7, 7, 7, 8, 7, 8)
//        val gua14 = Gua64(yao14, TianGan.DING)
//        val ly14 = LiuYao(gua = gua14, yueJian = DiZhi.XU, riJian = DiZhi.MAO, yongShen = LiuQin.GUANGUI)
//        ly14.paiPan()

        // 卯月甲申日，占考试如何。父母爻为用神，原神持世。二者皆旺。
//        val yao15 = arrayOf(6, 8, 7, 8, 6, 7)
//        val gua15 = Gua64(yao15, TianGan.JIA)
//        val ly15 = LiuYao(gua = gua15, yueJian = DiZhi.MAO, riJian = DiZhi.SHEN, yongShen = LiuQin.FUMU)
//        ly15.paiPan()

        // 丑月庚子日，占问求官。官鬼爻为用神，仇神持世。旺，可以得官。但是吉凶不佳，死于任上。
//        val yao16 = arrayOf(7, 9, 7, 8, 8, 8)
//        val gua16 = Gua64(yao16, TianGan.GENG)
//        val ly16 = LiuYao(gua = gua16, yueJian = DiZhi.CHOU, riJian = DiZhi.ZI, yongShen = LiuQin.GUANGUI)
//        ly16.paiPan()

        // 分类占断 =====================================================

        // 申月己亥日，问考试情况如何
        // 得失占法看官父。实力一般，发挥不错，考上了
        // 世爻化回头克，入校后因为打架被开除了。如果世爻担不起来也是不行的
//        val yao17 = arrayOf(6, 9, 8, 8, 9, 7)
//        val gua17 = Gua64(yao17, TianGan.JI)
//        val ly17 = LiuYao(gua = gua17, yueJian = DiZhi.SHEN, riJian = DiZhi.HAI, yongShen = LiuQin.FUMU)
//        ly17.paiPan()

        // 丑月壬申日，占出版情况如何
        // 得失占法看父母。
        // 妻财爻化回头克，赚不到什么钱
        // 官鬼动化进，赚了些名声
//        val yao18 = arrayOf(7, 6, 8, 8, 6, 8)
//        val gua18 = Gua64(yao18, TianGan.REN)
//        val ly18 = LiuYao(gua = gua18, yueJian = DiZhi.CHOU, riJian = DiZhi.SHEN, yongShen = LiuQin.FUMU)
//        ly18.paiPan()

        // 丑月乙亥日，某女问职位能否调动
        // 官鬼爻为用神，伏藏而被飞神压制，没有行动之象。后来果然没有调动
        // 世爻旺，憋着一股气，但是没有动作
//        val yao19 = arrayOf(7, 8, 7, 8, 9, 7)
//        val gua19 = Gua64(yao19, TianGan.YI)
//        val ly19 = LiuYao(gua = gua19, yueJian = DiZhi.CHOU, riJian = DiZhi.HAI, yongShen = LiuQin.GUANGUI)
//        ly19.paiPan()

        // 卯月壬申日，出门学易，是否可行
        // 父母爻偏旺，能学有所成。
        // 但世爻化回头克，对自己不利
//        val yao20 = arrayOf(8, 7, 6, 8, 9, 7)
//        val gua20 = Gua64(yao20, TianGan.YI)
//        val ly20 = LiuYao(gua = gua20, yueJian = DiZhi.CHOU, riJian = DiZhi.HAI, yongShen = LiuQin.FUMU)
//        ly20.paiPan()


        // 酉月辛卯日，销售摩托车，前景如何？
        // 世用双旺，财爻发动克世爻，为财来靠近我
//        val yao21 = arrayOf(7, 8, 7, 9, 8, 8)
//        val gua21 = Gua64(yao21, TianGan.XIN)
//        val ly21 = LiuYao(gua = gua21, yueJian = DiZhi.YOU, riJian = DiZhi.MAO, yongShen = LiuQin.QICAI)
//        ly21.paiPan()

        // 卯月庚寅日，男子占妻子疾病
        // 辰月病重，夏天凶险
//        val yao22 = arrayOf(9, 9, 7, 8, 7, 8)
//        val gua22 = Gua64(yao22, TianGan.GENG)
//        val ly22 = LiuYao(gua = gua22, yueJian = DiZhi.MAO, riJian = DiZhi.YIN, yongShen = LiuQin.QICAI)
//        ly22.paiPan()

        // 子年未月己未日，男占婚
        // 世爻月破又旬空，但化回头生。
        // 妻财没有上卦，不是好事。但世爻化出妻财。虽然这个人很烂，但是有女生倒贴。压在兄弟爻下面的女生是他得不到的，因为兄弟克妻财。
        // 子年，子与丑合，不至于有什么坏事。子与午冲，本年异性缘是不好的
//        val yao23 = arrayOf(7, 8, 7, 6, 8, 8)
//        val gua23 = Gua64(yao23, TianGan.JI)
//        val ly23 = LiuYao(gua = gua23, yueJian = DiZhi.WEI, riJian = DiZhi.WEI, yongShen = LiuQin.QICAI)
//        ly23.paiPan()

        // 女生占婚姻，得失占法看官鬼
        // 亥月戊子日。
        // 官鬼木得多个水来生，说明女生缘好。
        // 卯戌相合，男生和兄弟爻相合。
//        val yao24 = arrayOf(7, 7, 8, 7, 7, 9)
//        val gua24 = Gua64(yao24, TianGan.WU)
//        val ly24 = LiuYao(gua = gua24, yueJian = DiZhi.HAI, riJian = DiZhi.ZI, yongShen = LiuQin.GUANGUI)
//        ly24.paiPan()

        // 比赛：世爻与应爻的旺衰比较
        // 申月乙未日，占比赛
//        val yao25 = arrayOf(7, 7, 8, 8, 7, 8)
//        val gua25 = Gua64(yao25, TianGan.YI)
//        val ly25 = LiuYao(gua = gua25, yueJian = DiZhi.SHEN, riJian = DiZhi.WEI, yongShen = Yao.YING_YAO)
//        ly25.paiPan()


        // 子月gui酉日，用神妻财，闲神持世
//        val yao17 = arrayOf(8, 7, 7, 7, 8, 6)
//        val gua17 = Gua64(yao17, TianGan.GUI)
//        val ly17 = LiuYao(gua = gua17, yueJian = DiZhi.ZI, riJian = DiZhi.YOU, yongShen = Yao.YING_YAO)
//        ly17.paiPan()

        // 亥月壬午日，占法国在世界杯是否可以夺冠

//        val yao_ma01 = arrayOf(8, 6, 8, 8, 8, 6)
//        val gua_ma01 = Gua64(yao_ma01, TianGan.REN)
//        val ly_ma01 = LiuYao(gua = gua_ma01, yueJian = DiZhi.HAI, riJian = DiZhi.WU, yongShen = Yao.SHI_YAO)
//        ly_ma01.paiPan()

        // 亥月壬午日，占北京疫情

//        val yao_xulun001 = arrayOf(9, 9, 7, 8, 6, 7)
//        val gua_xulun001 = Gua64(yao_xulun001, TianGan.REN)
//        val ly_xulun001 = LiuYao(gua = gua_xulun001, yueJian = DiZhi.HAI, riJian = DiZhi.WU, yongShen = Yao.SHI_YAO)
//        ly_xulun001.paiPan()

        // 亥月壬午日，占石家庄疫情
//        val yao_xulun002 = arrayOf(6, 6, 7, 6, 6, 7)
//        val gua_xulun002 = Gua64(yao_xulun002, TianGan.REN)
//        val ly_xulun002 = LiuYao(gua = gua_xulun002, yueJian = DiZhi.HAI, riJian = DiZhi.WU, yongShen = Yao.YING_YAO)
//        ly_xulun002.paiPan()

        // 亥月壬午日，占纳斯达克指数涨跌
//        val yao_xulun003 = arrayOf(8, 8, 8, 8, 9, 6)
//        val gua_xulun003 = Gua64(yao_xulun003, TianGan.REN)
//        val ly_xulun003 = LiuYao(gua = gua_xulun003, yueJian = DiZhi.HAI, riJian = DiZhi.WU, yongShen = LiuQin.QICAI)
//        ly_xulun003.paiPan()

        // 亥月壬午日，占纳斯达克指数涨跌
//        val yao_xulun003 = arrayOf(8, 8, 8, 8, 9, 6)
//        val gua_xulun003 = Gua64(yao_xulun003, TianGan.REN)
//        val ly_xulun003 = LiuYao(gua = gua_xulun003, yueJian = DiZhi.HAI, riJian = DiZhi.WU, yongShen = LiuQin.QICAI)
//        ly_xulun003.paiPan()

        // 亥月丁亥日，占77的小弟转正是否成功
//        val yao_xulun004 = arrayOf(7, 6, 7, 8, 7, 9)
//        val gua_xulun004 = Gua64(yao_xulun004, TianGan.DING)
//        val ly_xulun004 = LiuYao(gua = gua_xulun004, yueJian = DiZhi.HAI, riJian = DiZhi.HAI, yongShen = LiuQin.GUANGUI)
//        ly_xulun004.paiPan()

        // 亥月庚辰日，占工作
//        val yao_yuanheng001 = arrayOf(8, 8, 8, 7, 8, 8)
//        val gua_yuanheng001 = Gua64(yao_yuanheng001, TianGan.GENG)
//        val ly_yuanheng001 = LiuYao(gua = gua_yuanheng001, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng001.paiPan()

        // 亥月辛巳日，占和好
//        val yao_yuanheng002 = arrayOf(7, 8, 8, 8, 8, 8)
//        val gua_yuanheng002 = Gua64(yao_yuanheng002, TianGan.XIN)
//        val ly_yuanheng002 = LiuYao(gua = gua_yuanheng002, yueJian = DiZhi.HAI, riJian = DiZhi.SI, yongShen = LiuQin.QICAI)
//        ly_yuanheng002.paiPan()

        // 亥月壬午日，占跟女朋友吵架
//        val yao_yuanheng003 = arrayOf(8, 6, 9, 8, 7, 8)
//        val gua_yuanheng003 = Gua64(yao_yuanheng003, TianGan.REN)
//        val ly_yuanheng003 = LiuYao(gua = gua_yuanheng003, yueJian = DiZhi.HAI, riJian = DiZhi.WU, yongShen = LiuQin.QICAI)
//        ly_yuanheng003.paiPan()

        // 亥月　癸未日，占领导能不能被调走
//        val yao_yuanheng004 = arrayOf(8, 7, 7, 8, 7, 7)
//        val gua_yuanheng004 = Gua64(yao_yuanheng004, TianGan.GUI)
//        val ly_yuanheng004 = LiuYao(gua = gua_yuanheng004, yueJian = DiZhi.HAI, riJian = DiZhi.WEI, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng004.paiPan()

        // 亥月　癸未日，占表白能不能成功
//        val yao_yuanheng005 = arrayOf(6, 9, 8, 7, 7, 8)
//        val gua_yuanheng005 = Gua64(yao_yuanheng005, TianGan.GUI)
//        val ly_yuanheng005 = LiuYao(gua = gua_yuanheng005, yueJian = DiZhi.HAI, riJian = DiZhi.WEI, yongShen = LiuQin.QICAI)
//        ly_yuanheng005.paiPan()

        // 亥月　癸未日, 占与女生的缘分
//        val yao_yuanheng006 = arrayOf(8, 8, 9, 8, 8, 8)
//        val gua_yuanheng006 = Gua64(yao_yuanheng006, TianGan.GUI)
//        val ly_yuanheng006 = LiuYao(gua = gua_yuanheng006, yueJian = DiZhi.HAI, riJian = DiZhi.WEI, yongShen = LiuQin.QICAI)
//        ly_yuanheng006.paiPan()

        // 亥月　癸未日, 占与女生能不能在一起
//        val yao_yuanheng007 = arrayOf(9, 7,7, 7, 7, 7)
//        val gua_yuanheng007 = Gua64(yao_yuanheng007, TianGan.GUI)
//        val ly_yuanheng007 = LiuYao(gua = gua_yuanheng007, yueJian = DiZhi.HAI, riJian = DiZhi.WEI, yongShen = LiuQin.QICAI)
//        ly_yuanheng007.paiPan()

        // 亥月　乙酉日，女生占异性缘
//        val yao_yuanheng008 = arrayOf(9, 6, 8, 8, 9, 9)
//        val gua_yuanheng008 = Gua64(yao_yuanheng008, TianGan.YI)
//        val ly_yuanheng008 =
//            LiuYao(gua = gua_yuanheng008, yueJian = DiZhi.HAI, riJian = DiZhi.YOU, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng008.paiPan()

        // 亥月  丙戌日，占领导谈话原因
//        val yao_yuanheng009 = arrayOf(7, 8, 7, 9, 6, 8)
//        val gua_yuanheng009 = Gua64(yao_yuanheng009, TianGan.BING)
//        val ly_yuanheng009 =
//            LiuYao(gua = gua_yuanheng009, yueJian = DiZhi.HAI, riJian = DiZhi.XU, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng009.paiPan()

        // 亥月　丙戌日，占财运
//        val yao_yuanheng0010 = arrayOf(8, 7, 6, 8, 8, 9)
//        val gua_yuanheng0010 = Gua64(yao_yuanheng0010, TianGan.BING)
//        val ly_yuanheng0010 =
//            LiuYao(gua = gua_yuanheng0010, yueJian = DiZhi.HAI, riJian = DiZhi.XU, yongShen = LiuQin.QICAI)
//        ly_yuanheng0010.paiPan()

        // 辛亥月  丁亥日，占财运
//        val yao_yuanheng0011 = arrayOf(8, 8, 8, 9, 9, 8)
//        val gua_yuanheng0011 = Gua64(yao_yuanheng0011, TianGan.DING)
//        val ly_yuanheng0011 =
//            LiuYao(gua = gua_yuanheng0011, yueJian = DiZhi.HAI, riJian = DiZhi.HAI, yongShen = LiuQin.QICAI)
//        ly_yuanheng0011.paiPan()

        // 辛亥月　丁亥日，占财运
//        val yao_yuanheng0012 = arrayOf(7, 7, 9, 8, 8, 7)
//        val gua_yuanheng0012 = Gua64(yao_yuanheng0012, TianGan.DING)
//        val ly_yuanheng0012 =
//            LiuYao(gua = gua_yuanheng0012, yueJian = DiZhi.HAI, riJian = DiZhi.HAI, yongShen = LiuQin.QICAI)
//        ly_yuanheng0012.paiPan()

        //亥月　辛卯日，女占感情
//        val yao_yuanheng0013 = arrayOf(6, 9, 7, 7, 9, 7)
//        val gua_yuanheng0013 = Gua64(yao_yuanheng0013, TianGan.XIN)
//        val ly_yuanheng0013 =
//            LiuYao(gua = gua_yuanheng0013, yueJian = DiZhi.HAI, riJian = DiZhi.MAO, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0013.paiPan()

        // 亥月　辛卯日，占与姑娘缘份
//        val yao_yuanheng0014 = arrayOf(8, 8, 6, 7, 7, 9)
//        val gua_yuanheng0014 = Gua64(yao_yuanheng0014, TianGan.XIN)
//        val ly_yuanheng0014 =
//            LiuYao(gua = gua_yuanheng0014, yueJian = DiZhi.HAI, riJian = DiZhi.MAO, yongShen = LiuQin.QICAI)
//        ly_yuanheng0014.paiPan()

        // 亥月　壬辰日，占升职
//        val yao_yuanheng0015 = arrayOf(8, 6, 9, 8, 8, 7)
//        val gua_yuanheng0015 = Gua64(yao_yuanheng0015, TianGan.REN)
//        val ly_yuanheng0015 =
//            LiuYao(gua = gua_yuanheng0015, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0015.paiPan()

        // 亥月 壬辰日，测中药是否有效
//        val yao_yuanheng0016 = arrayOf(7, 8, 9, 7, 7, 9)
//        val gua_yuanheng0016 = Gua64(yao_yuanheng0016, TianGan.REN)
//        val ly_yuanheng0016 =
//            LiuYao(gua = gua_yuanheng0016, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.FUMU)
//        ly_yuanheng0016.paiPan()

        // 亥月　壬辰日，测防疫工作是否有利
//        val yao_yuanheng0017 = arrayOf(7, 8, 8, 8, 7, 8)
//        val gua_yuanheng0017 = Gua64(yao_yuanheng0017, TianGan.REN)
//        val ly_yuanheng0017 =
//            LiuYao(gua = gua_yuanheng0017, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0017.paiPan()

        // 辛亥月　壬辰日，占能否找到工作
//        val yao_yuanheng0018 = arrayOf(7, 6, 8, 6, 9, 8)
//        val gua_yuanheng0018 = Gua64(yao_yuanheng0018, TianGan.REN)
//        val ly_yuanheng0018 =
//            LiuYao(gua = gua_yuanheng0018, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0018.paiPan()

        // 辛亥月　壬辰日，占是否继续在此工作
//        val yao_yuanheng0019 = arrayOf(8, 7, 7, 7, 9, 7)
//        val gua_yuanheng0019 = Gua64(yao_yuanheng0019, TianGan.REN)
//        val ly_yuanheng0019 =
//            LiuYao(gua = gua_yuanheng0019, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0019.paiPan()

        // 辛亥月　辛卯日，占工作变化
//        val yao_yuanheng0020 = arrayOf(9, 8, 7, 7, 7, 7)
//        val gua_yuanheng0020 = Gua64(yao_yuanheng0020, TianGan.XIN)
//        val ly_yuanheng0020 =
//            LiuYao(gua = gua_yuanheng0020, yueJian = DiZhi.HAI, riJian = DiZhi.MAO, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0020.paiPan()

        //辛亥月　壬辰日，测财能要回来多少
//        val yao_yuanheng0021 = arrayOf(7, 8, 6, 7, 8, 7)
//        val gua_yuanheng0021 = Gua64(yao_yuanheng0021, TianGan.REN)
//        val ly_yuanheng0021 =
//            LiuYao(gua = gua_yuanheng0021, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.QICAI)
//        ly_yuanheng0021.paiPan()

        //  辛亥月  壬辰日 占工作
//        val yao_yuanheng0027 = arrayOf(9, 6, 7, 8, 6, 8)
//        val gua_yuanheng0027 = Gua64(yao_yuanheng0027, TianGan.REN)
//        val ly_yuanheng0027 =
//            LiuYao(gua = gua_yuanheng0027, yueJian = DiZhi.HAI, riJian = DiZhi.CHEN, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0027.paiPan()

        // 亥月　癸巳日，女占工作机会
//        val yao_yuanheng0022 = arrayOf(7, 8, 6, 8, 8, 8)
//        val gua_yuanheng0022 = Gua64(yao_yuanheng0022, TianGan.GUI)
//        val ly_yuanheng0022 =
//            LiuYao(gua = gua_yuanheng0022, yueJian = DiZhi.HAI, riJian = DiZhi.SI, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0022.paiPan()

        //  辛亥月  癸巳日，女占感情
//        val yao_yuanheng0023 = arrayOf(8, 8, 6, 9, 8, 7)
//        val gua_yuanheng0023 = Gua64(yao_yuanheng0023, TianGan.GUI)
//        val ly_yuanheng0023 =
//            LiuYao(gua = gua_yuanheng0023, yueJian = DiZhi.HAI, riJian = DiZhi.SI, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0023.paiPan()

        // 辛亥月　癸巳日，女占工作
//        val yao_yuanheng0024 = arrayOf(8, 7, 8, 8, 8, 8)
//        val gua_yuanheng0024 = Gua64(yao_yuanheng0024, TianGan.GUI)
//        val ly_yuanheng0024 =
//            LiuYao(gua = gua_yuanheng0024, yueJian = DiZhi.HAI, riJian = DiZhi.SI, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0024.paiPan()

        // 辛亥月　癸巳日，女占去夫城市的吉凶
//        val yao_yuanheng0025 = arrayOf(7, 8, 9, 9, 6, 6)
//        val gua_yuanheng0025 = Gua64(yao_yuanheng0025, TianGan.GUI)
//        val ly_yuanheng0025 =
//            LiuYao(gua = gua_yuanheng0025, yueJian = DiZhi.HAI, riJian = DiZhi.SI, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0025.paiPan()

        // 辛亥月　癸巳日，男测明年财运
//        val yao_yuanheng0026 = arrayOf(7, 8, 8, 6, 7, 9)
//        val gua_yuanheng0026 = Gua64(yao_yuanheng0026, TianGan.GUI)
//        val ly_yuanheng0026 =
//            LiuYao(gua = gua_yuanheng0026, yueJian = DiZhi.HAI, riJian = DiZhi.SI, yongShen = LiuQin.QICAI)
//        ly_yuanheng0026.paiPan()

        //辛亥月　癸巳日，占升职
//        val yao_yuanheng0028 = arrayOf(9, 7, 9, 7, 7, 7)
//        val gua_yuanheng0028 = Gua64(yao_yuanheng0028, TianGan.GUI)
//        val ly_yuanheng0028 =
//            LiuYao(gua = gua_yuanheng0028, yueJian = DiZhi.HAI, riJian = DiZhi.SI, yongShen = LiuQin.GUANGUI)
//        ly_yuanheng0028.paiPan()

        //壬子月 戊戌日 占感情
        val yao_yuanheng0029 = arrayOf(7, 7, 8, 8, 6, 8)
        val gua_yuanheng0029 = Gua64(yao_yuanheng0029, TianGan.WU)
        val ly_yuanheng0029 =
            LiuYao(gua = gua_yuanheng0029, yueJian = DiZhi.ZI, riJian = DiZhi.XU, yongShen = LiuQin.GUANGUI)
        ly_yuanheng0029.paiPan()

        // 黎光吉凶占标准特例，申月乙卯日，占乱兵到，一家当避何处
//        val yao_lg001 = arrayOf(7, 6, 6, 7, 9, 9)
//        val gua_lg001 = Gua64(yao_lg001, TianGan.YI)
//        val ly_lg001 = LiuYao(gua = gua_lg001, yueJian = DiZhi.SHEN, riJian = DiZhi.MAO, yongShen = Yao.SHI_YAO)
//        ly_lg001.paiPan()

        // 未月丁巳日，占能否与妻子复合
//        val yao_lg002 = arrayOf(9, 8, 7, 7, 8, 7)
//        val gua_lg002 = Gua64(yao_lg002, TianGan.DING)
//        val ly_lg002 = LiuYao(gua = gua_lg002, yueJian = DiZhi.WEI, riJian = DiZhi.SI, yongShen = LiuQin.QICAI)
//        ly_lg002.paiPan()

        // 寅月戊戌日，占丢失财物
//        val yao_lg003 = arrayOf(8, 7, 9, 6, 7, 7)
//        val gua_lg003 = Gua64(yao_lg003, TianGan.WU)
//        val ly_lg003 = LiuYao(gua = gua_lg003, yueJian = DiZhi.YIN, riJian = DiZhi.XU, yongShen = LiuQin.QICAI)
//        ly_lg003.paiPan()

        // 戌月甲辰日，占能否借到钱
//        val yao_lg004 = arrayOf(8, 8, 8, 8, 8, 8)
//        val gua_lg004 = Gua64(yao_lg004, TianGan.JIA)
//        val ly_lg004 = LiuYao(gua = gua_lg004, yueJian = DiZhi.XU, riJian = DiZhi.CHEN, yongShen = LiuQin.QICAI)
//        ly_lg004.paiPan()

        // 午月丙辰日，占外出贸易财运如何
//        val yao_lg005 = arrayOf(8, 9, 9, 7, 8, 8)
//        val gua_lg005 = Gua64(yao_lg005, TianGan.BING)
//        val ly_lg005 = LiuYao(gua = gua_lg005, yueJian = DiZhi.WU, riJian = DiZhi.CHEN, yongShen = LiuQin.QICAI)
//        ly_lg005.paiPan()
    }
}
