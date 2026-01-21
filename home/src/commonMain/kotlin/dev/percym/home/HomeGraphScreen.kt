package dev.percym.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.percym.home.common.BottomBar
import dev.percym.home.domain.BottomBarDestination
import dev.percym.shared.Surface
import dev.percym.shared.navigation.Screen

@Composable
fun HomeGraphScreen(){
    val navController = rememberNavController()
    val currentRoute= navController.currentBackStackEntryAsState()
    val selectedDestination by remember {
        derivedStateOf {
            val route = currentRoute.value?.destination?.route.toString()
            when{
                route.contains(Screen.ProductsOverview.toString()) -> BottomBarDestination.ProductsOverview
                route.contains(Screen.Cart.toString()) -> BottomBarDestination.Cart
                route.contains(Screen.Categories.toString()) -> BottomBarDestination.Categories
                else -> BottomBarDestination.ProductsOverview
            }
        }
    }


    Scaffold(
        containerColor= Surface
    ) {padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(top = padding.calculateTopPadding(), bottom = padding.calculateBottomPadding())
        ){
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = Screen.ProductsOverview
            ) {
                composable<Screen.ProductsOverview>{}
                composable<Screen.Cart>{}
                composable<Screen.Categories>{}

            }
            Spacer(modifier =Modifier.height(12.dp))
            Box(
                modifier = Modifier.padding(all=12.dp)
            ){
                BottomBar(
                    selected = selectedDestination,
                    onSelect = {destination ->
                        navController.navigate(destination.Screen){
//                            launchSingleTop=true
//                            popUpTo<Screen.ProductsOverview>{
//                                saveState=true
//                                inclusive=false
//                            }
//                            restoreState=true
                        }


                    }

                )
            }
        }

    }
}