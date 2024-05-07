
package com.example.flora.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Flora(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
