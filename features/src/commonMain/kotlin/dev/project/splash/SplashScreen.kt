package dev.project.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arkivanov.mvikotlin.core.rx.Observer
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import dev.project.news.NewsScreen
import dev.project.splash.mvi.SplashStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        SplashScreenComponents()
    }
}

@Composable
@Preview
internal fun SplashScreenComponents(store: SplashStore = koinInject<SplashStore>()) {
    val navigator = LocalNavigator.currentOrThrow
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        coroutineScope.launch {
            withContext(Dispatchers.Main) {
                delay(1000)
                store.accept(SplashStore.SplashIntent.Loading)
                delay(1000)
                store.accept(SplashStore.SplashIntent.Finish)
            }
        }
    }

    store.labels(
        observer =
            object : Observer<SplashStore.SplashLabel> {
                override fun onComplete() {
                    //
                }

                override fun onNext(value: SplashStore.SplashLabel) {
                    when (value) {
                        is SplashStore.SplashLabel.OpenNews -> navigator.replace(NewsScreen())
                    }
                }
            },
    )

    store.states(
        observer =
            object : Observer<SplashStore.SplashState> {
                override fun onComplete() {
                    //
                }

                override fun onNext(value: SplashStore.SplashState) {
                    println("SplashStore.SplashIntent state $value")
                }
            },
    )

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Splash!")
            Spacer(modifier = Modifier.height(100.dp))
            Text("${store.state}")
        }
    }
}
