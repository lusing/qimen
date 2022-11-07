import com.github.lusing.liuyao.Gua8

fun main() {
    //val eng = QiMenEngine()
    //eng.run()

    for (i in 1..8){
        val gua = Gua8(i)
        println(gua.getName())
    }
}