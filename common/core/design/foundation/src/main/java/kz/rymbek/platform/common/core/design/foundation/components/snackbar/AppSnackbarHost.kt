package kz.rymbek.platform.common.core.design.foundation.components.snackbar

import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppSnackbarHost(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState
) {
    SnackbarHost(
        modifier = modifier,
        hostState = snackbarHostState,
        snackbar = { snackbarData: SnackbarData ->
            AppSnackbar(
                snackbarData = snackbarData,
            )
        }
    )
}