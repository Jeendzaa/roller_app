package pl.hiveworkshop.roller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pl.hiveworkshop.roller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private var opt: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        showRollToast()

        binding.root.setOnClickListener()
        {
            // Generating random values of ability and assigning them to appropriate card
            binding.strengthCardValue.text = getRoll().toString()
            binding.dexCardValue.text = getRoll().toString()
            binding.staminaCardValue.text = getRoll().toString()
            binding.intCardValue.text = getRoll().toString()
            binding.mondCardValue.text = getRoll().toString()
            binding.chaCardValue.text = getRoll().toString()
            // Calculation modifications based on ability value
            binding.strengthCardMod.text = "MOD " + (((binding.strengthCardValue.text as String).toInt()-10)/2).toString()
            binding.dexCardMod.text = "MOD " + (((binding.dexCardValue.text as String).toInt()-10)/2).toString()
            binding.staminaCardMod.text = "MOD " + (((binding.staminaCardValue.text as String).toInt()-10)/2).toString()
            binding.intCardMod.text = "MOD " + (((binding.intCardValue.text as String).toInt()-10)/2).toString()
            binding.mondCardMod.text = "MOD " + (((binding.mondCardValue.text as String).toInt()-10)/2).toString()
            binding.chaCardMod.text = "MOD " + (((binding.chaCardValue.text as String).toInt()-10)/2).toString()
        }
    }

    // Function used to generate random values of ability
    private fun getRoll(): Int
    {
        var randomValues = ArrayList<Int>()
        for (i in 1..4)
        {
            randomValues.add(Random.nextInt(1,7))
        }
        println(randomValues)
        println(randomValues.min())
        randomValues.remove(randomValues.min())
        println(randomValues)
        return randomValues.sum()
    }

    private fun showRollToast()
    {
        val toastText = "Naciśnij ekran aby wylosować cechy"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, toastText, duration).show()
    }
}