package dev.percym.nutrisport


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import dev.percym.data.CustomerRepository
import dev.percym.navigation.SetUpNavGraph
import dev.percym.shared.navigation.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    MaterialTheme {
        val customerRepository= koinInject <CustomerRepository>()
        val isUserAuthenticated = remember { customerRepository.getCurrentUserID() != null}
        val startDestination = remember {
            if (isUserAuthenticated)
                Screen.HomeGraph
            else
                Screen.Auth
        }

        SetUpNavGraph(
            startDestination=startDestination
        )
    }
}