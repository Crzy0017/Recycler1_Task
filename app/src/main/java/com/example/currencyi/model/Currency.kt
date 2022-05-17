package com.example.currencyi.model

import androidx.annotation.DrawableRes

data class Currency(
    val textview: String,
    val value: Int,
    @DrawableRes val imageRes: Int
): Views
