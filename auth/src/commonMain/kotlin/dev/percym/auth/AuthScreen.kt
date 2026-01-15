package dev.percym.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.percym.auth.component.GoogleButton


@Composable
fun AuthScreen() {
    val messageBarState = rememberMessageBarState()


    Scaffold { padding ->
        ContentWithMessageBar(
            modifier = Modifier.padding(
                top = padding.calculateTopPadding(),
                bottom = padding.calculateBottomPadding()
            ),
            messageBarState = messageBarState,
            errorMaxLines = 2
        ){
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    GoogleButton { }
                }
            }
        }

    }
}