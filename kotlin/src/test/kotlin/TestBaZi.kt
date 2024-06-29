import com.github.lusing.bazi.BaZi
import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi
import com.github.lusing.qimen.TianGan
import org.junit.jupiter.api.Test

class TestBaZi {
    @Test
    fun testBaZi() {
        var bz =
            BaZi(
                TianGan.GENG,
                DiZhi.SHEN,
                TianGan.REN,
                DiZhi.WU,
                TianGan.REN,
                DiZhi.XU,
                TianGan.YI,
                DiZhi.SI,
                true,
                6,
                1980
            )
        bz.calcWang()
        bz.checkDaYun()


//        var bz2 =
//            BaZi(TianGan.YI, DiZhi.HAI, TianGan.JI, DiZhi.MAO, TianGan.JIA, DiZhi.ZI, TianGan.XIN, DiZhi.WEI, true)
//        bz2.calcWang()

        var bz3 =
            BaZi(
                TianGan.WU,
                DiZhi.CHEN,
                TianGan.GUI,
                DiZhi.HAI,
                TianGan.JI,
                DiZhi.MAO,
                TianGan.JI,
                DiZhi.SI,
                false,
                5,
                1988
            )
        bz3.calcWang()
        bz3.checkDaYun()

        var bz4 =
            BaZi(TianGan.WU, DiZhi.CHEN, TianGan.YI, DiZhi.MAO, TianGan.XIN, DiZhi.SI, TianGan.XIN, DiZhi.MAO, true)
        bz4.calcWang()

        //南怀瑾大师

        var bz5 =
            BaZi(TianGan.WU, DiZhi.WU, TianGan.YI, DiZhi.MAO, TianGan.JIA, DiZhi.ZI, TianGan.YI, DiZhi.HAI, true)
        bz5.calcWang()

        // 胡适大师
        var bz6 =
            BaZi(TianGan.XIN, DiZhi.MAO, TianGan.GENG, DiZhi.ZI, TianGan.DING, DiZhi.CHOU, TianGan.DING, DiZhi.WEI, true)
        bz6.calcWang()

        var bz7 =
            BaZi(TianGan.WU, DiZhi.ZI, TianGan.GENG, DiZhi.SHEN, TianGan.YI, DiZhi.CHOU, TianGan.REN, DiZhi.WU, true)
        bz7.calcWang()

        // 蒋中正
        println("蒋中正先生")
        var bz8 =
            BaZi(TianGan.DING, DiZhi.HAI, TianGan.GENG, DiZhi.XU, TianGan.JI, DiZhi.SI, TianGan.GENG, DiZhi.WU, true,9,1887)
        bz8.calcWang()
        bz8.checkDaYun()

        // 梅兰芳

        println("梅兰芳先生")
        var bz9 =
            BaZi(TianGan.JIA, DiZhi.WU, TianGan.JIA, DiZhi.XU, TianGan.DING, DiZhi.YOU, TianGan.GUI, DiZhi.MAO, true,6,1894)
        bz9.calcWang()
        bz9.checkDaYun()

        // 杜月笙
        println("杜月笙先生")
        var bz10 =
            BaZi(TianGan.WU, DiZhi.ZI, TianGan.GENG, DiZhi.SHEN, TianGan.YI, DiZhi.CHOU, TianGan.REN, DiZhi.WU, true,6,1888)
        bz10.calcWang()
        bz10.checkDaYun()

        // 韦千里先生
        println("韦千里先生")
        var bz11 =
            BaZi(TianGan.XIN, DiZhi.HAI, TianGan.XIN, DiZhi.MAO, TianGan.GENG, DiZhi.ZI, TianGan.GENG, DiZhi.CHEN, true,9,1911)
        bz11.calcWang()
        bz11.checkDaYun()

        println("冯京先生")
        var bz12 =
            BaZi(TianGan.XIN, DiZhi.YOU, TianGan.XIN, DiZhi.MAO, TianGan.GUI, DiZhi.CHOU, TianGan.XIN, DiZhi.MAO, true,7,1021)
        bz12.calcWang()

//        var gz = GanZhi(TianGan.JIA, DiZhi.ZI)
//        println(gz.add(1).getName())
    }
}