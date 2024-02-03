package com.example.corelib

class NativeLib {

    /**
     * A native method that is implemented by the 'corelib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun sort(arr: IntArray): IntArray

    companion object {
        // Used to load the 'corelib' library on application startup.
        init {
            System.loadLibrary("corelib")
        }
    }
}