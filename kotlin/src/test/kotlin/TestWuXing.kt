import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.WuXing
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class TestWuXing {
    @Test
    fun testSheng() {
        val w1 = WuXing(WuXing.SHUI)
        val w2 = WuXing(WuXing.MU)
        assertEquals(true, w1.isSheng(w2))
    }

    // 入墓测试
    @Test
    fun testRuMu() {
        val w1 = WuXing(WuXing.SHUI)
        val w2 = WuXing(WuXing.MU)
        val w3 = WuXing(WuXing.HUO)
        val w4 = WuXing(WuXing.TU)
        val w5 = WuXing(WuXing.JIN)
        val z1 = DiZhi(DiZhi.CHEN)
        val z2 = DiZhi(DiZhi.WEI)
        val z3 = DiZhi(DiZhi.XU)
        val z4 = DiZhi(DiZhi.CHOU)
        assertEquals(true, w1.isRuMu(z1))
        assertEquals(true, w4.isRuMu(z1))
        assertEquals(true, w2.isRuMu(z2))
        assertEquals(true, w3.isRuMu(z3))
        assertEquals(true, w5.isRuMu(z4))
    }
}