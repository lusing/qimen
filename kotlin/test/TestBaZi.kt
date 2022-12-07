import com.github.lusing.bazi.BaZi
import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.TianGan
import org.junit.Test

class TestBaZi {
    @Test
    fun testBaZi() {
        var bz = BaZi(TianGan.GENG, DiZhi.SHEN, TianGan.REN, DiZhi.WU, TianGan.REN, DiZhi.XU, TianGan.YI, DiZhi.SI)
        bz.calcWang()

        var bz2 = BaZi(TianGan.YI, DiZhi.HAI, TianGan.JI, DiZhi.MAO, TianGan.JIA, DiZhi.ZI, TianGan.XIN, DiZhi.WEI)
        bz2.calcWang()

        var bz3 = BaZi(TianGan.WU, DiZhi.CHEN, TianGan.GUI, DiZhi.HAI, TianGan.JI, DiZhi.MAO, TianGan.JI, DiZhi.SI)
        bz3.calcWang()
    }
}