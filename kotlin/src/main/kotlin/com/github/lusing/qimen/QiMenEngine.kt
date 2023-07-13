package com.github.lusing.qimen

class QiMenEngine {
    fun run() {
//        val yd1 = YinPanDunJia(
//            GanZhi(TianGan.BING, DiZhi.XU),
//            GanZhi(TianGan.GUI, DiZhi.SI),
//            GanZhi(TianGan.REN, DiZhi.ZI),
//            GanZhi(TianGan.GENG, DiZhi.XU),
//            4,
//            26,
//            true
//        )
//        println(yd1)
//        val yd2 = YinPanDunJia(
//            GanZhi(TianGan.YI, DiZhi.HAI),
//            GanZhi(TianGan.REN, DiZhi.WU),
//            GanZhi(TianGan.GUI, DiZhi.YOU),
//            GanZhi(TianGan.DING, DiZhi.SI),
//            5,
//            14,
//            true
//        )
//        println(yd2)
//        val yd3 = YinPanDunJia(
//            GanZhi(TianGan.YI, DiZhi.YOU),
//            GanZhi(TianGan.JI, DiZhi.MAO),
//            GanZhi(TianGan.GUI, DiZhi.SI),
//            GanZhi(TianGan.WU, DiZhi.WU),
//            2,
//            1,
//            true
//        )
//        println(yd3)
//
//        //例题，测病3
//        val yd4 = YinPanDunJia(
//            GanZhi(TianGan.BING, DiZhi.XU),
//            GanZhi(TianGan.GUI, DiZhi.SI),
//            GanZhi(TianGan.YI, DiZhi.CHOU),
//            GanZhi(TianGan.GUI, DiZhi.WEI),
//            5,
//            10,
//            true
//        )
//        println(yd4)
//
//        //例题，测病4, 2006年6月14日，午时
//        val yd5 = YinPanDunJia(
//            GanZhi(TianGan.BING, DiZhi.XU),
//            GanZhi(TianGan.JIA, DiZhi.WU),
//            GanZhi(TianGan.JIA, DiZhi.XU),
//            GanZhi(TianGan.GENG, DiZhi.WU),
//            5,
//            19,
//            true
//        )
//        println(yd5)

//        val yd6 = YinPanDunJia(
////            GanZhi(TianGan.REN, DiZhi.YIN),
////            GanZhi(TianGan.JIA, DiZhi.CHEN),
////            GanZhi(TianGan.GENG, DiZhi.XU),
////            GanZhi(TianGan.GUI, DiZhi.WEI),
////            3,
////            27,
////            true
////        )
////        println(yd6)

        val yd2023071118 = YinPanDunJia(
            GanZhi(TianGan.GUI, DiZhi.MAO),
            GanZhi(TianGan.JI, DiZhi.WEI),
            GanZhi(TianGan.GENG, DiZhi.WU),
            GanZhi(TianGan.YI, DiZhi.YOU),
            5,
            24,
            false
        )
        println(yd2023071118)

        val yd2023040620 = YinPanDunJia(
            GanZhi(TianGan.GUI, DiZhi.MAO),
            GanZhi(TianGan.BING, DiZhi.CHEN),
            GanZhi(TianGan.JIA, DiZhi.WU),
            GanZhi(TianGan.JIA, DiZhi.XU),
            2,
            16,
            true
        )
        println(yd2023040620)

        val yd200511181200 = YinPanDunJia(
            GanZhi(TianGan.DING, DiZhi.YOU),
            GanZhi(TianGan.BING, DiZhi.CHEN),
            GanZhi(TianGan.JIA, DiZhi.WU),
            GanZhi(TianGan.JIA, DiZhi.WU),
            10,
            17,
            false
        )
        println(yd200511181200)

        val yd202304060600 = YinPanDunJia(
            GanZhi(TianGan.GUI, DiZhi.MAO),
            GanZhi(TianGan.BING, DiZhi.CHEN),
            GanZhi(TianGan.JIA, DiZhi.WU),
            GanZhi(TianGan.DING, DiZhi.MAO),
            2,
            16,
            true
        )
        println(yd202304060600)
    }
}
