package com.github.johnnysc.practicetdd.domain

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersList {
    fun io() : CoroutineDispatcher
    fun ui() : CoroutineDispatcher
}