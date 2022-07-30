package android.bignerdranch.pokemon.data.network.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlavorResponse(
    @SerializedName("flavor_text_entries")
    @Expose
    val flavorList: List<FlavorTextEntry>
)