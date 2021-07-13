package io.vbytsyuk.example.log

import android.util.Log
import io.vbytsyuk.example.core.Logger

class AndroidLogger(override val tag: String) : Logger {

    override fun v(tag: String, message: String) {
        Log.v(tag, message)
    }

    override fun i(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun w(tag: String, message: String) {
        Log.w(tag, message)
    }

    override fun e(tag: String, message: String) {
        Log.e(tag, message)
    }

    override fun e(tag: String, throwable: Throwable) {
        Log.e(tag, null, throwable)
    }

    override fun f(tag: String, message: String) {
        Log.wtf(tag, message)
    }
}
