package com.yvkalume.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yvkalume.fitnessapp.ui.screen.HomeScreen
import com.yvkalume.fitnessapp.ui.screen.WelcomeScreen
import com.yvkalume.fitnessapp.ui.theme.FitnessappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable(route = "welcome") {
                            WelcomeScreen(navController)
                        }
                        composable(route = "home") {
                            HomeScreen(navController)
                        }
                    }
                }
            }
        }
    }
}