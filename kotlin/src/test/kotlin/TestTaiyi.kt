import org.junit.jupiter.api.Test
import com.github.lusing.taiyi.Taiyi
import com.github.lusing.taiyi.TaiyiPan
import org.junit.jupiter.api.Assertions.assertEquals

class TestTaiyi {
    @Test
    fun testTaiyi() {
        for (i in 0 until 26) {
            Taiyi.calcTaiyi(i, true)
        }
        for (i in 0 until 26) {
            Taiyi.calcTaiyi(i, false)
        }
    }

    @Test
    fun testCalcDist() {
        //陽一局
        assertEquals(TaiyiPan.calcDist(6, 1, 1), 7)
        //陽二局
        assertEquals(TaiyiPan.calcDist(6, 1, 0), 6)
        //陽三局
        assertEquals(TaiyiPan.calcDist(1, 1, 1), 1)
        //陽四局
        assertEquals(TaiyiPan.calcDist(1, 2, 0), 25)
        //陽五局
        assertEquals(TaiyiPan.calcDist(1, 2, 0), 25)
        //陽六局
        assertEquals(TaiyiPan.calcDist(8, 2, 1), 25)
    }
}