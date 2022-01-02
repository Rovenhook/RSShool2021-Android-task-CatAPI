package com.rovenhook.rsshool2021_android_task_catapi

import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.rovenhook.rsshool2021_android_task_catapi.databinding.ActivityMainBinding
import com.rovenhook.rsshool2021_android_task_catapi.screens.CatsListFragment




class MainActivity : AppCompatActivity() {

    private var windowInsetsController: WindowInsetsControllerCompat? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        windowInsetsController = windowInsetsControllerBuilder()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.mainContainer, CatsListFragment())
                .commit()
        }
    }

    fun hideUi() {
        // Hide both the status bar and the navigation bar
        windowInsetsController?.hide(WindowInsetsCompat.Type.systemBars())
    }

    fun showUi() {
        windowInsetsController?.show(WindowInsetsCompat.Type.systemBars())
    }

    private fun windowInsetsControllerBuilder(): WindowInsetsControllerCompat? {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView)
        // Configure the behavior of the hidden system bars
        windowInsetsController?.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        return windowInsetsController
    }
}
