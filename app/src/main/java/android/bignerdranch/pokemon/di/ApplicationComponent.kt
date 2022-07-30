package android.bignerdranch.pokemon.di

import android.app.Application
import android.bignerdranch.pokemon.presentation.AbilityFragment
import android.bignerdranch.pokemon.presentation.FlavorFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(fragment: AbilityFragment)

    fun inject(fragment: FlavorFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}