package android.bignerdranch.pokemon.data.network.model.ability

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AbilityResponse(
    @SerializedName("abilities")
    @Expose
    val abilityList: List<AbilityContainer>
)