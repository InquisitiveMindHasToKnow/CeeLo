package org.ohmstheresistance.ceelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_dice_button)
        rollButton.setOnClickListener {

            rollDice()
        }

    }

    private fun rollDice() {
        val firstResultDie: ImageView = findViewById(R.id.first_die_image_imageview)
        val secondResultDie: ImageView = findViewById(R.id.second_die_image_imageview)
        val thirdResultDie: ImageView = findViewById(R.id.third_die_image_imageview)


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
}
