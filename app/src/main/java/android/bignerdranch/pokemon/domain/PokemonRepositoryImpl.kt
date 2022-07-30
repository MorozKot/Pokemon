package android.bignerdranch.pokemon.domain


import android.bignerdranch.pokemon.data.network.ApiService
import android.bignerdranch.pokemon.data.network.model.ability.AbilityContainer
import android.bignerdranch.pokemon.data.network.model.detail.FlavorTextEntry
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonRepository {

    override suspend fun loadAbilityData(pokemonId: String): List<AbilityContainer>? {
        var result: List<AbilityContainer>? = null

        try {
            val call = apiService.getAbilitiesResponse(pokemonId)
            if (call.isSuccessful) {
                call.body()?.let {
                    result = it.abilityList
                }
            }
        } catch (e: Exception) {
            result = null
        }
        return result
    }

    override suspend fun loadFlavorData(url: String): List<FlavorTextEntry>? {
        var result: List<FlavorTextEntry>? = null

        try {
            val call = apiService.getFlavorResponse(url)
            if (call.isSuccessful) {
                call.body()?.let {
                    result = it.flavorList
                }
            }
        } catch (e: Exception) {
            result = null
        }
        return result
    }
}
