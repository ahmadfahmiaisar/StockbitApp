package com.example.stockbitapp.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.base.abstraction.BaseActivityBinding
import com.example.base.extension.gone
import com.example.base.extension.visible
import com.example.stockbitapp.R
import com.example.stockbitapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivityBinding<ActivityMainBinding>(), NavController.OnDestinationChangedListener {
    override val getViewBinding: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    companion object {
        private val BOTTOM_BAR_FRAGMENT_IDS = intArrayOf(
            R.id.navigation_total_top_tier
        )

        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.navigationView.setupWithNavController(navController)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        if (destination.id in BOTTOM_BAR_FRAGMENT_IDS) {
            binding.navigationView.visible()
        } else {
            binding.navigationView.gone()
        }
    }
}