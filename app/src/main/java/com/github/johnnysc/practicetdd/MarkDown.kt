package com.github.johnnysc.practicetdd

object MarkDown {
    interface Parser {
        fun parse(text: String): ResultItem

        private class DefaultParser(val color: String, val markdown: String) : Parser {
            override fun parse(text: String): ResultItem {
                val escapedMarkdown = Regex.escape(markdown)
                val regex = Regex("$escapedMarkdown[^$escapedMarkdown]*$escapedMarkdown")
                var resultText = text
                val results = arrayListOf<ResultItem>()
                while (true) {
                    val match = regex.find(resultText) ?: break
                    val matchWithoutMarkdowns = match.value.replace(markdown, "")
                    resultText = resultText.replaceFirst(match.value, matchWithoutMarkdowns)
                    if (matchWithoutMarkdowns.isEmpty()) continue
                    results.add(
                        ResultItem.StringAndIndex(
                            string = matchWithoutMarkdowns,
                            index = match.range.first,
                        )
                    )
                }


                return ResultItem.Base(
                    color = color,
                    markdown = resultText,
                    result = results
                )
            }
        }

        class Base(val color: String, val markdown: String) :
            Parser by DefaultParser(color = color, markdown = markdown)

        class OneSignDelimiter(val color: String, val markdown: Char) :
            Parser by DefaultParser(color = color, markdown = markdown.toString())
    }

    interface ResultItem {
        data class Base(val color: String, val markdown: String, val result: List<ResultItem>) :
            ResultItem

        data class StringAndIndex(val string: String, val index: Int) : ResultItem
    }
}