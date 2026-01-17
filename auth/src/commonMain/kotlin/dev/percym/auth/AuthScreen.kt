package dev.percym.auth

import androidx.compose.runtime.Composable

@Composable
expect fun AuthScreen(navigateToHome: () -> Unit)
