import com.github.lusing.qimen.DunJiaPan
import com.github.lusing.qimen.QiMenEngine
import org.junit.Test

class TestQimen {
    @Test
    fun testJunHao(): Unit {
        val qimen = QiMenEngine()
        qimen.run()
    }

    @Test
    fun testJiuGong() : Unit {
        val djp = DunJiaPan()
        for(i in 0..10) {
            djp.gotoCell(i)
        }
        println("-----")
        for(i in 0..10) {
            djp.gotoCellMinus(i)
        }
    }
}
