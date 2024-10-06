package dev.project.common

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.arkivanov.mvikotlin.timetravel.store.TimeTravelStoreFactory
import org.koin.dsl.module

val commonModule =
    module {
        single<StoreFactory> {
            if (true) {
                LoggingStoreFactory(delegate = TimeTravelStoreFactory())
            } else {
                DefaultStoreFactory()
            }
        }
    }
