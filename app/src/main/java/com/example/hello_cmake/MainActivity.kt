package com.example.hello_cmake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hello_cmake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainViewModel()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = viewModel.testFromCore(num1 = 12, num2 = 13).toString()
    }

    /**
     * A native method that is implemented by the 'hello_cmake' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun intFromJNI(): Int

    companion object {
        // Used to load the 'hello_cmake' library on application startup.
        init {
            System.loadLibrary("hello_cmake")
            System.loadLibrary("core-lib")
        }
    }
}