package com.github.lusing.qimen

class DunJiaPan {
    private val cells: Array<Array<Cell>> = arrayOf(
        arrayOf(Cell(), Cell(), Cell()),
        arrayOf(Cell(), Cell(), Cell()),
        arrayOf(Cell(), Cell(), Cell())
    )

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

        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j].display()
            }
        }
    }

    fun getNext(x: Int, y: Int): Pair<Int, Int> {
        var nextX = x
        var nextY = y
        if (x == 0 && y == 0) {
            nextX = 1
            nextY = 0
        } else if (x == 1 && y == 0) {
            nextX = 2
            nextY = 0
        } else if (x == 2 && y == 0) {
            nextX = 2
            nextY = 1
        } else if (x == 2 && y == 1) {
            nextX = 2
            nextY = 2
        } else if (x == 2 && y == 2) {
            nextX = 1
            nextY = 2
        } else if (x == 1 && y == 2) {
            nextX = 0
            nextY = 2
        } else if (x == 0 && y == 2) {
            nextX = 0
            nextY = 1
        } else if (x == 0 && y == 1) {
            nextX = 0
            nextY = 0
        }
        return Pair(nextX, nextY)
    }

    fun getPrev(x: Int, y: Int): Pair<Int, Int> {
        var prevX = x
        var prevY = y
        if (x == 0 && y == 0) {
            prevX = 0
            prevY = 1
        } else if (x == 1 && y == 0) {
            prevX = 0
            prevY = 0
        } else if (x == 2 && y == 0) {
            prevX = 1
            prevY = 0
        } else if (x == 2 && y == 1) {
            prevX = 2
            prevY = 0
        } else if (x == 2 && y == 2) {
            prevX = 2
            prevY = 1
        } else if (x == 1 && y == 2) {
            prevX = 2
            prevY = 2
        } else if (x == 0 && y == 2) {
            prevX = 1
            prevY = 2
        } else if (x == 0 && y == 1) {
            prevX = 0
            prevY = 2
        }
        return Pair(prevX, prevY)
    }

    fun display() {
        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j].display()
            }
        }
    }
}
