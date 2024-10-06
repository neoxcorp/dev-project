package dev.project.splash.mvi

import com.arkivanov.mvikotlin.core.store.Store
import dev.project.splash.mvi.SplashStore.SplashIntent
import dev.project.splash.mvi.SplashStore.SplashLabel
import dev.project.splash.mvi.SplashStore.SplashState

internal interface SplashStore : Store<SplashIntent, SplashState, SplashLabel> {
    sealed interface SplashIntent {
        data object Loading : SplashIntent

        data object Finish : SplashIntent
    }

    sealed interface SplashLabel {
        data object OpenNews : SplashLabel
    }

    sealed interface SplashState {
        data object Idle : SplashState

        data object Initialized : SplashState

        data object Loading : SplashState

        data object Loaded : SplashState
    }
}
