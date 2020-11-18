package com.example.itools


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.itools.service.retrofit.RetrofitFactory
import com.example.itools.service.retrofit.RetrofitService
import com.example.itools.ui.adapter.RequestPendingAdapter
import com.example.itools.ui.viewmodel.EmployeeRequestsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController =
            Navigation.findNavController(this, R.id.main_activity_nav_host)

        bottomNavigationView.setupWithNavController(navController)

        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        navController.addOnDestinationChangedListener { controller: NavController?, destination: NavDestination, arguments: Bundle? ->
            when (destination.id) {
                R.id.employee_stock_fragment,
                R.id.employee_requests_fragment ->
                    showBottomNavigationView(bottomNavigationView)
                else ->
                    hideBottomNavigationView(bottomNavigationView)
            }
        }

    }

    private fun showBottomNavigationView(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNavigationView(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.visibility = View.INVISIBLE
    }



    }

    private val myNavigationView = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when(item.itemId){
            R.id.employee_requests_fragment -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.employee_stock_fragment -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }
