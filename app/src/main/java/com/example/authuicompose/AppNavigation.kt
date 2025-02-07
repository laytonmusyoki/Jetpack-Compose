package com.example.authuicompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("register") {
            Register(
                onNavigateToLogin = { navController.navigate("login") },
                onNavigateToHome = { navController.navigate("home") }
            )
        }
        composable("login") {
            LoginPage(
                onNavigateToRegister = { navController.navigate("register") },
                onNavigateToHome = { navController.navigate("home") }
            )
        }
        composable("home") {
            HomeScreen()
        }
    }
}