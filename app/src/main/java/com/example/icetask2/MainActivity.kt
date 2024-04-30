package com.example.icetask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Generate a random number between 1 and 100
        randomNumber = Random.nextInt(1, 101)

        guessButton.setOnClickListener {
            // Get user input from EditText
            val guess = guessEditText.text.toString().toIntOrNull()

            if (guess != null) {
                // Check the guess
                checkGuess(guess)
            } else {
                resultTextView.text = "Please enter a valid number."
            }
        }
    }

    private fun checkGuess(guess: Int) {
        when {
            guess < randomNumber -> resultTextView.text = "Too low! Try again."
            guess > randomNumber -> resultTextView.text = "Too high! Try again."
            else -> resultTextView.text = "Congratulations! You guessed the correct number."
        }
    }
}