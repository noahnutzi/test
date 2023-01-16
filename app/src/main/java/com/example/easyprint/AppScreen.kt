package com.example.easyprint

import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easyprint.constants.GCodeFiles
import com.example.easyprint.ui.screens.*

enum class AppScreens() {
    Main,
    Settings,
    Information,
    PrintObjectBenchy,
    PrintObjectLegoDuplo,
    PrintObjectLego,
    PrintObjectYoda,
}

@Composable
fun EasyPrintApp(context: Context) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            EasyPrintTopBar(navController = navController)
        }
    ) {
        NavHost(navController = navController, startDestination = AppScreens.Main.name) {
            composable(route = AppScreens.Main.name) {
                MainScreen(navController = navController)
            }
            composable(route = AppScreens.Settings.name) {
                SettingsScreen()
            }
            composable(route = AppScreens.Information.name) {
                InformationScreen()
            }
            composable(route = AppScreens.PrintObjectBenchy.name) {
                PrintScreen(
                    titleResourceId = R.string.benchy,
                    imageResourceId = R.drawable.transparentbenchy,
                    descriptionResourceId = R.string.benchy_description,
                    fileName = GCodeFiles.Benchy,
                    context = context,
                )
            }
            composable(route = AppScreens.PrintObjectLegoDuplo.name) {
                PrintScreen(
                    titleResourceId = R.string.lego_duplo,
                    imageResourceId = R.drawable.transparentduplo,
                    descriptionResourceId = R.string.lego_duplo_description,
                    fileName = GCodeFiles.Lego_duplo,
                    context = context,
                )
            }
            composable(route = AppScreens.PrintObjectLego.name) {
                PrintScreen(
                    titleResourceId = R.string.lego,
                    imageResourceId = R.drawable.transparentlego,
                    descriptionResourceId = R.string.lego_description,
                    fileName = GCodeFiles.Lego,
                    context = context,
                )
            }
            composable(route = AppScreens.PrintObjectYoda.name) {
                PrintScreen(
                    titleResourceId = R.string.yoda,
                    imageResourceId = R.drawable.transparentyoda,
                    descriptionResourceId = R.string.yoda_description,
                    fileName = GCodeFiles.Yoda,
                    context = context,
                )
            }
        }
    }
}



