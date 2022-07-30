package android.bignerdranch.pokemon.domain

import android.bignerdranch.pokemon.data.network.model.detail.FlavorTextEntry
import javax.inject.Inject

class LoadFlavorUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend fun getFlavor(url: String): List<FlavorTextEntry>? = repository.loadFlavorData(url)
}
