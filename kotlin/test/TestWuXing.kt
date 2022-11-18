import com.github.lusing.qimen.WuXing
import org.junit.Assert.assertEquals
import org.junit.Test

class TestWuXing {
    @Test
    fun testSheng() {
        val w1 = WuXing(WuXing.SHUI)
        val w2 = WuXing(WuXing.MU)
        assertEquals(true, w1.isSheng(w2))
    }
}