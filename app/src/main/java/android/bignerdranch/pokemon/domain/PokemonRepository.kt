package android.bignerdranch.pokemon.domain

import android.bignerdranch.pokemon.data.network.model.ability.AbilityContainer
import android.bignerdranch.pokemon.data.network.model.detail.FlavorTextEntry

interface PokemonRepository {

    suspend fun loadAbilityData(pokemonId: String): List<AbilityContainer>?

    suspend fun loadFlavorData(url: String): List<FlavorTextEntry>?
}