package dev.project.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <Label : Any> Flow<Label>.lastLabel(
    key: Any? = Unit,
    onLast: (Label) -> Unit,
) {
    val labels = this
    LaunchedEffect(key) {
        labels.collectLatest { label -> onLast.invoke(label) }
    }
}
