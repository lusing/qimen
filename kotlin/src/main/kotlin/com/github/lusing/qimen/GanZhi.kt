package com.github.lusing.qimen

/**
 * 干支
 *
 * @author Louis
 */
class GanZhi {
    val mTg: TianGan
    val mDz: DiZhi

    constructor(tg: TianGan, dz: DiZhi) {
        mTg = tg
        mDz = dz
    }

    constructor(tg: Int, dz: Int) {
        mTg = TianGan(tg)
        mDz = DiZhi(dz)
    }

    fun getNext(): GanZhi {
        return GanZhi(mTg.getNext(), mDz.getNext())
    }

    fun getPrev(): GanZhi {
        return GanZhi(mTg.getPrev(), mDz.getPrev())
    }

    fun add(i: Int): GanZhi {
        var gz = this
        for (j in 1..i) {
            gz = gz.getNext()
        }
        return gz
    }

    fun getXunKong(): Set<Int> {
        val diff = (this.mDz.diZhi - this.mTg.tianGan + 12) % 12
        var xunKong = setOf<Int>()
        val dz1 = DiZhi((diff + 11) % 12).diZhi
        val dz2 = DiZhi((diff + 10) % 12).diZhi
        xunKong = xunKong.plusElement(dz1)
        xunKong = xunKong.plusElement(dz2)
        //println(xunKong)
        return xunKong
    }

    fun getXunKongNames(): String {
        val xk = getXunKong()
        var xkNames = ""
        for (dz in xk) {
            xkNames += DiZhi(dz).getName()
        }
        return xkNames
    }

    fun isXunKong(dz: DiZhi): Boolean {
        val xk = getXunKong()
        return xk.contains(dz.diZhi)
    }

    fun getName(): String {
        return mTg.getName() + mDz.getName()
    }
}