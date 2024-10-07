package dev.project.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arkivanov.mvikotlin.extensions.coroutines.states
import dev.project.common.theme.transparent
import dev.project.news.mvi.NewsStore
import devproject.features.generated.resources.Res
import devproject.features.generated.resources.some_icon
import org.jetbrains.compose.resources.painterResource
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

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("News...", fontSize = 24.sp, color = MaterialTheme.colorScheme.primary)
            Text("News...", fontSize = 24.sp, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                modifier =
                    Modifier
                        .wrapContentSize()
                        .background(color = transparent),
                onClick = {
                    println("click!")
                },
            ) {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(Res.drawable.some_icon),
                    contentDescription = "news",
                )
            }
        }
    }
}
