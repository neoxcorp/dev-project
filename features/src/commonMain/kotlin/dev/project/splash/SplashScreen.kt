package dev.project.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.states
import dev.project.common.lastLabel
import dev.project.common.theme.Colors
import dev.project.news.NewsScreen
import dev.project.splash.mvi.SplashStore
import kotlinx.coroutines.delay
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
    val state = store.states.collectAsState(SplashStore.SplashState.Idle)

    LaunchedEffect(true) {
        // for test
        delay(100)
        store.accept(SplashStore.SplashIntent.Loading)
        delay(100)
        store.accept(SplashStore.SplashIntent.Finish)
        delay(100)
        store.accept(SplashStore.SplashIntent.Loading)
        delay(100)
        store.accept(SplashStore.SplashIntent.Finish)
    }

    store.labels.lastLabel { label ->
        when (label) {
            is SplashStore.SplashLabel.Idle -> { // no-op
            }

            is SplashStore.SplashLabel.OpenNews -> navigator.replace(NewsScreen())
        }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Splash!", fontSize = 24.sp, color = Color.Red)
//            Text(text = stringResource(Res.string.), fontSize = 24.sp, color = Color.Red)
            Spacer(modifier = Modifier.height(50.dp))
            CircularProgressIndicator(modifier = Modifier.size(50.dp), color = Colors.Red)
        }
    }
}
