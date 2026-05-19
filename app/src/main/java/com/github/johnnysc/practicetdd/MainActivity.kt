package com.github.johnnysc.practicetdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//MainActivity is a mediator itself. Change my mind ;)
class MainActivity : AppCompatActivity() {

    private var selectedButtonId = 0
    private val buttons = arrayListOf<ChoiceButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstButton = findViewById<ChoiceButton>(R.id.firstChoiceButton)
        val secondButton = findViewById<ChoiceButton>(R.id.secondChoiceButton)
        val thirdButton = findViewById<ChoiceButton>(R.id.thirdChoiceButton)

        buttons.add(firstButton)
        buttons.add(secondButton)
        buttons.add(thirdButton)

        firstButton.setOnClickListener { onButtonClicked(R.id.firstChoiceButton) }
        secondButton.setOnClickListener { onButtonClicked(R.id.secondChoiceButton) }
        thirdButton.setOnClickListener { onButtonClicked(R.id.thirdChoiceButton) }
    }

    private fun onButtonClicked(buttonId: Int) {
        selectedButtonId = buttonId
        buttons.forEach { it.isEnabled = it.id != buttonId }
        findViewById<Button>(R.id.saveButton).isEnabled = true
    }
}