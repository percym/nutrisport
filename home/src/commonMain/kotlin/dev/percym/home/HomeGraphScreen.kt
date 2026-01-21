package dev.percym.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.percym.home.common.BottomBar

@Composable
fun HomeGraphScreen(){
    Scaffold {padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(top = padding.calculateTopPadding(), bottom = padding.calculateBottomPadding())
        ){
            Spacer(modifier =Modifier.weight(1f))
            BottomBar(
                selected = false,
                onSelect = {destination ->

                }

            )
        }

    }
}