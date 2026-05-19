package com.github.johnnysc.practicetdd

interface State {
    fun next(context: StateContext.Update)

    object RequireLogin : State {

        override fun next(context: StateContext.Update) {
            context.updateState(state = LoginSuccessfully)
        }
    }

    object LoginSuccessfully : State {

        override fun next(context: StateContext.Update) {
            context.updateState(state = LoginSuccessfully)
        }
    }
}