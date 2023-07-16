import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.GanZhi
import com.github.lusing.qimen.TianGan
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

class TestXunKong {

    @Test
    fun testXunKong() {
        val gz = GanZhi(TianGan.JIA, DiZhi.ZI)
        val xk = gz.getXunKongNames()
        println(xk)
        assertEquals(true, gz.isXunKong(DiZhi(DiZhi.HAI)))
        assertEquals(true, gz.isXunKong(DiZhi(DiZhi.XU)))

        val gz1 = GanZhi(TianGan.YI, DiZhi.CHOU)
        val xk1 = gz1.getXunKong()
        println(xk1)

        val gz2 = GanZhi(TianGan.JIA, DiZhi.WU)
        val xk2 = gz2.getXunKong()
        println(xk2)
    }
}