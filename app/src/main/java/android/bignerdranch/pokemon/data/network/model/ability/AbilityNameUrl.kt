package android.bignerdranch.pokemon.data.network.model.ability

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AbilityNameUrl(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("url")
    @Expose
    val url: String
)