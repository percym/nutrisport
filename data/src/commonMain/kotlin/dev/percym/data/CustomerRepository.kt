package dev.percym.data

import dev.gitlive.firebase.auth.FirebaseUser
import dev.percym.shared.util.RequestState

interface CustomerRepository {
    fun getCurrentUserID():String?
    suspend fun createCustomer(
        user: FirebaseUser?,
        onSuccess:()->Unit,
        onError:(String)->Unit
    )
    suspend fun signOut(): RequestState<Unit>


}