package dev.percym.data

import dev.gitlive.firebase.auth.FirebaseUser

interface CustomerRepository {
    fun getCurrentUserID():String?
    suspend fun createCustomer(
        user: FirebaseUser?,
        onSuccess:()->Unit,
        onError:(String)->Unit
    )
}