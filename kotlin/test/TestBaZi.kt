import com.github.lusing.bazi.BaZi
import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi
import com.github.lusing.qimen.TianGan
import org.junit.Test

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

        var bz2 =
            BaZi(TianGan.YI, DiZhi.HAI, TianGan.JI, DiZhi.MAO, TianGan.JIA, DiZhi.ZI, TianGan.XIN, DiZhi.WEI, true)
        bz2.calcWang()

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

        var gz = GanZhi(TianGan.JIA, DiZhi.ZI)
        println(gz.add(1).getName())
    }
}