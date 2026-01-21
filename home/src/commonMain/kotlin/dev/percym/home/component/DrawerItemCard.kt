package dev.percym.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import dev.percym.home.domain.DrawerItem
import dev.percym.shared.FontSize
import dev.percym.shared.IconPrimary
import dev.percym.shared.TextPrimary
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawerItemCard(
    drawerItem: DrawerItem,
    onClick: () -> Unit
){
Row(
    modifier = Modifier
        .clickable{onClick()}
        .padding(vertical = 12.dp, horizontal = 12.dp),
    verticalAlignment = Alignment.CenterVertically
){
    Icon(
        painter = painterResource(drawerItem.icon),
        contentDescription = "Drawer Item Icon",
        tint = IconPrimary

    )
    Spacer(
        modifier = Modifier.width(12.dp))
    Text(
        text = drawerItem.title,
        color = TextPrimary,
        fontSize = FontSize.REGULAR,
    )

}
}
