package dev.percym.nutrisport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.Firebase
import com.google.firebase.initialize
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import dev.percym.di.initializeKoin
import kotlinx.coroutines.delay
import org.koin.android.ext.koin.androidContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeKoin (
            config = {
                androidContext(this@MainActivity)
            }
        )
        Firebase.initialize(context = this)
        installSplashScreen()
        enableEdgeToEdge()

        setContent {
            var isAuthReady by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                GoogleAuthProvider.create(
                    credentials = GoogleAuthCredentials(
                        serverId = "241541751290-8u1ile44vkovf87pjrljb1s34b3u67qo.apps.googleusercontent.com"
                    )
                )
                delay(100) // Small delay to ensure initialization completes
                isAuthReady = true
            }

            if (isAuthReady) {
                App()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}