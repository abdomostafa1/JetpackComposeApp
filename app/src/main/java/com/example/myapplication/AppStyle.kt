package com.example.myapplication

import androidx.activity.SystemBarStyle

interface AppStyle {
    abstract fun changeSystemBar(
        statusBarsStyle: SystemBarStyle,
        navigationBarsStyle: SystemBarStyle
    )
}