package dev.percym.shared.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class CartItem @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String= Uuid.random().toHexString(),
    val product: String,
    val flavour: String?=null,
    val quantity: Int,

    )