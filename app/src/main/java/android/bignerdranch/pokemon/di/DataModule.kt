package android.bignerdranch.pokemon.di

import android.bignerdranch.pokemon.domain.PokemonRepository
import android.bignerdranch.pokemon.domain.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindAbilityRepository(impl: PokemonRepositoryImpl): PokemonRepository
}