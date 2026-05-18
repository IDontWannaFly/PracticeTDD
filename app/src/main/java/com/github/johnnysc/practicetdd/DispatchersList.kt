package com.github.johnnysc.practicetdd

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatchersList {
    fun io() : CoroutineDispatcher
    fun ui() : CoroutineDispatcher
}