package dev.project.splash.di

import dev.project.splash.mvi.SplashStore
import dev.project.splash.mvi.SplashStoreFactory
import org.koin.dsl.module

const val SPLASH_STORE_NAME = "SplashStore"

val splashModule =
    module {
        factory<SplashStore> {  SplashStoreFactory(get()).create() }
    }
