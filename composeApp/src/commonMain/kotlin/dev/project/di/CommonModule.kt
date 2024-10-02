package dev.project.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import dev.project.Greeting

val commonModule =
    module {
        singleOf(::Greeting)
    }