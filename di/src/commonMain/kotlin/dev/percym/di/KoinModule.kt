package dev.percym.di

import androidx.lifecycle.viewmodel.compose.viewModel
import dev.percym.CustomerRepositoryImpl
import dev.percym.auth.AuthViewModel
import dev.percym.data.CustomerRepository
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    single<CustomerRepository> { CustomerRepositoryImpl() }
    viewModelOf(::AuthViewModel)
}
fun initializeKoin(
    config:(KoinApplication.()->Unit)?=null,
){
    startKoin {
        config?.invoke(this)
    }
}