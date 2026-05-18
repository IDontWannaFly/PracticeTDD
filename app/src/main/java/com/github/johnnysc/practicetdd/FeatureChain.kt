package com.github.johnnysc.practicetdd

sealed interface FeatureChain {
    interface Handle : FeatureChain {
        suspend fun handle(message: String): MessageUI
    }

    interface CheckAndHandle : FeatureChain, Handle {
        fun canHandle(message: String): Boolean
    }
}