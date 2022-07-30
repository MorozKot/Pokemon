package android.bignerdranch.pokemon.presentation.viewmodel

import android.bignerdranch.pokemon.data.network.model.ability.AbilityContainer
import android.bignerdranch.pokemon.data.network.model.detail.FlavorTextEntry
import android.bignerdranch.pokemon.domain.LoadAbilityUseCase
import android.bignerdranch.pokemon.domain.LoadFlavorUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    private val loadAbilityUseCase: LoadAbilityUseCase,
    private val loadFlavorUseCase: LoadFlavorUseCase
) : ViewModel() {

    private val _getPokemonResponse: MutableLiveData<List<AbilityContainer>?> =
        MutableLiveData(null)
    val getPokemonResponse: LiveData<List<AbilityContainer>?> = _getPokemonResponse

    fun getPokemonAbilities(pokemonId: String) {
        viewModelScope.launch {
            val result = loadAbilityUseCase.getAbilityList(pokemonId)
            _getPokemonResponse.value = result
        }
    }

    private val _flavorDetailLiveData = MutableLiveData<List<FlavorTextEntry>?>()
    val flavorDetailLiveData: LiveData<List<FlavorTextEntry>?> = _flavorDetailLiveData

    fun getFlavorDetail(url: String) {
        viewModelScope.launch {
            val result = loadFlavorUseCase.getFlavor(url)
            _flavorDetailLiveData.value = result
        }
    }
}