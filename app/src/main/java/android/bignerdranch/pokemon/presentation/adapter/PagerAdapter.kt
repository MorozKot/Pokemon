package android.bignerdranch.pokemon.presentation.adapter

import android.bignerdranch.pokemon.presentation.AbilityFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AbilityFragment(pokemonId = "10")
            1 -> AbilityFragment(pokemonId = "20")
            else -> AbilityFragment(pokemonId = "30")
        }
    }
}