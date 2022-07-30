package android.bignerdranch.pokemon.domain

import android.bignerdranch.pokemon.data.network.model.ability.AbilityContainer
import javax.inject.Inject

class LoadAbilityUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend fun getAbilityList(pokemonId: String): List<AbilityContainer>? =
        repository.loadAbilityData(pokemonId)
}
