package kz.rymbek.platform.common.core.design.foundation.components.drop_down_menu.large

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kz.rymbek.platform.common.base.model.interfaces.Identifiable
import kz.rymbek.platform.common.core.design.foundation.components.card.AppFilledCard
import kz.rymbek.platform.common.core.design.foundation.components.dialog.AppDialog
import kz.rymbek.platform.common.core.design.foundation.components.divider.AppHorizontalDivider
import kz.rymbek.platform.common.core.design.foundation.components.drop_down_menu.exposed.AppDropdownMenuItem
import kz.rymbek.platform.common.core.design.foundation.components.list.lazy.column.AppLazyColumnItem
import kz.rymbek.platform.common.core.design.foundation.icons.AppIcons
import kz.rymbek.platform.common.core.design.foundation.components.icon.AppIcon
import kz.rymbek.platform.common.core.design.foundation.components.text_field.regular.AppTextField
import kz.rymbek.platform.common.core.design.foundation.constants.Dimensions

@Composable
fun <T: Identifiable> LargeDropDownMenuDialog(
    expanded: MutableState<Boolean>,
    items: List<T>,
    selectedItemToString: (T) -> String,
    selectedItemToImage: (T) -> Any? = { null },
    onItemSelected: (index: Int, item: T) -> Unit,
) {
    var searchQuery by rememberSaveable { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    //Don't use rememberSaveable, on intent you may get percelable error
    var filteredItems by remember { mutableStateOf(items) }

    LaunchedEffect(searchQuery) {
        coroutineScope.launch {
            delay(300)
            filteredItems = items.filter { selectedItemToString(it).contains(searchQuery, ignoreCase = true) }
        }
    }

    AppDialog(
        isDialogOpen = expanded,
        content = {
            AppFilledCard(
                content = {
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = searchQuery,
                        onValueChange = {
                            searchQuery = it
                        },
                        leadingIcon = {
                            AppIcon(imageVector = AppIcons.OutlinedSearch)
                        },
                        placeholder = "Поиск",
                    )

                    AppLazyColumnItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        items = filteredItems,
                        contentPadding = PaddingValues(0.dp),
                        verticalArrangement = Arrangement.Center,
                        content = { index, item ->
                            AppDropdownMenuItem(
                                text = selectedItemToString(item),
                                trailingIconUri = selectedItemToImage(item),
                                onClick = {
                                    onItemSelected(index, item)
                                },
                            )

                            if (index != filteredItems.lastIndex) {
                                AppHorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = Dimensions.defaultPaddingDp)
                                )
                            }
                        }
                    )
                }
            )
        }
    )
}