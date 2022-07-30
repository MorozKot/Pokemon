package android.bignerdranch.pokemon.data.network.model.ability

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AbilityContainer(
    @SerializedName("ability")
    @Expose
    val ability: AbilityNameUrl
)