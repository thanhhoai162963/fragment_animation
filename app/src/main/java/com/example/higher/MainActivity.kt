package com.example.higher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.higher.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    /*private fun setSystemBar() {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        val windowController = WindowInsetsControllerCompat(window,window.decorView)
        windowController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowController.hide(WindowInsetsCompat.Type.systemBars())
        ViewCompat.setOnApplyWindowInsetsListener(binding.edt1) { _, insets ->
            val imeVisible = insets.isVisible(WindowInsetsCompat.Type.ime())
            val imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            Log.d("imeVisible",imeVisible.toString())
            Log.d("imeHeight",imeHeight.toString())
            windowController.hide(WindowInsetsCompat.Type.ime())

            insets
        }

    }*/


}

