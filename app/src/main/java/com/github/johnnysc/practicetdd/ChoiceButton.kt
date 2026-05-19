package com.github.johnnysc.practicetdd

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class ChoiceButton(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    AppCompatButton(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null, androidx.appcompat.R.attr.buttonStyle)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, androidx.appcompat.R.attr.buttonStyle)
}