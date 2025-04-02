package kz.rymbek.platform.common.core.design.foundation.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.BaseColorScheme
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.errorContainerDark
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.errorContainerLight
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.errorDark
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.errorLight
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.onErrorContainerDark
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.onErrorContainerLight
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.onErrorDark
import kz.rymbek.platform.common.core.design.foundation.theme.color.base.onErrorLight

/**
 * Colors for Green Apple theme
 * Original color scheme by CarlosEsco, Jays2Kings and CrepeTF
 * M3 colors generated by Material Theme Builder (https://goo.gle/material-theme-builder-web)
 *
 * Key colors:
 * Primary #188140
 * Secondary #188140
 * Tertiary #D33131
 * Neutral #5D5F5B
 */
internal object GreenAppleColorScheme : BaseColorScheme() {
    override val darkScheme = darkColorScheme(
        primary = Color(0xFF7ADB8F),
        onPrimary = Color(0xFF003917),
        primaryContainer = Color(0xFF017737),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFF7ADB8F), // Unread badge
        onSecondary = Color(0xFF003917), // Unread badge text
        secondaryContainer = Color(0xFF017737), // Navigation bar selector pill & progress indicator (remaining)
        onSecondaryContainer = Color(0xFFFFFFFF), // Navigation bar selected icon
        tertiary = Color(0xFFFFB3AC), // Downloaded badge
        onTertiary = Color(0xFF680008), // Downloaded badge text
        tertiaryContainer = Color(0xFFC7282A),
        onTertiaryContainer = Color(0xFFFFFFFF),
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = Color(0xFF0F1510),
        onBackground = Color(0xFFDFE4DB),
        surface = Color(0xFF0F1510),
        onSurface = Color(0xFFDFE4DB),
        surfaceVariant = Color(0xFF3F493F), // Navigation bar background (ThemePrefWidget)
        onSurfaceVariant = Color(0xFFBECABC),
        outline = Color(0xFF889487),
        outlineVariant = Color(0xFF3F493F),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFDFE4DB),
        inverseOnSurface = Color(0xFF2C322C),
        inversePrimary = Color(0xFF006D32),
        surfaceDim = Color(0xFF0F1510),
        surfaceBright = Color(0xFF353B35),
        surfaceContainerLowest = Color(0xFF0A0F0B),
        surfaceContainerLow = Color(0xFF181D18),
        surfaceContainer = Color(0xFF1C211C), // Navigation bar background
        surfaceContainerHigh = Color(0xFF262B26),
        surfaceContainerHighest = Color(0xFF313630),
    )

    override val lightScheme = lightColorScheme(
        primary = Color(0xFF005927),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFF188140),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFF005927), // Unread badge
        onSecondary = Color(0xFFFFFFFF), // Unread badge text
        secondaryContainer = Color(0xFF97f7a9), // Navigation bar selector pill & progress indicator (remaining)
        onSecondaryContainer = Color(0xFF000000), // Navigation bar selected icon
        tertiary = Color(0xFF9D0012), // Downloaded badge
        onTertiary = Color(0xFFFFFFFF), // Downloaded badge text
        tertiaryContainer = Color(0xFFD33131),
        onTertiaryContainer = Color(0xFFFFFFFF),
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = Color(0xFFF6FBF2),
        onBackground = Color(0xFF181D18),
        surface = Color(0xFFF6FBF2),
        onSurface = Color(0xFF181D18),
        surfaceVariant = Color(0xFFDAE6D7), // Navigation bar background (ThemePrefWidget)
        onSurfaceVariant = Color(0xFF3F493F),
        outline = Color(0xFF6F7A6E),
        outlineVariant = Color(0xFFBECABC),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2C322C),
        inverseOnSurface = Color(0xFFEDF2E9),
        inversePrimary = Color(0xFF7ADB8F),
        surfaceDim = Color(0xFFD6DCD3),
        surfaceBright = Color(0xFFF6FBF2),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF0F5EC),
        surfaceContainer = Color(0xFFEAEFE6), // Navigation bar background
        surfaceContainerHigh = Color(0xFFE4EAE1),
        surfaceContainerHighest = Color(0xFFDFE4DB),
    )
}
