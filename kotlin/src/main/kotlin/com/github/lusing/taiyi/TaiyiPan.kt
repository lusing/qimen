package com.github.lusing.taiyi

class TaiyiPan {
    val pan = Array(5) { Array(5) { Cell(0,"","") } }

    init {
        pan[4][4] = Cell(1,"乾","阴德")
        pan[4][3] = Cell(8,"亥","大义")
        pan[4][2] = Cell(8,"子","地主")
        pan[4][1] = Cell(3,"丑","阳德")
        pan[4][0] = Cell(3,"艮","和德")
        pan[3][0] = Cell(4,"寅","吕申")
        pan[2][0] = Cell(4,"卯","高丛")
        pan[1][0] = Cell(9,"辰","太阳")
        pan[0][0] = Cell(9,"巽","大炅")
        pan[0][1] = Cell(2,"巳","大神")
        pan[0][2] = Cell(2,"午","大威")
        pan[0][3] = Cell(7,"未","天道")
        pan[0][4] = Cell(7,"坤","大武")
        pan[1][4] = Cell(6,"申","武德")
        pan[2][4] = Cell(6,"酉","太簇")
        pan[3][4] = Cell(1,"戌","阴主")
        var cell17 = pan[2][2]
        cell17.gongNum = 5
    }

    fun year(ty: Taiyi){
        // 太乙落客
        val gong: Int = ty.getTaiyi()
        luoGong(gong, XingShen(XingShen.TAI_YI))
    }

    fun mapGongToPos(gong :Int) : Cell?{
        return when(gong){
            1 -> pan[4][4]
            2 -> pan[0][2]
            3 -> pan[4][0]
            4 -> pan[2][0]
            6 -> pan[2][4]
            7 -> pan[0][4]
            8 -> pan[4][2]
            9 -> pan[0][0]
            else -> null
        }
    }

    fun luoGong(gong : Int, shen: XingShen){
        val cell = mapGongToPos(gong)
        cell?.shenList?.add(shen)
    }

    fun walk(){
        println("||||||")
        println("|-|-|-|-|-|")
        for(i in pan){
            for(j in i){
                if(j.gongNum==0){
                    print(" | ")
                    continue
                }
                print(j.name)
                print("<br>")
                print(j.jianShenName)
                print(' ')
                print(j.gongNum)
                print("<br>")
                j.printShen()
                print(" | ")
            }
            println()
        }
    }

}