package cn.edu.sziit.android.debugdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cn.edu.sziit.android.debugdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogDemo.setOnClickListener {
            printLogs()
        }

        binding.btnDebugDemo.setOnClickListener {
            DebugLab.runDemo()
        }
    }

    private fun printLogs() {
        // TODO：在步骤 2 中，在这里填写日志打印代码
    }
}