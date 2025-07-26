package com.example.myapplication.landingpage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.weather.WeatherActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LandingPageScreen(
                        miniApps = MINI_APPS_LIST,
                        onMiniAppClick = { handleMiniAppNavigation(it) },
                        padding = innerPadding,
                    )
                }
            }
        }
    }

    private fun handleMiniAppNavigation(landingPageItemType: LandingPageItemType) {
        when (landingPageItemType) {
            LandingPageItemType.MVI_PROTOTYPE -> startActivity(
                Intent(
                    this,
                    WeatherActivity::class.java
                )
            )

            else -> {} // no op
        }
    }

    private companion object {
        val MINI_APPS_LIST = listOf(
            LandingPageItemType.MVI_PROTOTYPE,
            LandingPageItemType.GRAPH_QL,
        )
    }
}