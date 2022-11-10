package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin

class Yao {
    var isYang = false
    var isChange = false
    lateinit var naZhi : DiZhi // 纳支
    lateinit var lq : LiuQin // 六亲
    var isShi: Boolean = false
    var isYing = false

    constructor(number : Int){
        this.isYang = number % 2 == 1
        this.isChange = number == 6 || number == 9
    }
}