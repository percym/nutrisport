package dev.percym.nutrisport


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import dev.percym.navigation.SetUpNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

        SetUpNavGraph()
    }
}