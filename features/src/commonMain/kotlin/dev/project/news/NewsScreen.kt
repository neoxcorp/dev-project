package dev.project.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import dev.project.common.theme.Colors
import devproject.features.generated.resources.Res
import devproject.features.generated.resources.some_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

class NewsScreen : Screen {
    @Composable
    override fun Content() {
        NewsScreenComponents()
    }
}

@Composable
@Preview
fun NewsScreenComponents() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("News...", fontSize = 24.sp, color = Colors.Red)
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(Res.drawable.some_icon),
                contentDescription = "news",
            )
        }
    }
}
