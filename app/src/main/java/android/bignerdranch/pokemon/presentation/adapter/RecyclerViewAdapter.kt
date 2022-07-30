package android.bignerdranch.pokemon.presentation.adapter

import android.bignerdranch.pokemon.data.network.model.ability.AbilityContainer
import android.bignerdranch.pokemon.data.network.model.ability.AbilityNameUrl
import android.bignerdranch.pokemon.databinding.ItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : ListAdapter<AbilityContainer, RecyclerViewHolder>(AbilityDiffCallback) {

    var onAbilityClickListener: OnAbilityClickListener? = null

    interface OnAbilityClickListener {
        fun onAbilityClick(abilityNameUrl: AbilityNameUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val pokemon = getItem(position).ability

        with(holder.binding) {
            with(pokemon) {
                itemName.text = name.replaceFirstChar { it.uppercase() }
                root.setOnClickListener {
                    onAbilityClickListener?.onAbilityClick(this)
                }
            }
        }
    }
}

class RecyclerViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)



