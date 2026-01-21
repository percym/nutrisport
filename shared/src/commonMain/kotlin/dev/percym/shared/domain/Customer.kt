package dev.percym.shared.domain

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
@Serializable
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
@Serializable
data class PhoneNumber(
    val diallingCode: Int,
    val number: String,

)