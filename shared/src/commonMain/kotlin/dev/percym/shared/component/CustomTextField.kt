package dev.percym.shared.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import dev.percym.shared.Alpha
import dev.percym.shared.BorderError
import dev.percym.shared.BorderIdle
import dev.percym.shared.FontSize
import dev.percym.shared.SurfaceLighter
import dev.percym.shared.TextPrimary

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String?=null,
    enabled: Boolean = true,
    error: Boolean = false,
    expanded: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text
    ),
) {
    val borderColor by animateColorAsState(
        targetValue = if(error) BorderError else BorderIdle
    )
    TextField(
        modifier=modifier.fillMaxWidth()
            .border(
            width = 1.dp,
            color = borderColor,
            shape = RoundedCornerShape(6.dp)
        ),
        enabled=enabled,
        value=value,
        onValueChange = onValueChange,
        placeholder =
            if (placeHolder != null) {
                {
                    Text(
                        modifier = Modifier.alpha(Alpha.HALF),
                        text = placeHolder,
                       fontSize = FontSize.REGULAR,
                    )
                }
            }else null,
            singleLine = true,
            shape = RoundedCornerShape(6.dp),
            keyboardOptions = keyboardOptions,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = SurfaceLighter,
                unfocusedContainerColor = SurfaceLighter,
                disabledContainerColor = SurfaceLighter,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary,
                disabledTextColor = TextPrimary.copy(alpha = Alpha.DISABLED),
                cursorColor = TextPrimary,
            )
    )
}
