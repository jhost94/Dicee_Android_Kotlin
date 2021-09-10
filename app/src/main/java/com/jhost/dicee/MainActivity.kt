package com.jhost.dicee

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("Hello world!")

        initialize()
    }

    private fun initialize() {
        log("I WAS HERE")
        val dices = intArrayOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )

        val rollButton: Button = findViewById(R.id.rollbutton)
        val leftDice: ImageView = findViewById(R.id.leftDice)
        val rightDice: ImageView = findViewById(R.id.rightDice)

        setRandomDice(leftDice, dices)
        setRandomDice(rightDice, dices)

        rollButton.setOnClickListener {
            setRandomDice(leftDice, dices)
            setRandomDice(rightDice, dices)
        }
    }

    private fun setRandomDice(imageView: ImageView, dices: IntArray){
        log(Random(dices.size).nextInt().toString())
        imageView.setImageResource(dices[Random.nextInt(dices.size)])
    }

    private fun log(msg: String) {
        Log.d("Dicee", msg)
    }
}