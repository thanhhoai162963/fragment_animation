package com.example.higher

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.example.higher.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        createPaletteSync(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
    }

    fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

    private fun createPalette2() {
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_foreground)

        Palette.from(
            bitmap
        ).generate {
                if (it != null) {
                    it.lightVibrantSwatch?.rgb?.let { it1 -> binding.edt1.setBackgroundColor(it1) }
                }

            }
    }

    private fun setColor() {
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

