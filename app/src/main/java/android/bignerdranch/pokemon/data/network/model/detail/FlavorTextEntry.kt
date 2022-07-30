package android.bignerdranch.pokemon.data.network.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlavorTextEntry(
    @SerializedName("flavor_text")
    @Expose
    val flavor: String
)