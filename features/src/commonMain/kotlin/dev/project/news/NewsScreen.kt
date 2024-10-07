package dev.project.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.states
import dev.project.common.lastLabel
import dev.project.common.theme.transparent
import dev.project.news.mvi.NewsStore
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

class NewsScreen : Screen {
    @Composable
    override fun Content() {
        NewsScreenComponents()
    }
}

@Composable
@Preview
internal fun NewsScreenComponents(store: NewsStore = koinInject<NewsStore>()) {
    val navigator = LocalNavigator.currentOrThrow
    val state = store.states.collectAsState(NewsStore.NewsState.Idle)
    val stateValue = state.value
    val isEnableRefresh =
        stateValue is NewsStore.NewsState.Idle ||
            stateValue is NewsStore.NewsState.Loaded ||
            stateValue is NewsStore.NewsState.Error

    store.labels.lastLabel { label ->
        when (label) {
            is NewsStore.NewsLabel.PrintLog -> println("log: ${label.log}")
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(Modifier.fillMaxWidth().wrapContentHeight()) {
            Text(
                modifier =
                    Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterStart),
                text = "News",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.error,
            )
            Button(
                modifier =
                    Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterEnd)
                        .alpha(if (isEnableRefresh) 1.0F else 0.3F),
                colors = ButtonDefaults.buttonColors(backgroundColor = transparent),
                onClick = {
                    store.accept(NewsStore.NewsIntent.LoadAgain)
                },
                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                enabled = isEnableRefresh,
            ) {
                Text(
                    text = "Refresh",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Box(Modifier.fillMaxSize()) {
            when (stateValue) {
                is NewsStore.NewsState.Idle ->
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "idle",
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.primary,
                    )

                is NewsStore.NewsState.Loading ->
                    CircularProgressIndicator(
                        modifier = Modifier.size(56.dp).align(Alignment.Center),
                    )

                is NewsStore.NewsState.Loaded ->
                    Text(
                        text = stateValue.loadedData,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.primary,
                    )

                is NewsStore.NewsState.Error ->
                    Text(
                        modifier = Modifier.wrapContentSize().align(Alignment.Center),
                        text = stateValue.error,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.error,
                    )
            }
        }
    }
}
