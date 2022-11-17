import com.github.lusing.qimen.DiZhi
import org.junit.Test

class TestDiZhi {
    @Test
    fun testHe(){
        val dz1 = DiZhi(DiZhi.ZI)
        val dz2 = DiZhi(DiZhi.WU)
        val dz3 = DiZhi(DiZhi.CHOU)
        val dz4 = DiZhi(DiZhi.WEI)
        assert(dz1.isChong(dz2))
    }
}