package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi

class Yao {
    var isYang = false
    var isChange = false
    var naZhi : DiZhi? = null // 纳支
    var lq : LiuQin? = null // 六亲

    constructor(number : Int){
        this.isYang = number % 2 == 1
        this.isChange = number == 6 || number == 9
    }
}