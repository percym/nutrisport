package dev.percym.shared.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class Customer @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String= Uuid.random().toHexString(),
    val firstName: String,
    val lastName: String,
    val email: String,
    val city: String? = null,
    val postCode: String?=null,
    val address: String?=null,
    val phoneNumber: PhoneNumber?=null,
    val cart: List<CartItem> = emptyList()
)

data class PhoneNumber(
    val diallingCode: Int,
    val number: String,

)