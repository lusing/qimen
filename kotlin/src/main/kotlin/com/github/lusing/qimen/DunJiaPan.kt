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
    lateinit var mShiZhi: DiZhi
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

    private fun getAnitClockwise(x: Int, y: Int): Pair<Int, Int> {
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

        var cursor = TianGan(TianGan.WU)

        for (i in 1..9) {
            if (yinYang) {
                cells[next.first][next.second].diPanQiYi.qiyi = cursor
                next = getNext(next.first, next.second)
                cursor = getNextQiYi(cursor)
            } else {
                cells[prev.first][prev.second].diPanQiYi.qiyi = cursor
                prev = getPrev(prev.first, prev.second)
                cursor = getNextQiYi(cursor)
            }
        }

        // 中五宫寄坤二宫
        cells[0][2].diPanQiYi.jigong = cells[1][1].diPanQiYi.qiyi
    }

    fun getNextQiYi(qiyi: TianGan): TianGan {
        if (qiyi.tianGan == TianGan.WU) {
            return TianGan(TianGan.JI)
        } else if (qiyi.tianGan == TianGan.JI) {
            return TianGan(TianGan.GENG)
        } else if (qiyi.tianGan == TianGan.GENG) {
            return TianGan(TianGan.XIN)
        } else if (qiyi.tianGan == TianGan.XIN) {
            return TianGan(TianGan.REN)
        } else if (qiyi.tianGan == TianGan.REN) {
            return TianGan(TianGan.GUI)
        } else if (qiyi.tianGan == TianGan.GUI) {
            return TianGan(TianGan.DING)
        } else if (qiyi.tianGan == TianGan.DING) {
            return TianGan(TianGan.BING)
        } else if (qiyi.tianGan == TianGan.BING) {
            return TianGan(TianGan.YI)
        } else if (qiyi.tianGan == TianGan.YI) {
            return TianGan(TianGan.WU)
        } else {
            return TianGan(TianGan.WU)
        }
    }

    fun findXunShou(): Int {
        var xunShou = 1
        for (i in 0..2) {
            for (j in 0..2) {
                if (this.cells[i][j].diPanQiYi.qiyi!!.tianGan == this.mXunShou.tianGan) {
                    xunShou = this.cells[i][j].id
                    println("Found!旬首落在${xunShou}宫")
                }
            }
        }
        return xunShou
    }

    fun findShiGan(): Int {
        var shiGan = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (this.cells[i][j].diPanQiYi.qiyi!!.tianGan == this.mShiGan.tianGan) {
                    shiGan = this.cells[i][j].id
                    println("Found!时干落在${shiGan}宫")
                }
            }
        }
        //如果没找到，说明时干为甲。
        if (shiGan == 0) {
            shiGan = findXunShou()
        }
        return shiGan
    }

    fun setTianPan(): Unit {
        val shiGan = findShiGan()
        var gong = shiGan

        // 如果时干落中五宫，则取寄宫坤二宫
        if (shiGan == 5) {
            gong = 2
        }

        val xunshou = findXunShou()
        var xun_gong = xunshou

        if (xunshou == 5) {
            xun_gong = 2
        }

        val fuYin = shiGan == xunshou

        var pos1 = findCellById(gong)
        var pos2 = findCellById(xun_gong)

        val jx = getZhiFu()
        var jx_id = jx.id

        for (i in 0..7) {
            cells[pos1.first][pos1.second].tianPanQiYi = cells[pos2.first][pos2.second].diPanQiYi
            cells[pos1.first][pos1.second].jiuXing = JiuXing(jx_id + i)
            cells[pos1.first][pos1.second].baShen = BaShen(i)
            pos1 = getClockwise(pos1.first, pos1.second)
            pos2 = getClockwise(pos2.first, pos2.second)
        }

        cells[1][1].tianPanQiYi = cells[1][1].diPanQiYi

        var rpos = findCellById(gong)

        if (!mYinYang) {
            for (i in 0..7) {
                cells[rpos.first][rpos.second].baShen = BaShen(i)
                rpos = getAnitClockwise(rpos.first, rpos.second)
            }
        }

        val steps = this.mShiGan.tianGan
        println("到占时需要走${steps}步")

        //val zhigan_gong = shiGan
        var menGong = xunshou
        println("旬首落宫：$menGong")
        if (this.mYinYang) {
            menGong = (xunshou + steps) % 9
        } else {
            menGong = (xunshou - steps + 9) % 9
        }

        // 如果旬首落中五宫，则取坤二宫，因为门落不了中五宫
        if (menGong == 5) {
            menGong = 2
        }

        println("值使门落在${menGong}宫")

        val menId = getZhiShiMen().men
        var posMen = findCellById(menGong)
        var posYinGan = findCellById(gong)

        for (i in 0..7) {
            cells[posMen.first][posMen.second].baMen = BaMen(menId + i)
            if (!fuYin) {
                cells[posMen.first][posMen.second].yinGan = cells[posYinGan.first][posYinGan.second].diPanQiYi
                posYinGan = getClockwise(posYinGan.first, posYinGan.second)
            } else {
                cells[posMen.first][posMen.second].yinGan = QiYi()
                posYinGan = getClockwise(posYinGan.first, posYinGan.second)
            }
            posMen = getClockwise(posMen.first, posMen.second)
        }

        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j].maXing = isMaXing(cells[i][j].id)
                cells[i][j].kongWang = isKongWang(cells[i][j].id)
            }
        }

        //伏吟情况下的隐干
        if (fuYin) {
            if (xunshou == 5) {
                var pos5 = Pair(1, 1)
                var value = this.cells[0][2].diPanQiYi.qiyi
                for (i in 1..9) {
                    this.cells[pos5.first][pos5.second].yinGan.qiyi = value
                    pos5 = if (mYinYang) {
                        getNext(pos5.first, pos5.second)
                    } else {
                        getPrev(pos5.first, pos5.second)
                    }
                    value = getNextQiYi(value)
                }
            } else {
                var pos5 = Pair(1, 1)
                var value = cells[findCellById(xunshou).first][findCellById(xunshou).second].diPanQiYi.qiyi
                for (i in 1..9) {
                    this.cells[pos5.first][pos5.second].yinGan.qiyi = value
                    pos5 = if (mYinYang) {
                        getNext(pos5.first, pos5.second)
                    } else {
                        getPrev(pos5.first, pos5.second)
                    }
                    value = getNextQiYi(value)
                }
            }
            cells[0][2].yinGan.jigong = cells[1][1].yinGan.qiyi
        }
    }

    fun getZhiFu(): JiuXing {
        val gong = this.findXunShou()
        return if (gong == 5) {
            this.cells[0][2].diPanJiuXing!!
        } else {
            val pos = findCellById(gong)
            this.cells[pos.first][pos.second].diPanJiuXing!!
        }
    }

    fun getZhiShiMen(): BaMen {
        val gong = this.findXunShou()
        return if (gong == 5) {
            this.cells[0][2].diPanBaMen!!
        } else {
            val pos = findCellById(gong)
            this.cells[pos.first][pos.second].diPanBaMen!!
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

    private fun isMaXing(gong: Int): Boolean {
        val shiZhi = this.mShiZhi.diZhi
        when (shiZhi % 4) {
            0 -> return gong == 8
            1 -> return gong == 6
            2 -> return gong == 2
            3 -> return gong == 4
        }
        return false
    }

    private fun isKongWang(gong: Int): Boolean {
        when (this.mXunShou.tianGan) {
            TianGan.WU -> return gong == 6 // 乾六宫
            TianGan.JI -> return gong == 2 || gong == 7 // 坤二宫、兑七宫
            TianGan.GENG -> return gong == 9 || gong == 2 // 离九宫、坤二宫
            TianGan.XIN -> return gong == 4 //巽四宫
            TianGan.REN -> return gong == 8 || gong == 3 //艮八宫、震三宫
            TianGan.GUI -> return gong == 1 || gong == 8 //坎一宫、艮八宫
        }
        return false
    }


    fun display() {


        println("----------------------")
        println("|${cells[0][0].getYinGan()}${cells[0][0].getKongWang()}|${cells[0][1].getYinGan()}${cells[0][1].getKongWang()}|${cells[0][2].getYinGan()}${cells[0][2].getKongWang()}|")
        println("|${cells[0][0].baShen.toString()} ${cells[0][0].getMaXing()}|${cells[0][1].baShen.toString()} ${cells[0][1].getMaXing()}|${cells[0][2].baShen.toString()} ${cells[0][2].getMaXing()}|")
        println("|${cells[0][0].getTianPanQiYi()}${cells[0][0].jiuXing.toString()}|${cells[0][1].getTianPanQiYi()}${cells[0][1].jiuXing.toString()}|${cells[0][2].getTianPanQiYi()}${cells[0][2].jiuXing.toString()}|")
        println("|${cells[0][0].getQiYi()}${cells[0][0].baMen.toString()}|${cells[0][1].getQiYi()}${cells[0][1].baMen.toString()}|${cells[0][2].getQiYi()}${cells[0][2].baMen.toString()}|")
        println("---------------------")
        println("|${cells[1][0].getYinGan()}${cells[1][0].getKongWang()}|   |${cells[1][2].getYinGan()}${cells[1][2].getKongWang()}|")
        println("|${cells[1][0].baShen.toString()} ${cells[1][0].getMaXing()}|   |${cells[1][2].baShen.toString()} ${cells[1][2].getMaXing()}|")
        println("|${cells[1][0].getTianPanQiYi()}${cells[1][0].jiuXing.toString()}|   |${cells[1][2].getTianPanQiYi()}${cells[1][2].jiuXing.toString()}|")
        println("|${cells[1][0].getQiYi()}${cells[1][0].baMen.toString()}|${cells[1][1].getQiYi()} |${cells[1][2].getQiYi()}${cells[1][2].baMen.toString()}|")
        println("---------------------")
        println("|${cells[2][0].getYinGan()}${cells[2][0].getKongWang()}|${cells[2][1].getYinGan()}${cells[2][1].getKongWang()}|${cells[2][2].getYinGan()}${cells[2][2].getKongWang()}|")
        println("|${cells[2][0].baShen.toString()} ${cells[2][0].getMaXing()}|${cells[2][1].baShen.toString()} ${cells[2][1].getMaXing()}|${cells[2][2].baShen.toString()} ${cells[2][2].getMaXing()}|")
        println("|${cells[2][0].getTianPanQiYi()}${cells[2][0].jiuXing.toString()}|${cells[2][1].getTianPanQiYi()}${cells[2][1].jiuXing.toString()}|${cells[2][2].getTianPanQiYi()}${cells[2][2].jiuXing.toString()}|")
        println("|${cells[2][0].getQiYi()}${cells[2][0].baMen.toString()}|${cells[2][1].getQiYi()}${cells[2][1].baMen.toString()}|${cells[2][2].getQiYi()}${cells[2][2].baMen.toString()}|")
        println("-----------------")

        for (i in 0..2) {
            for (j in 0..2) {
                if (i == 1 && j == 1) continue
                cells[i][j].checkMenPo()
                cells[i][j].checkJiXing()
            }
            //println()
        }
    }
}
