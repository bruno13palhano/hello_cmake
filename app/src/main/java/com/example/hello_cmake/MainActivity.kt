package com.example.hello_cmake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.corelib.NativeLib
import com.example.hello_cmake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainViewModel(NativeLib())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = viewModel.testFromCore(num1 = 12, num2 = 13).toString()

        binding.sampleText.setOnClickListener {
            println("View was clicked!")
        }

        val array = intArrayOf(3,2,1,14,2,8,90,5,1,1)
        println("valor do method: ${viewModel.getMessage()}")
        viewModel.sort(array).iterator().forEach { println("valor de i: $it") }
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