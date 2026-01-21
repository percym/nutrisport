package dev.percym.home.domain

import dev.percym.shared.navigation.Screen
import nutrisport.shared.Resources
import org.jetbrains.compose.resources.DrawableResource

enum class BottomBarDestination(
    val icon: DrawableResource,
    val title:String,
    val Screen: Screen
){
    ProductsOverview(
        icon= Resources.Icon.Home,
        title="Nutri Sport",
        Screen=Screen.ProductsOverview

    ),
    Cart(
        icon=Resources.Icon.ShoppingCart,
        title="Cart",
        Screen=Screen.Cart

    ),
    Categories(
        icon=Resources.Icon.Categories,
        title="Categories",
        Screen=Screen.Categories



    )
}