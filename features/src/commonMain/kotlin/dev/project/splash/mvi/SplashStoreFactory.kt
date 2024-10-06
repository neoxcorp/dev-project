package dev.project.splash.mvi

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dev.project.splash.di.SPLASH_STORE_NAME
import dev.project.splash.mvi.SplashStore.SplashIntent
import dev.project.splash.mvi.SplashStore.SplashLabel
import dev.project.splash.mvi.SplashStore.SplashState

class SplashStoreFactory(
    private val storeFactory: StoreFactory,
) {
    internal fun create(): SplashStore =
        object :
            SplashStore,
            Store<SplashIntent, SplashState, SplashLabel> by storeFactory.create(
                name = SPLASH_STORE_NAME,
                initialState = SplashState.Idle,
                bootstrapper = SplashBootstrapper(),
                executorFactory = ::SplashExecutor,
                reducer = SplashReducer,
            ) {
        }
}
