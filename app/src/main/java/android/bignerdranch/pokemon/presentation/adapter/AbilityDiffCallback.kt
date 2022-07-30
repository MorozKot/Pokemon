package android.bignerdranch.pokemon.presentation.adapter

import android.bignerdranch.pokemon.data.network.model.ability.AbilityContainer
import androidx.recyclerview.widget.DiffUtil

object AbilityDiffCallback : DiffUtil.ItemCallback<AbilityContainer>() {

    override fun areItemsTheSame(oldItem: AbilityContainer, newItem: AbilityContainer): Boolean {
        return oldItem.ability == newItem.ability
    }

    override fun areContentsTheSame(oldItem: AbilityContainer, newItem: AbilityContainer): Boolean {
        return oldItem == newItem
    }
}
