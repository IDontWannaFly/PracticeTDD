package com.github.johnnysc.practicetdd

object StateContext {
    interface Actions {
        fun log(logging: Logging)
        fun next()
    }

    interface Update {
        fun updateState(state: State)
    }

    class Base(private var state: State) : Actions, Update {
        override fun log(logging: Logging) {
            logging.log(state.javaClass.simpleName)
        }

        override fun next() {
            state.next(this)
        }

        override fun updateState(state: State) {
            this.state = state
        }
    }
}