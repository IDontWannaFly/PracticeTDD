package com.github.johnnysc.practicetdd

interface Choice {
    fun init(mediator: Mediator, block: () -> Unit)
    fun isChosen() : Boolean
    fun chose()
    fun rollback()
}