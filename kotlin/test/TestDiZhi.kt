import com.github.lusing.qimen.DiZhi
import org.junit.Assert.assertEquals
import org.junit.Test

class TestDiZhi {
    @Test
    fun testChong() {
        val dz1 = DiZhi(DiZhi.ZI)
        val dz2 = DiZhi(DiZhi.CHOU)
        val dz3 = DiZhi(DiZhi.YIN)
        val dz4 = DiZhi(DiZhi.MAO)
        val dz5 = DiZhi(DiZhi.CHEN)
        val dz6 = DiZhi(DiZhi.SI)
        val dz7 = DiZhi(DiZhi.WU)
        val dz8 = DiZhi(DiZhi.WEI)
        val dz9 = DiZhi(DiZhi.SHEN)
        val dz10 = DiZhi(DiZhi.YOU)
        val dz11 = DiZhi(DiZhi.XU)
        val dz12 = DiZhi(DiZhi.HAI)
        assertEquals(true, dz1.isChong(dz7))
        assertEquals(true, dz2.isChong(dz8))
        assertEquals(true, dz3.isChong(dz9))
        assertEquals(true, dz4.isChong(dz10))
        assertEquals(true, dz5.isChong(dz11))
        assertEquals(true, dz6.isChong(dz12))
    }

    @Test
    fun testHe() {
        val dz1 = DiZhi(DiZhi.ZI)
        val dz2 = DiZhi(DiZhi.CHOU)
        val dz3 = DiZhi(DiZhi.YIN)
        val dz4 = DiZhi(DiZhi.MAO)
        val dz5 = DiZhi(DiZhi.CHEN)
        val dz6 = DiZhi(DiZhi.SI)
        val dz7 = DiZhi(DiZhi.WU)
        val dz8 = DiZhi(DiZhi.WEI)
        val dz9 = DiZhi(DiZhi.SHEN)
        val dz10 = DiZhi(DiZhi.YOU)
        val dz11 = DiZhi(DiZhi.XU)
        val dz12 = DiZhi(DiZhi.HAI)
        assertEquals(true, dz1.isHe(dz2))
        assertEquals(true, dz3.isHe(dz12))
        assertEquals(true, dz4.isHe(dz11))
        assertEquals(true, dz5.isHe(dz10))
        assertEquals(true, dz6.isHe(dz9))
        assertEquals(true, dz7.isHe(dz8))
    }
}