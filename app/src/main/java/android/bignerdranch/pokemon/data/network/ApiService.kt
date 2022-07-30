package android.bignerdranch.pokemon.data.network

import android.bignerdranch.pokemon.data.network.model.ability.AbilityResponse
import android.bignerdranch.pokemon.data.network.model.detail.FlavorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/v2/pokemon/{pokemonId}")
    suspend fun getAbilitiesResponse(@Path("pokemonId") pokemonId: String): Response<AbilityResponse>

    @GET("api/v2/ability/{url}")
    suspend fun getFlavorResponse(@Path("url") url: String): Response<FlavorResponse>
}
