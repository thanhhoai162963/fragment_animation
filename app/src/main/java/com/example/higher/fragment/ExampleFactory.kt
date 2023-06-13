package com.example.higher.fragment

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class ExampleFactory : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            ExampleFragment1::class.java -> ExampleFragment1()
            ExampleFragment2::class.java -> ExampleFragment2()
            else -> {
                super.instantiate(classLoader, className)
            }
        }
    }
}