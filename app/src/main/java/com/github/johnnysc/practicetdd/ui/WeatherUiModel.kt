package com.github.johnnysc.practicetdd.ui

data class WeatherUiModel(
    val description: String,
    val isError: Boolean = false,
)