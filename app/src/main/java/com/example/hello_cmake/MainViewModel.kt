package com.example.hello_cmake

import androidx.lifecycle.ViewModel
import com.example.corelib.NativeLib

class MainViewModel(private val nativeLib: NativeLib) : ViewModel() {

    external fun testFromCore(num1: Int = 10, num2: Int = 10): Double

    fun getMessage(): String = nativeLib.stringFromJNI()

    fun sort(arr: IntArray) = nativeLib.sort(arr)

    companion object {
        init {
            System.loadLibrary("hello_cmake")
            System.loadLibrary("core-lib")
        }
    }
}