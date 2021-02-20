package com.mualim.diceroller

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mualim.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        status(false)

        mainBinding.button.setOnClickListener {
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()

            // Do a dice roll when the app starts
            rollDice()
            status(true)
        }

        mainBinding.btnReset.setOnClickListener {
            status(false)
        }
    }

    private fun status(state: Boolean) {
        if (state) {
            mainBinding.imageView.visibility = View.VISIBLE
            mainBinding.imageView2.visibility = View.VISIBLE
            mainBinding.btnReset.visibility = View.VISIBLE
        } else {
            mainBinding.imageView.visibility = View.GONE
            mainBinding.imageView2.visibility = View.GONE
            mainBinding.btnReset.visibility = View.GONE
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val dice2 = Dice(6)

        // Determine which drawable resource ID to use based on the dice roll
        val imageDrawable = when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Determine which drawable resource ID to use based on the dice roll
        val imageDrawable2 = when (dice2.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        mainBinding.imageView.setImageResource(imageDrawable)

        mainBinding.imageView2.setImageResource(imageDrawable2)
    }


}