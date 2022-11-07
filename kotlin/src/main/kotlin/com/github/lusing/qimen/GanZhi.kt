package com.github.lusing.qimen

/**
 * 干支
 *
 * @author Louis
 */
class GanZhi {
    var mTg: TianGan
    var mDz: DiZhi

    constructor(tg: TianGan, dz: DiZhi) {
        mTg = tg
        mDz = dz
    }

    constructor(tg: Int, dz: Int) {
        mTg = TianGan(tg)
        mDz = DiZhi(dz)
    }
}