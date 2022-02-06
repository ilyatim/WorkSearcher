package com.example.composeworksearcher.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Colors.bottomNavigationColor: Color
    get() = if (isLight) Color.White else dark_surface

val Colors.bottomNavigationSelectedColor: Color
    get() = if (isLight) light_green_8fd389 else light_blue

val Colors.bottomNavigationUnselectedColor: Color
    get() = if (isLight) grey_C9C9C9 else grey_808080

val light_green_8fd389: Color = Color(0xFF8FD389)
val light_blue: Color = Color(0xFF66A4ED)
val grey_808080: Color = Color(0xFF808080)
val grey_C9C9C9: Color = Color(0xFFC9C9C9)
