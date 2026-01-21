package dev.percym.home.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.percym.home.domain.BottomBarDestination
import dev.percym.shared.IconPrimary
import dev.percym.shared.IconSecondary
import dev.percym.shared.SurfaceLighter
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selected:Boolean,
    onSelect:(BottomBarDestination)-> Unit,
    ){
    Row(
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(SurfaceLighter).padding(vertical = 24.dp, horizontal = 36.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        BottomBarDestination.entries.forEach {destination ->
            val animatedTint by animateColorAsState(targetValue = if (selected) IconSecondary else IconPrimary)
            IconButton(onClick = {onSelect(destination)}){
                Icon(
                    painter = painterResource(destination.icon),
                    contentDescription = destination.title,
                    tint = animatedTint
                )

            }
        }
    }
}