package android.bignerdranch.pokemon.presentation

import android.bignerdranch.pokemon.data.network.model.ability.AbilityNameUrl
import android.bignerdranch.pokemon.databinding.FragmentAbilityBinding
import android.bignerdranch.pokemon.presentation.adapter.RecyclerViewAdapter
import android.bignerdranch.pokemon.presentation.viewmodel.PokemonViewModel
import android.bignerdranch.pokemon.presentation.viewmodel.PokemonViewModelFactory
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


class AbilityFragment(val pokemonId: String) : Fragment() {
    private val component by lazy {
        (requireActivity().application as PokemonApp).component
    }

    @Inject
    lateinit var viewModelFactory: PokemonViewModelFactory

    private lateinit var viewModel: PokemonViewModel

    lateinit var binding: FragmentAbilityBinding

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAbilityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerViewAdapter()

        binding.recyclerViewAnimals.adapter = adapter

        viewModel = ViewModelProvider(this, viewModelFactory)[PokemonViewModel::class.java]

        viewModel.getPokemonAbilities(pokemonId)

        viewModel.getPokemonResponse.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        adapter.onAbilityClickListener = object : RecyclerViewAdapter.OnAbilityClickListener {
            override fun onAbilityClick(abilityNameUrl: AbilityNameUrl) {
                val longUrl = abilityNameUrl.url
                val cutNumberFromUrl = longUrl.substringAfter("https://pokeapi.co/api/v2/ability/")
                launchDetailActivity(cutNumberFromUrl)
            }
        }
    }

    private fun launchDetailActivity(url: String) {
        val intent = FlavorActivity.newIntent(
            requireContext(),
            url
        )
        startActivity(intent)
    }
}