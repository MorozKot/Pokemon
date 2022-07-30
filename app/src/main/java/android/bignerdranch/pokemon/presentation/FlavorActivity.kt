package android.bignerdranch.pokemon.presentation

import android.bignerdranch.pokemon.R
import android.bignerdranch.pokemon.databinding.ActivityFlavorBinding
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FlavorActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFlavorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (!intent.hasExtra(EXTRA_URL)) {
            finish()
            return
        }
        val url = intent.getStringExtra(EXTRA_URL) ?: EMPTY_URL
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FlavorFragment.newInstance(url))
                .commit()
        }
    }

    companion object {
        private const val EXTRA_URL = "url"
        private const val EMPTY_URL = ""

        fun newIntent(context: Context, url: String): Intent {
            val intent = Intent(context, FlavorActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            return intent
        }
    }
}
