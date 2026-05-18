package com.github.johnnysc.practicetdd

class MessageMapper {
    fun map(model: MessageDomain) : MessageUi {
        return when (model) {
            is MessageDomain.Base -> MessageUi.Base(
                id = model.id,
                message = model.text
            )
            MessageDomain.LoadMore -> MessageUi.LoadMore
            MessageDomain.LoadPrevious -> MessageUi.LoadPrevious
        }
    }
}