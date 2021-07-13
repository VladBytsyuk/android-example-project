package io.vbytsyuk.example.core

interface Logger {
    val tag: String
    fun v(tag: String = this.tag, message: String)
    fun i(tag: String = this.tag, message: String)
    fun d(tag: String = this.tag, message: String)
    fun w(tag: String = this.tag, message: String)
    fun e(tag: String = this.tag, message: String)
    fun f(tag: String = this.tag, message: String)
}
