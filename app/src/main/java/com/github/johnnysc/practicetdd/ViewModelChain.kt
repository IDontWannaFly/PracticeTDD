package com.github.johnnysc.practicetdd

class ViewModelChain(
    private val featureChain: FeatureChain
) {
    private var nextFeatureChain: FeatureChain? = null

    fun nextFeatureChain(nextFeatureChain: FeatureChain) {
        this.nextFeatureChain = nextFeatureChain
    }

    suspend fun handle(message: String): MessageUI {
        return handleChain(featureChain, message)
            ?: nextFeatureChain?.let {
                return@let handleChain(it, message)
            } ?: MessageUI.Empty
    }

    private suspend fun handleChain(chain: FeatureChain, message: String): MessageUI? {
        return when (chain) {
            is FeatureChain.CheckAndHandle -> if (chain.canHandle(message)) chain.handle(message)
            else null

            is FeatureChain.Handle -> chain.handle(message)
        }
    }
}