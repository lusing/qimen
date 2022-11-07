package com.github.lusing.qimen

/**
 *
 * @author Louis
 */
class YinYang(private val isYang: Boolean) {
    override fun toString(): String {
        val sb = StringBuilder()
        if (isYang) {
            sb.append("阳")
        } else {
            sb.append("阴")
        }
        return sb.toString()
    }
}
