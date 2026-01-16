package dev.percym.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import dev.percym.auth.component.GoogleButton
import dev.percym.shared.Alpha
import dev.percym.shared.BebasNeueFont
import dev.percym.shared.FontSize
import dev.percym.shared.TextPrimary
import dev.percym.shared.TextSecondary
import kotlinx.coroutines.launch

@Composable
fun AuthScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var loading by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "NutriSport",
                        textAlign = TextAlign.Center,
                        fontFamily = BebasNeueFont(),
                        fontSize = FontSize.EXTRA_LARGE,
                        color = TextSecondary
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(Alpha.HALF),
                        text = "Sign in to continue ..",
                        textAlign = TextAlign.Center,
                        fontFamily = BebasNeueFont(),
                        fontSize = FontSize.EXTRA_REGULAR,
                        color = TextPrimary
                    )
                }
                GoogleButton(
                    loading = loading,
                    onClick = {
                        loading = true
                        scope.launch {
                            // Show success/error message
                            snackbarHostState.showSnackbar("Signing in...")
                        }
                    }
                )
            }
        }
    }
}