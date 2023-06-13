package com.example.higher

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Rational
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.higher.databinding.ActivityMainBinding
import com.example.higher.fragment.ExampleFactory
import com.example.higher.fragment.ExampleFragment1
import com.example.higher.fragment.ExampleFragment2


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit {
            add<ExampleFragment1>(R.id.container)
        }
        binding.btnMaterial.setOnClickListener {
            changeElementTransition()
        }

        binding.btnMaterialBack.setOnClickListener {

        }
    }

    private fun changeElementTransition() {
        val imageView = findViewById<ImageView>(R.id.img_view_1)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addSharedElement(imageView, imageView.transitionName)
            replace<ExampleFragment2>(R.id.container)
        }
    }
}





