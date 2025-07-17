import org.junit.jupiter.api.Test
import com.github.lusing.taiyi.Taiyi

class TestTaiyi {
    @Test
    fun testTaiyi(){
        for(i in 0 until 26){
            Taiyi.calcTaiyi(i,true)
        }
        for(i in 0 until 26){
            Taiyi.calcTaiyi(i,false)
        }
    }
}