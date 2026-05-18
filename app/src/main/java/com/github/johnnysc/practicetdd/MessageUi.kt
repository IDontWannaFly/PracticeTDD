package com.github.johnnysc.practicetdd

sealed interface MessageUi {
    object LoadMore : MessageUi
    object LoadPrevious: MessageUi
    data class Base(val id: Int, val message: String) : MessageUi
}