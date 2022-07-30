package android.bignerdranch.pokemon.di

import android.bignerdranch.pokemon.presentation.viewmodel.PokemonViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonViewModel::class)
    fun bindExampleViewModel(impl: PokemonViewModel): ViewModel
}
