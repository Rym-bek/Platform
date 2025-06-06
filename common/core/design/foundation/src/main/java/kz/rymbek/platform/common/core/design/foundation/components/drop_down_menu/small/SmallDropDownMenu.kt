package kz.rymbek.platform.common.core.design.foundation.components.drop_down_menu.small

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import kz.rymbek.platform.common.base.model.interfaces.Identifiable
import kz.rymbek.platform.common.core.design.foundation.components.divider.AppHorizontalDivider
import kz.rymbek.platform.common.core.design.foundation.components.drop_down_menu.exposed.AppDropdownMenuItem
import kz.rymbek.platform.common.core.design.foundation.components.drop_down_menu.exposed.AppExposedDropDownMenu
import kz.rymbek.platform.common.core.design.foundation.constants.Dimensions

@Composable
fun <T: Identifiable> ExposedDropdownMenuBoxScope.SmallDropDownMenu(
    modifier: Modifier = Modifier,
    items: List<T>,
    expanded: MutableState<Boolean>,
    onItemSelected: (
        index: Int,
        text: T,
    ) -> Unit,
    selectedItemToString: (T) -> String,
    selectedItemToImage: (T) -> Any?,
) {
    AppExposedDropDownMenu(
        modifier = modifier,
        expanded = expanded.value,
        onDismissRequest = {
            expanded.value = false
        },
        content = {
            items.forEachIndexed { index, selectionOption ->
                AppDropdownMenuItem(
                    text = selectedItemToString(selectionOption),
                    trailingIconUri = selectedItemToImage(selectionOption),
                    onClick = {
                        onItemSelected(
                            index,
                            selectionOption
                        )
                    },
                )

                if(index != items.lastIndex) {
                    AppHorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimensions.defaultPaddingDp)
                    )
                }
            }
        }
    )
}