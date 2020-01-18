package org.ohmstheresistance.ceelo

import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var firstResultDie: ImageView
    lateinit var secondResultDie: ImageView
    lateinit var thirdResultDie: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        firstResultDie = findViewById(R.id.first_die_image_imageview)
        secondResultDie = findViewById(R.id.second_die_image_imageview)
        thirdResultDie = findViewById(R.id.third_die_image_imageview)

        val rollButton: Button = findViewById(R.id.roll_dice_button)
        val showRulesTextView: TextView = findViewById(R.id.show_rules_button)
        showRulesTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        rollButton.setOnClickListener {
            rollDice()
        }


        showRulesTextView.setOnClickListener {
            showRules()
        }

    }

    private fun rollDice() {


        val dieOneRoll = Random().nextInt(6) + 1
        val dieTwoRoll = Random().nextInt(6) + 1
        val dieThreeRoll = Random().nextInt(6) + 1


        val dieOne = when (dieOneRoll) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val dieTwo = when (dieTwoRoll) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val dieThree = when (dieThreeRoll) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        firstResultDie.setImageResource(dieOne)
        secondResultDie.setImageResource(dieTwo)
        thirdResultDie.setImageResource(dieThree)
    }

    private fun showRules(){

        val showCeeLoRulesDialog = CeeLoRules()
        showCeeLoRulesDialog.show(supportFragmentManager, "CeeLoRulesDialog")

    }
}
