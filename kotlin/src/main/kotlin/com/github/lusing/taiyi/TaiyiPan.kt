package com.github.lusing.taiyi

import com.github.lusing.qimen.DiZhi
import java.nio.ByteOrder

class TaiyiPan {
    val pan = Array(5) { Array(5) { Cell(0, "", "") } }

    init {
        pan[4][4] = Cell(1, "乾", "阴德", null, 0)
        pan[4][3] = Cell(8, "亥", "大义", DiZhi(DiZhi.HAI), 1)
        pan[4][2] = Cell(8, "子", "地主", DiZhi(DiZhi.ZI), 0)
        pan[4][1] = Cell(3, "丑", "阳德", DiZhi(DiZhi.CHOU), 1)
        pan[4][0] = Cell(3, "艮", "和德", null, 0)
        pan[3][0] = Cell(4, "寅", "吕申", DiZhi(DiZhi.YIN), 1)
        pan[2][0] = Cell(4, "卯", "高丛", DiZhi(DiZhi.MAO), 0)
        pan[1][0] = Cell(9, "辰", "太阳", DiZhi(DiZhi.CHEN), 1)
        pan[0][0] = Cell(9, "巽", "大炅", null, 0)
        pan[0][1] = Cell(2, "巳", "大神", DiZhi(DiZhi.SI), 1)
        pan[0][2] = Cell(2, "午", "大威", DiZhi(DiZhi.WU), 0)
        pan[0][3] = Cell(7, "未", "天道", DiZhi(DiZhi.WEI), 1)
        pan[0][4] = Cell(7, "坤", "大武", null, 0)
        pan[1][4] = Cell(6, "申", "武德", DiZhi(DiZhi.SHEN))
        pan[2][4] = Cell(6, "酉", "太簇", DiZhi(DiZhi.YOU))
        pan[3][4] = Cell(1, "戌", "阴主", DiZhi(DiZhi.XU), 1)
        var cell17 = pan[2][2]
        cell17.gongNum = 5
    }

    fun year(ty: Taiyi) {
        // 太乙落客
        val gong: Int = ty.getTaiyi()
        luoGong(gong, XingShen(XingShen.TAI_YI))
        // 太歲
        luoDiZhi(ty.getTaiSui(), XingShen(XingShen.TAI_SUI))
        // 合神
        luoDiZhi(ty.getHeShen(), XingShen(XingShen.HE_SHEN))
        // 計神
        luoDiZhi(ty.getJiShen(true), XingShen(XingShen.JI_SHEN))
        // 文昌
        val wc_cell = luoWenChang(ty.getWenChang(true), XingShen(XingShen.WEN_CHANG))

        val wc_gong = wc_cell?.gongNum
        val wc_order = wc_cell?.gongOrder
        val zhuSuan = wc_gong?.let { wc_order?.let { order -> calcDist(it, gong, order) } }
        println("主算數：${zhuSuan}")
        val zhuDaJiang = zhuSuan?.rem(10)
        println("主大將數：${zhuDaJiang}")
        zhuDaJiang?.let { luoGong(it, XingShen(XingShen.ZHU_DAJIANG)) }
    }

    fun mapGongToPos(gong: Int): Cell? {
        return when (gong) {
            1 -> pan[4][4]
            2 -> pan[0][2]
            3 -> pan[4][0]
            4 -> pan[2][0]
            5 -> pan[2][2]
            6 -> pan[2][4]
            7 -> pan[0][4]
            8 -> pan[4][2]
            9 -> pan[0][0]
            else -> null
        }
    }

    fun luoWenChang(pos: Int, wenchang: XingShen): Cell? {
        val cell: Cell? = when (pos) {
            0 -> pan[0][4]//大武時停留一步
            1 -> pan[1][4]
            2 -> pan[2][4]
            3 -> pan[3][4]
            4 -> pan[4][4]
            5 -> pan[4][4]//阴德時停留一步
            6 -> pan[4][3]
            7 -> pan[4][2]
            8 -> pan[4][1]
            9 -> pan[4][0]
            10 -> pan[3][0]
            11 -> pan[2][0]
            12 -> pan[1][0]
            13 -> pan[0][0]
            14 -> pan[0][1]
            15 -> pan[0][2]
            16 -> pan[0][3]
            17 -> pan[0][4]
            else -> null
        }
        cell?.shenList?.add(wenchang)
        return cell
    }

    // 根據宮位放星神
    fun luoGong(gong: Int, shen: XingShen) {
        val cell = mapGongToPos(gong)
        cell?.shenList?.add(shen)
    }

    // 根據地支來確定位置
    fun luoDiZhi(diZhi: DiZhi, shen: XingShen) {
        for (i in this.pan) {
            for (j in i) {
                if (j.dz == null) {
                    continue
                } else {
                    if (j.dz?.diZhi == diZhi.diZhi) {
                        j.shenList.add(shen)
                    }
                }
            }
        }
    }

    fun walk() {
        println("||||||")
        println("|-|-|-|-|-|")
        for (i in pan) {
            for (j in i) {
                if (j.gongNum == 0) {
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

    companion object {
        fun calcDist(start: Int, end: Int, order: Int = 0): Int {
            var dist: Int = 0
            if (start == end) {
                return start
            }
            var cur = start
            while (true) {
                val next = getNext(cur)
                dist = dist + cur
                if (next == end) {
                    break;
                } else {
                    cur = next
                }
            }
            return dist + order
        }

        fun getNext(cur: Int): Int {
            return when (cur) {
                1 -> 8
                8 -> 3
                3 -> 4
                4 -> 9
                9 -> 2
                2 -> 7
                7 -> 6
                6 -> 1
                else -> 0
            }
        }
    }
}