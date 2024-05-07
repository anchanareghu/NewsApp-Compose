package com.example.newsapplicationcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newsapplicationcompose.ui.theme.NewsTheme
import ui.NewsHomeScreen

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        val apiRequestManager = ApiRequestManager(applicationContext)
        viewModel = ViewModelProvider(this, NewsViewModelFactory(apiRequestManager))[NewsViewModel::class.java]

        setContent {
            NewsTheme {
                NewsHomeScreen(viewModel)
            }
        }
    }
}




