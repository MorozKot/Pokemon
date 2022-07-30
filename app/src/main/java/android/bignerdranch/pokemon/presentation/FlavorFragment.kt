package android.bignerdranch.pokemon.presentation

import android.bignerdranch.pokemon.databinding.FragmentFlavorBinding
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

class FlavorFragment : Fragment() {

    private lateinit var viewModel: PokemonViewModel

    @Inject
    lateinit var viewModelFactory: PokemonViewModelFactory

    private var _binding: FragmentFlavorBinding? = null
    private val binding: FragmentFlavorBinding
        get() = _binding ?: throw RuntimeException("DetailFragment is null")

    private val component by lazy {
        (requireActivity().application as PokemonApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlavorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = getUrl()
        viewModel = ViewModelProvider(this, viewModelFactory)[PokemonViewModel::class.java]

        viewModel.getFlavorDetail(url)

        viewModel.flavorDetailLiveData.observe(viewLifecycleOwner) {
            it?.get(1)?.let {
                with(binding) {
                    tvFlavor.text = it.flavor
                }
            }
        }
    }

    private fun getUrl(): String {
        return requireArguments().getString(EXTRA_URL, EMPTY_URL)
    }

    companion object {
        private const val EXTRA_URL = "url"
        private const val EMPTY_URL = ""

        fun newInstance(url: String): Fragment {
            return FlavorFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_URL, url)
                }
            }
        }
    }
}
