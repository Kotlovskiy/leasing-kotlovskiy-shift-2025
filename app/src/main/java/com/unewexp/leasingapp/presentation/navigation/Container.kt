package com.unewexp.leasingapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.unewexp.leasingapp.presentation.screens.CarScreen
import com.unewexp.leasingapp.presentation.screens.CarsScreen
import com.unewexp.leasingapp.presentation.screens.OrdersScreen
import com.unewexp.leasingapp.presentation.screens.ProfileScreen

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = "cars",
        modifier = Modifier.padding(paddingValues = padding),
        builder = {

            composable("cars") {
                CarsScreen(
                    onCardClick = { carId ->
                        navController.navigate("car/${carId}")
                    }
                )
            }

            composable (
                "car/{carId}",
                arguments = listOf(navArgument("carId") { type = NavType.StringType })
            ) { backStackEntry ->
                val carId = backStackEntry.arguments?.getString("carId") ?: ""
                CarScreen(carId, onToBack = {navController.popBackStack()}, onToBook = {})
            }

            composable("orders") {
                OrdersScreen()
            }

            composable("profile") {
                ProfileScreen()
            }
        })
}
