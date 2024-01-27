package tech.eightbits.home_ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp

/**
 * Created by ozan on 21.01.2024
 */

@Composable
fun <T> MagnifyLazyRow(
    rowModifier: Modifier = Modifier,
    itemContainerModifier: Modifier = Modifier,
    items: List<T>,
    widthOfRow: Int,
    boxMinSize: Float,
    boxMaxSize: Float,
    itemContent: @Composable (T, Float) -> Unit
) {

    val rowState = LazyListState()

    LazyRow(
        modifier = rowModifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        state = rowState,
        // flingBehavior = rememberSnapFlingBehavior(lazyListState = rowState)
    ) {
        items(items) {
            AdaptableBox(
                item = it,
                widthOfRow,
                containerModifier = itemContainerModifier,
                boxMaxSize = boxMaxSize,
                boxMinSize = boxMinSize,
                content = itemContent
            )
        }
    }

}

@Composable
fun <T> AdaptableBox(
    item: T,
    width: Int,
    boxMinSize: Float,
    boxMaxSize: Float,
    containerModifier: Modifier = Modifier,
    content: @Composable (T, Float) -> Unit
) {
    val centerOffsetOfScreen = remember {
        (width / 2).toFloat()
    }

    val boxCenterOffset = rememberSaveable {
        mutableFloatStateOf(0f)
    }

    val boxPosition = rememberSaveable(boxCenterOffset.floatValue, centerOffsetOfScreen) {
        if (boxCenterOffset.floatValue > 0 && boxCenterOffset.floatValue < centerOffsetOfScreen) {
            boxCenterOffset.floatValue
        } else if (boxCenterOffset.floatValue > centerOffsetOfScreen && boxCenterOffset.floatValue < (2 * centerOffsetOfScreen)) {
            width - boxCenterOffset.floatValue
        } else {
            0f
        }
    }

    val boxSize = rememberSaveable(boxPosition) {
        val slope = (boxMaxSize - boxMinSize) / centerOffsetOfScreen
        (slope * boxPosition) + boxMinSize
    }

    Box(
        modifier = containerModifier
            .size(boxSize.dp)
            .onGloballyPositioned { coords ->
                with(coords.positionInRoot()) {
                    val centerOffset = x + (coords.size.width / 2)
                    boxCenterOffset.floatValue = centerOffset
                }
            },
    ) {
        content(item, boxSize)
    }

}