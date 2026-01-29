package dev.percym.shared.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileForm(
    modifier: Modifier = Modifier,
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    city: String,
    onCityChange: (String) -> Unit,
    postalCode: String?,
    onPostalCodeChange: (String) -> Unit,
    address: String,
    onAddressChange: (String) -> Unit,
    phoneNumber: String?,
    onPhoneNumberChange: (String) -> Unit,
){
    Column(
        modifier = modifier.fillMaxWidth()
        .padding(
            horizontal=24.dp,
            vertical = 12.dp
        )
        .imePadding()
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ){
        CustomTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            placeHolder = "First Name",
            error = firstName.length !in 3..50,
        )
        CustomTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            placeHolder = "Last Name",
            error = firstName.length !in 3..50,
        )
        CustomTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            placeHolder = "First Name",
            error = firstName.length !in 3..50,
        )
        CustomTextField(
            value = email,
            onValueChange = onEmailChange,
            placeHolder = "Email",
            enabled = false,
        )
        CustomTextField(
        value = city,
        onValueChange = onCityChange,
        placeHolder = "City",
        enabled = false,
        error= city.length !in 3..50,
        )
        CustomTextField(
            value = "${postalCode ?: ""}",
            onValueChange = onPostalCodeChange,
            placeHolder = "Postal Code",
            enabled = false,
            error= postalCode.toString().length !in 3..8,
        )
        CustomTextField(
            value = address,
            onValueChange = onAddressChange,
            placeHolder = "Address",
            error= address.length !in 3..50,
        )
         CustomTextField(
            value = phoneNumber ?:"",
            onValueChange = onPhoneNumberChange,
            placeHolder = "Phone number",
            error= address.length !in 3..30,
        )


    }
}
