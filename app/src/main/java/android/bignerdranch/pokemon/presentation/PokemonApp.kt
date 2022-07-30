package android.bignerdranch.pokemon.presentation

import android.app.Application
import android.bignerdranch.pokemon.di.DaggerApplicationComponent

class PokemonApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}