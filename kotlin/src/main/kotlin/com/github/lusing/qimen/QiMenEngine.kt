package com.github.lusing.qimen

class QiMenEngine {
    fun run() {
        val yd1 = YinPanDunJia(
            GanZhi(TianGan.BING, DiZhi.XU),
            GanZhi(TianGan.GUI, DiZhi.SI),
            GanZhi(TianGan.REN, DiZhi.ZI),
            GanZhi(TianGan.GENG, DiZhi.XU),
            4,
            26,
            true
        )
        println(yd1)
        val yd2 = YinPanDunJia(
            GanZhi(TianGan.YI, DiZhi.HAI),
            GanZhi(TianGan.REN, DiZhi.WU),
            GanZhi(TianGan.GUI, DiZhi.YOU),
            GanZhi(TianGan.DING, DiZhi.SI),
            5,
            14,
            true
        )
        println(yd2)
        val yd3 = YinPanDunJia(
            GanZhi(TianGan.YI, DiZhi.YOU),
            GanZhi(TianGan.JI, DiZhi.MAO),
            GanZhi(TianGan.GUI, DiZhi.SI),
            GanZhi(TianGan.WU, DiZhi.WU),
            2,
            1,
            true
        )
        println(yd3)

        //例题，测病3
        val yd4 = YinPanDunJia(
            GanZhi(TianGan.BING, DiZhi.XU),
            GanZhi(TianGan.GUI, DiZhi.SI),
            GanZhi(TianGan.YI, DiZhi.CHOU),
            GanZhi(TianGan.GUI, DiZhi.WEI),
            5,
            10,
            true
        )
        println(yd4)

        //例题，测病4, 2006年6月14日，午时
        val yd5 = YinPanDunJia(
            GanZhi(TianGan.BING, DiZhi.XU),
            GanZhi(TianGan.JIA, DiZhi.WU),
            GanZhi(TianGan.JIA, DiZhi.XU),
            GanZhi(TianGan.GENG, DiZhi.WU),
            5,
            19,
            true
        )
        println(yd5)
    }
}
