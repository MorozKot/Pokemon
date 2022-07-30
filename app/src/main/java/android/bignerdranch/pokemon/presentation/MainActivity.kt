package android.bignerdranch.pokemon.presentation

import android.bignerdranch.pokemon.databinding.ActivityMainBinding
import android.bignerdranch.pokemon.presentation.adapter.PagerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = PagerAdapter(this)
    }
}


