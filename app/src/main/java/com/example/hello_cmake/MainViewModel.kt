package com.example.hello_cmake

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    external fun testFromCore(num1: Int = 10, num2: Int = 10): Double

    companion object {
        init {
            System.loadLibrary("hello_cmake")
            System.loadLibrary("core-lib")
        }
    }
}