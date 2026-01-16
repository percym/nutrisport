package dev.percym.nutrisport


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import dev.percym.navigation.SetUpNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        SetUpNavGraph()
    }
}