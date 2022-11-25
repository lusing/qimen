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

        // 卯月己卯日，弟弟为已经判为重罪的兄长问卦，想知道母亲去朝廷喊冤的话，能否把兄长救出。用衰逢生，危中有救
        val yaos2 = arrayOf(7, 8, 8, 6, 8, 8)
        val gua2 = Gua64(yaos2, TianGan.JI)
        val ly2 = LiuYao(gua2, DiZhi.MAO, DiZhi.MAO, LiuQin.XIONGDI)
        //val bgua = ly2.benGua.getBianGua()
        //bgua.debug()
        ly2.paiPan()
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

        // 丑月庚子日，测父亲疾病
//        val yao6 = arrayOf(8, 7, 7, 7, 7, 7)
//        val gua6 = Gua64(yao6, TianGan.GENG)
//        val ly6 = LiuYao(gua = gua6, yueJian = DiZhi.CHOU, riJian = DiZhi.ZI, yongShen = LiuQin.FUMU)
//        ly6.paiPan()

        // 巳月乙丑日，测父亲身体
//        val yao7 = arrayOf(6, 7, 7, 8, 7, 7)
//        val gua6 = Gua64(yao7, TianGan.YI)
//        val ly6 = LiuYao(gua = gua6, yueJian = DiZhi.SI, riJian = DiZhi.CHOU, yongShen = LiuQin.FUMU)
//        ly6.paiPan()

        // 酉月丙辰日，测孩子疾病
        // 用衰无克，勉力支撑
//        val yao8 = arrayOf(8, 7, 7, 8, 8, 8)
//        val gua8 = Gua64(yao8, TianGan.BING)
//        val ly8 = LiuYao(gua = gua8, yueJian = DiZhi.YOU, riJian = DiZhi.CHEN, yongShen = LiuQin.ZISUN)
//        ly8.paiPan()

        // 戌月丁卯日，占官司胜败
        // 用神弱极，衰极无救
//        val yao9 = arrayOf(7, 7, 7, 8, 8, 8)
//        val gua9 = Gua64(yao9, TianGan.DING)
//        val ly9 = LiuYao(gua = gua9, yueJian = DiZhi.XU, riJian = DiZhi.MAO, yongShen = LiuQin.XIONGDI) // TODO:世爻
//        ly9.paiPan()

        // 巳月戊午日，一老人自测病
//        val yao10 = arrayOf(6, 7, 8, 7, 8, 7)
//        val gua10 = Gua64(yao10, TianGan.WU)
//        val ly10 = LiuYao(gua = gua10, yueJian = DiZhi.SI, riJian = DiZhi.WU, yongShen = LiuQin.XIONGDI) // TODO:世爻
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

        // 申月乙巳日，一男测考试成绩
        // 合而化冲
//        val yao13 = arrayOf(8, 7, 7, 7, 9, 6)
//        val gua13 = Gua64(yao13, TianGan.YI)
//        val ly13 = LiuYao(gua = gua13, yueJian = DiZhi.SHEN, riJian = DiZhi.SI, yongShen = LiuQin.FUMU)
//        ly13.paiPan()

        // 戌月丁卯日，某人问一生能否得到官职
//        val yao14 = arrayOf(7, 7, 7, 8, 7, 8)
//        val gua14 = Gua64(yao14, TianGan.DING)
//        val ly14 = LiuYao(gua = gua14, yueJian = DiZhi.XU, riJian = DiZhi.MAO, yongShen = LiuQin.GUANGUI)
//        ly14.paiPan()

        // 卯月甲申日，占考试如何。父母爻为用神，原神持世
//        val yao15 = arrayOf(6, 8, 7, 8, 6, 7)
//        val gua15 = Gua64(yao15, TianGan.JIA)
//        val ly15 = LiuYao(gua = gua15, yueJian = DiZhi.MAO, riJian = DiZhi.SHEN, yongShen = LiuQin.FUMU)
//        ly15.paiPan()

        // 丑月庚子日，占问求官。官鬼爻为用神，仇神持世
//        val yao16 = arrayOf(7, 9, 7, 8, 8, 8)
//        val gua16 = Gua64(yao16, TianGan.GENG)
//        val ly16 = LiuYao(gua = gua16, yueJian = DiZhi.CHOU, riJian = DiZhi.ZI, yongShen = LiuQin.GUANGUI)
//        ly16.paiPan()

        // 子月gui酉日，用神妻财，闲神持世
//        val yao17 = arrayOf(8, 7, 7, 7, 8, 6)
//        val gua17 = Gua64(yao17, TianGan.GUI)
//        val ly17 = LiuYao(gua = gua17, yueJian = DiZhi.ZI, riJian = DiZhi.YOU, yongShen = LiuQin.QICAI)
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

        // TODO:克

        // 黎光吉凶占标准特例，申月乙卯日，占乱兵到，一家当避何处
//        val yao_lg001 = arrayOf(7, 6, 6, 7, 9, 9)
//        val gua_lg001 = Gua64(yao_lg001, TianGan.YI)
//        val ly_lg001 = LiuYao(gua = gua_lg001, yueJian = DiZhi.SHEN, riJian = DiZhi.MAO, yongShen = Yao.SHI_YAO)
//        ly_lg001.paiPan()
    }
}
