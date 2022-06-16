package com.example.practical_planets

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import com.example.practical_planets.compose.SpaceCompose
import com.example.practical_planets.ui.theme.Practical_PlanetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practical_PlanetsTheme {
                // A surface container using the 'background' color from the theme
                Scaffold {

                    val configuration = LocalConfiguration.current
                    when (configuration.orientation) {
                        Configuration.ORIENTATION_LANDSCAPE -> {
                            SpaceCompose(
                                modifier = Modifier.fillMaxSize(),
                            )
                        }
                        else -> {
                            Text(
                                text = "Change your mobile orientation to landscape..",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

