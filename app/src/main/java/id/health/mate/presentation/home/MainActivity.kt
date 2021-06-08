package id.health.mate.presentation.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import id.health.mate.R
import id.health.mate.data.source.remote.response.helper.ApiResponse
import id.health.mate.databinding.ActivityMainBinding
import id.health.mate.presentation.helper.factory.ViewModelFactory
import id.health.mate.presentation.helper.viewBinding
import id.health.mate.presentation.home.choice.FragmentChoice

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val viewModel by viewModels<MainViewModel> { ViewModelFactory.instance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        viewModel.data.observe(this) {
            when (it) {
                is ApiResponse.Success -> {
                    it.data.data.forEach(viewModel::setData)
                    addFragmentChoice()
                }

                is ApiResponse.Error -> {
                    val message = StringBuilder(it.apiError?.message.toString())
                    it.apiError?.errors?.forEach { str ->
                        message.append("\n $str")
                    }
                    setError(message.toString())
                }
            }
            binding.progressBar.isVisible = false
        }
    }

    private fun addFragmentChoice(page: Int = 1) {
        FragmentChoice().apply {
            arguments = bundleOf(FragmentChoice.EXTRA_DATA to page)
            supportFragmentManager.beginTransaction()
                .add(R.id.container, this)
                .commit()
        }
    }

    private fun setError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        binding.btnRefresh.isVisible = true
        binding.btnRefresh.setOnClickListener { btnRefresh ->
            btnRefresh.isVisible = false
            binding.progressBar.isVisible = true
            viewModel.refreshData()
        }
    }
}