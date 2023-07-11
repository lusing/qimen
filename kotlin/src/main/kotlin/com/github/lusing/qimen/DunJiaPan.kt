package com.github.lusing.qimen

class DunJiaPan {
    private val cells: Array<Array<Cell>> = arrayOf(
        arrayOf(Cell(), Cell(), Cell()),
        arrayOf(Cell(), Cell(), Cell()),
        arrayOf(Cell(), Cell(), Cell())
    )
    var mJu: Int = 0
    var mYinYang: Boolean = true
    lateinit var mShiGan: TianGan
    lateinit var mXunShou: TianGan

    init {
        cells[0][0].id = 4
        cells[0][1].id = 9
        cells[0][2].id = 2
        cells[1][0].id = 3
        cells[1][1].id = 5
        cells[1][2].id = 7
        cells[2][0].id = 8
        cells[2][1].id = 1
        cells[2][2].id = 6

        cells[0][0].baGua = BaGua(BaGua.XUN)
        cells[0][1].baGua = BaGua(BaGua.LI)
        cells[0][2].baGua = BaGua(BaGua.KUN)
        cells[1][0].baGua = BaGua(BaGua.ZHEN)
        //cells[1][1].id = 5
        cells[1][2].baGua = BaGua(BaGua.DUI)
        cells[2][0].baGua = BaGua(BaGua.GEN)
        cells[2][1].baGua = BaGua(BaGua.KAN)
        cells[2][2].baGua = BaGua(BaGua.QIAN)

        var next = Pair(2, 1)
        for (i in 0..7) {
            cells[next.first][next.second].diPanJiuXing = JiuXing(i)
            cells[next.first][next.second].diPanBaMen = BaMen(i)
            next = getClockwise(next.first, next.second)
        }

//        for (i in 0..2) {
//            for (j in 0..2) {
//                cells[i][j].display()
//            }
//        }
    }

    /**
     * 获取九宫格中的下一个位置
     */
    fun getNext(x: Int, y: Int): Pair<Int, Int> {
        var nextX = x
        var nextY = y
        if (x == 0 && y == 0) {
            nextX = 1
            nextY = 1
        } else if (x == 1 && y == 0) {
            nextX = 0
            nextY = 0
        } else if (x == 2 && y == 0) {
            nextX = 0
            nextY = 1
        } else if (x == 2 && y == 1) {
            nextX = 0
            nextY = 2
        } else if (x == 2 && y == 2) {
            nextX = 1
            nextY = 2
        } else if (x == 1 && y == 2) {
            nextX = 2
            nextY = 0
        } else if (x == 0 && y == 2) {
            nextX = 1
            nextY = 0
        } else if (x == 0 && y == 1) {
            nextX = 2
            nextY = 1
        } else if (x == 1 && y == 1) {
            nextX = 2
            nextY = 2
        }
        return Pair(nextX, nextY)
    }

    /*
     * 获取九宫格中的上一个位置
     */
    fun getPrev(x: Int, y: Int): Pair<Int, Int> {
        var prevX = x
        var prevY = y
        if (x == 0 && y == 0) {
            prevX = 1
            prevY = 0
        } else if (x == 1 && y == 0) {
            prevX = 0
            prevY = 2
        } else if (x == 2 && y == 0) {
            prevX = 1
            prevY = 2
        } else if (x == 2 && y == 1) {
            prevX = 0
            prevY = 1
        } else if (x == 2 && y == 2) {
            prevX = 1
            prevY = 1
        } else if (x == 1 && y == 2) {
            prevX = 2
            prevY = 2
        } else if (x == 0 && y == 2) {
            prevX = 2
            prevY = 1
        } else if (x == 0 && y == 1) {
            prevX = 2
            prevY = 0
        } else if (x == 1 && y == 1) {
            prevX = 0
            prevY = 0
        }
        return Pair(prevX, prevY)
    }

    fun getClockwise(x: Int, y: Int): Pair<Int, Int> {
        if (x == 0 && y == 0) {
            return Pair(0, 1)
        } else if (x == 0 && y == 1) {
            return Pair(0, 2)
        } else if (x == 0 && y == 2) {
            return Pair(1, 2)
        } else if (x == 1 && y == 2) {
            return Pair(2, 2)
        } else if (x == 2 && y == 2) {
            return Pair(2, 1)
        } else if (x == 2 && y == 1) {
            return Pair(2, 0)
        } else if (x == 2 && y == 0) {
            return Pair(1, 0)
        } else if (x == 1 && y == 0) {
            return Pair(0, 0)
        } else {
            return Pair(0, 0)
        }
    }

