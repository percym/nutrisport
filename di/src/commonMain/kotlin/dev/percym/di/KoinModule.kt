package dev.percym.di

import dev.percym.CustomerRepositoryImpl
import dev.percym.auth.AuthViewModel
import dev.percym.data.CustomerRepository
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::CustomerRepositoryImpl) bind CustomerRepository::class
    viewModelOf(::AuthViewModel)
}
fun initializeKoin(
    config:(KoinApplication.()->Unit)?=null,
){
    startKoin {
        config?.invoke(this)
        modules(sharedModule)
    }
}