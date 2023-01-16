package com.example.easyprint.dataclass

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DataForScreen(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    val route: String
    )
