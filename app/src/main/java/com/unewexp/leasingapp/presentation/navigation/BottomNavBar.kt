package com.unewexp.leasingapp.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.unewexp.leasingapp.ui.theme.BG_Brand
import com.unewexp.leasingapp.ui.theme.BG_Primary
import com.unewexp.leasingapp.ui.theme.Indicator_Medium
import com.unewexp.leasingapp.ui.theme.Text_Tertiary

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    NavigationBar(containerColor = BG_Primary) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route

        Routes.BottomNavItems.forEach { navItem ->

            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = {
                    Icon(imageVector = ImageVector.vectorResource(navItem.inactiveIcon), contentDescription = navItem.label)
                },
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = BG_Brand,
                    selectedTextColor = BG_Brand,
                    unselectedIconColor = Indicator_Medium,
                    unselectedTextColor = Text_Tertiary,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}