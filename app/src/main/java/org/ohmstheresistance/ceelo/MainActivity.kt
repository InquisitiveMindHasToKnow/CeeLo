package org.ohmstheresistance.ceelo

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.ceelo.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pressBackTwiceToExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.firstDieImageImageview
        binding.secondDieImageImageview
        binding.thirdDieImageImageview


        binding.showRulesTextview
        binding.showRulesTextview.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        binding.rollDiceButton.setOnClickListener {
            rollDice()
            buttonEffect()
        }


        binding.showRulesTextview.setOnClickListener {
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

        binding.firstDieImageImageview.setImageResource(dieOne)
        binding.secondDieImageImageview.setImageResource(dieTwo)
        binding.thirdDieImageImageview.setImageResource(dieThree)
    }

    private fun showRules() {

        val showCeeLoRulesDialog = CeeLoRules()
        showCeeLoRulesDialog.show(supportFragmentManager, "CeeLoRulesDialog")

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun buttonEffect() {
        binding.rollDiceButton.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.background.setColorFilter(
                        resources.getColor(R.color.buttonEffectColor),
                        PorterDuff.Mode.SRC_ATOP
                    )
                    view.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    view.background.clearColorFilter()
                    view.invalidate()
                }
            }
            false
        }
    }




        override fun onBackPressed() {
            if (pressBackTwiceToExit) {
                super.onBackPressed()
                return
            }

            this.pressBackTwiceToExit = true
            Toast.makeText(this, "Please click BACK again to exit.", Toast.LENGTH_SHORT).show()

            Handler().postDelayed(Runnable {
                pressBackTwiceToExit = false }, 2000)
        }

}
