package com.github.lusing.taiyi

import com.github.lusing.qimen.DiZhi
import java.nio.ByteOrder

class TaiyiPan {
    val pan = Array(5) { Array(5) { Cell(0, "", "") } }

    init {
        pan[4][4] = Cell(1, "乾", "阴德", null, 0, 13)
        pan[4][3] = Cell(8, "亥", "大义", DiZhi(DiZhi.HAI), 1, 14)
        pan[4][2] = Cell(8, "子", "地主", DiZhi(DiZhi.ZI), 0, 15)
        pan[4][1] = Cell(3, "丑", "阳德", DiZhi(DiZhi.CHOU), 1, 16)
        pan[4][0] = Cell(3, "艮", "和德", null, 0, 1)
        pan[3][0] = Cell(4, "寅", "吕申", DiZhi(DiZhi.YIN), 1, 2)
        pan[2][0] = Cell(4, "卯", "高丛", DiZhi(DiZhi.MAO), 0, 3)
        pan[1][0] = Cell(9, "辰", "太阳", DiZhi(DiZhi.CHEN), 1, 4)
        pan[0][0] = Cell(9, "巽", "大炅", null, 0, 5)
        pan[0][1] = Cell(2, "巳", "大神", DiZhi(DiZhi.SI), 1, 6)
        pan[0][2] = Cell(2, "午", "大威", DiZhi(DiZhi.WU), 0, 7)
        pan[0][3] = Cell(7, "未", "天道", DiZhi(DiZhi.WEI), 1, 8)
        pan[0][4] = Cell(7, "坤", "大武", null, 0, 9)
        pan[1][4] = Cell(6, "申", "武德", DiZhi(DiZhi.SHEN), 1, 10)
        pan[2][4] = Cell(6, "酉", "太簇", DiZhi(DiZhi.YOU), 0, 11)
        pan[3][4] = Cell(1, "戌", "阴主", DiZhi(DiZhi.XU), 1, 12)
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
        val jishen = luoDiZhi(ty.getJiShen(true), XingShen(XingShen.JI_SHEN))
        println("計神=${jishen}")

        // 文昌
        val wc_cell = luoWenChang(ty.getWenChang(true), XingShen(XingShen.WEN_CHANG))

        val wc_gong = wc_cell?.gongNum
        val wc_order = wc_cell?.gongOrder
        val zhuSuan = wc_gong?.let { wc_order?.let { order -> calcDist(it, gong, order) } }
        println("主算數：${zhuSuan}")
        var zhuDaJiang = zhuSuan?.rem(10)
        if (zhuDaJiang == 0) {
            zhuDaJiang = zhuSuan?.rem(9)
        }
        println("主大將數：${zhuDaJiang}")
        zhuDaJiang?.let { luoGong(it, XingShen(XingShen.ZHU_DAJIANG)) }
        val wc_start = wc_cell?.id

        val zhuCanJiang = zhuDaJiang?.let { (it * 3) % 10 }
        println("主參將數：${zhuCanJiang}")
        zhuCanJiang?.let { luoGong(it, XingShen(XingShen.ZHU_CANJIANG)) }

        //計算始擊
        // 計算計神到艮和德的距離
        val stepJi = calcJiShen(jishen)
        println("計神需要走${stepJi}步")
        println("始擊起始位置${wc_start}")
        val wc_stop = wc_start?.plus(stepJi)
        println("始擊結束位置${wc_stop}")
        val shiji_cell = wc_stop?.let { luoId(it, XingShen(XingShen.SHI_JI)) }
        val sj_gong = shiji_cell?.gongNum
        val sj_gong_order = shiji_cell?.gongOrder

        val keSuan = sj_gong?.let { sj_gong_order?.let { order -> calcDist(it, gong, order) } }
        println("客算數：${keSuan}")
        var keDaJiang = keSuan?.rem(10)
        if (keDaJiang == 0) {
            keDaJiang = keSuan?.rem(9)
        }
        println("客大將數：${keDaJiang}")
        keDaJiang?.let { luoGong(it, XingShen(XingShen.KE_DAJIANG)) }
        val keCanJiang = keDaJiang?.let { (it * 3) % 10 }
        println("客參將數：${keCanJiang}")
        keCanJiang?.let { luoGong(it, XingShen(XingShen.KE_CANJIANG)) }
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

    fun luoId(id: Int, shen: XingShen): Cell? {
        val cell = findCellById(id)
        cell?.shenList?.add(shen)
        return cell
    }

    // 根據地支來確定位置
    fun luoDiZhi(diZhi: DiZhi, shen: XingShen): Int {
        var id = 0
        for (i in this.pan) {
            for (j in i) {
                if (j.dz == null) {
                    continue
                } else {
                    if (j.dz?.diZhi == diZhi.diZhi) {
                        j.shenList.add(shen)
                        id = j.id
                    }
                }
            }
        }
        return id
    }

    fun findCellById(id: Int): Cell? {
        for (i in this.pan) {
            for (j in i) {
                if (j.id == id) {
                    return j
                }
            }
        }
        return null
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
                //print(j.id)
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

        fun calcJiShen(start: Int): Int {
            return (17 - start) % 16
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