package dev.project.news.di

import dev.project.news.mvi.NewsStore
import dev.project.news.mvi.NewsStoreFactory
import org.koin.dsl.module

const val NEWS_STORE_NAME = "NewsStore"

val newsModule =
    module {
        factory<NewsStore> { NewsStoreFactory(get()).create() }
    }
