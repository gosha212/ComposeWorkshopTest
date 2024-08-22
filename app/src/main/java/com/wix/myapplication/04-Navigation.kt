package com.wix.myapplication

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(startDestination = "main", navController = navController) {
        composable("main") {
            MainScreen {
                navController.navigate("second")
            }
        }
        composable("second") {
            SecondScreen {
                navController.navigate("third")
            }
        }
        composable("third") {
            ThirdScreen()
        }
    }
}

@Composable
fun MainScreen(navigate: () -> Unit) {
    Button(onClick = navigate) {
        Text(text = "Navigate to Second Screen")
    }
}

@Composable
fun SecondScreen(navigate: () -> Unit) {
    Button(onClick = navigate) {
        Text(text = "Navigate to Third Screen")
    }
}

@Composable
fun ThirdScreen() {
    Text(text = "Third Screen")
}