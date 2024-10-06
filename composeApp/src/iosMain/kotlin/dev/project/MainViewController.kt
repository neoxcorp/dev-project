package dev.project

import androidx.compose.ui.window.ComposeUIViewController
import dev.project.di.initKoin

fun MainViewController() =
    ComposeUIViewController {
        initKoin()
        AppComponents()
    }