    fun getAnitClockwise(x: Int, y: Int): Pair<Int, Int> {
        if (x == 0 && y == 0) {
            return Pair(1, 0)
        } else if (x == 1 && y == 0) {
            return Pair(2, 0)
        } else if (x == 2 && y == 0) {
            return Pair(2, 1)
        } else if (x == 2 && y == 1) {
            return Pair(2, 2)
        } else if (x == 2 && y == 2) {
            return Pair(1, 2)
        } else if (x == 1 && y == 2) {
            return Pair(0, 2)
        } else if (x == 0 && y == 2) {
            return Pair(0, 1)
        } else if (x == 0 && y == 1) {
            return Pair(0, 0)
        } else {
            return Pair(0, 0)
        }
    }

    fun gotoCell(i: Int): Pair<Int, Int> {
        var next = Pair(2, 1)
        //cells[next.first][next.second].display()
        for (x in 1 until i) {
            next = getNext(next.first, next.second)
            //cells[next.first][next.second].display()
        }
        //println()
        return next
    }

    fun gotoCellMinus(i: Int): Pair<Int, Int> {
        var prev = Pair(2, 1)
        cells[prev.first][prev.second].display()
        for (x in 1..i) {
            prev = getPrev(prev.first, prev.second)
            //cells[prev.first][prev.second].display()
        }
        //println()
        return prev
    }

    fun setJu(ju: Int, yinYang: Boolean) {
        this.mJu = ju
        this.mYinYang = yinYang
        var next = gotoCell(ju)
        var prev = next

        if (yinYang) {
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.WU)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.JI)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.GENG)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.XIN)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.REN)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.GUI)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.DING)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.BING)
            next = getNext(next.first, next.second)
            cells[next.first][next.second].diPanQiYi.qiyi = TianGan(TianGan.YI)
        } else {
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.WU)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.JI)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.GENG)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.XIN)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.REN)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.GUI)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.DING)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.BING)
            prev = getPrev(prev.first, prev.second)
            cells[prev.first][prev.second].diPanQiYi.qiyi = TianGan(TianGan.YI)
        }

        // 中五宫寄坤二宫
        cells[0][2].diPanQiYi.jigong = cells[1][1].diPanQiYi.qiyi
    }

    fun findXunShou(): Int {
        var xunShou = 1
        for (i in 0..2) {
            for (j in 0..2) {
                if (this.cells[i][j].diPanQiYi.qiyi!!.tianGan == this.mXunShou.tianGan) {
                    xunShou = this.cells[i][j].id
                    println("旬首落在${xunShou}宫")
                }
            }
        }
        return xunShou
    }

    fun findShiGan(): Int {
        var shiGan = 1
        for (i in 0..2) {
            for (j in 0..2) {
                if (this.cells[i][j].diPanQiYi.qiyi!!.tianGan == this.mShiGan.tianGan) {
                    shiGan = this.cells[i][j].id
                    println("时干落在${shiGan}宫")
                }
            }
        }
        return shiGan
    }

    fun setTianPan() : Unit {
        val shiGan = findShiGan()
        var gong = shiGan

        // 如果时干落中五宫，则取寄宫坤二宫
        if(shiGan==5){
            gong = 2
        }

        val xunshou = findXunShou()
        var xun_gong = xunshou

        if(xunshou == 5){
            xun_gong = 2
        }

        var pos1 = findCellById(gong)
        var pos2 = findCellById(xun_gong)

        val jx = getZhiFu()
        var jx_id = jx.id

        for(i in 0..7){
            cells[pos1.first][pos1.second].tianPanQiYi = cells[pos2.first][pos2.second].diPanQiYi
            cells[pos1.first][pos1.second].jiuXing = JiuXing(jx_id+i)
            cells[pos1.first][pos1.second].baShen = BaShen(i)
            pos1 = getClockwise(pos1.first, pos1.second)
            pos2 = getClockwise(pos2.first, pos2.second)
        }

        cells[1][1].tianPanQiYi = cells[1][1].diPanQiYi

        var rpos = findCellById(gong)

        if(!mYinYang){
            for(i in 0..7){
                cells[rpos.first][rpos.second].baShen = BaShen(i)
                rpos = getAnitClockwise(rpos.first, rpos.second)
            }
        }
    }

    fun getZhiFu(): JiuXing {
        val gong = this.findXunShou()
        if (gong == 5) {
            return this.cells[0][2].diPanJiuXing!!
        } else {
            var pos = findCellById(gong)
            return this.cells[pos.first][pos.second].diPanJiuXing!!
        }
    }

    fun findCellById(id: Int): Pair<Int, Int> {
        for (i in 0..2) {
            for (j in 0..2) {
                if (this.cells[i][j].id == id) {
                    return Pair(i, j)
                }
            }
        }
        return Pair(2, 1)
    }

    fun display() {
        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j].display()
                print("|")
            }
            println()
        }
    }
}
