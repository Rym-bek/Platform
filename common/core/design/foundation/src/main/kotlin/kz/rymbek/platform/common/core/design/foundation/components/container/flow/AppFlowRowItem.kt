package kz.rymbek.platform.common.core.design.foundation.components.container.flow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kz.rymbek.platform.common.core.design.foundation.constants.Dimensions

@Composable
fun <T> AppFlowRowItem(
    items: Iterable<T>,
    content: @Composable (FlowRowScope.(index: Int, item: T) -> Unit),
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement. Horizontal = Arrangement.spacedBy(Dimensions.defaultPaddingDp),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    itemVerticalAlignment: Alignment.Vertical = Alignment.Top,
    maxItemsInEachRow: Int = Int.MAX_VALUE,
    maxLines: Int = Int.MAX_VALUE,
) {
    AppFlowRow(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalArrangement = verticalArrangement,
        itemVerticalAlignment = itemVerticalAlignment,
        maxItemsInEachRow = maxItemsInEachRow,
        maxLines = maxLines,
        content = {
            items.forEachIndexed { index, item ->
                content(index, item)
            }
        },
    )
}