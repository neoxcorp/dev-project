package dev.project.di

import dev.project.Greeting
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val commonModule =
    module {
        singleOf(::Greeting)
    }
