package dev.percym.profile

import androidx.compose.runtime.Composable
import dev.percym.shared.component.ProfileForm

@Composable
fun ProfileScreen(){
    ProfileForm(
        firstName = "",
        onFirstNameChange = {},
        lastName = "",
        onLastNameChange = {},
        email = "",
        onEmailChange = {},
        city = "",
        onCityChange = {},
        postalCode = "",
        onPostalCodeChange = {},
        address = "",
        onAddressChange = {},
        phoneNumber = "",
        onPhoneNumberChange = {},
    )
}