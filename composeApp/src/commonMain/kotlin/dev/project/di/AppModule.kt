package dev.project.di

import dev.project.common.commonModule
import dev.project.news.di.newsModule
import dev.project.splash.di.splashModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            appModule(),
        )
    }
}

private fun appModule() =
    listOf(
        commonModule,
        splashModule,
        newsModule,
    )
