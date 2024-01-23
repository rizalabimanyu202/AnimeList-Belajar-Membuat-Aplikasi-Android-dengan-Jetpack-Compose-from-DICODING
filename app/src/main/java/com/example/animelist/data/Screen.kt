package com.example.animelist.data

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("home/{id}")
}