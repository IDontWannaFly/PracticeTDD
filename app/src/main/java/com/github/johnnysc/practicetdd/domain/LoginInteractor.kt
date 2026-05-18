package com.github.johnnysc.practicetdd.domain

import com.github.johnnysc.practicetdd.domain.WeatherItem

interface LoginInteractor {
    suspend fun login(): WeatherItem
}