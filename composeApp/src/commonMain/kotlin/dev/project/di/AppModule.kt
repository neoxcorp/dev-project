package dev.project.di

import org.koin.core.context.startKoin

fun appModule() = listOf(commonModule)

fun initKoin() {
    startKoin {
        modules(
            appModule(),
        )
    }
}
