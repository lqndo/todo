package com.example.todo.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class TodoColorStyles(
    val primary: Color = Color.Unspecified,
    val secondary: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val onPrimary: Color = Color.Unspecified,
    val onSecondary: Color = Color.Unspecified,
    val onBackground: Color = Color.Unspecified
)

val LocalAppColorStyles = staticCompositionLocalOf { TodoColorStyles() }

val TodoDarkColorScheme = TodoColorStyles(
    primary = Color(0xFF1F2340),
    secondary = Color(0xFF414378),
    background = Color(0xFF0F161F),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    onBackground = Color(0xFFFAF9EA)
)

val TodoLightColorScheme = TodoColorStyles(
    primary = Color(0xFFDAD8D7),
    secondary = Color(0xFF7C88B8),
    background = Color(0xFFF2F2F8),
    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFF1C1B1F)
)

val BackgroundWhite = Color(0xFFF2F2F8)
val OnBackgroundBlack = Color(0xFF1C1B1F)
val LightGrey = Color(0xFFDAD8D7)
val GreyBlue = Color(0xFF7C88B8)
val BlackText = Color.Black

val DarkBlue = Color(0xFF0F161F)
val OnBackgroundWhite = Color(0xFFFAF9EA)
val NavyBlue = Color(0xFF1F2340)
val BlueGray = Color(0xFF414378)
val WhiteText = Color.White
