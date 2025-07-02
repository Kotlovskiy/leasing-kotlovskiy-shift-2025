package com.unewexp.leasingapp.presentation.navigation

import com.unewexp.leasingapp.R

object Routes {
    val BottomNavItems = listOf(
        NavItem(
            label = "Cars",
            activeIcon = R.drawable.ic_car_active,
            inactiveIcon = R.drawable.ic_car_inactive,
            route = "cars"
        ),
        NavItem(
            label = "Orders",
            activeIcon = R.drawable.ic_time_active,
            inactiveIcon = R.drawable.ic_time_inactive,
            route = "orders"
        ),
        NavItem(
            label = "Profile",
            activeIcon = R.drawable.ic_profile_active,
            inactiveIcon = R.drawable.ic_profile_inactive,
            route = "profile"
        )
    )
}