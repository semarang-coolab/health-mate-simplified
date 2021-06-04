package id.health.mate.presentation.home.result

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import id.health.mate.R
import id.health.mate.data.source.remote.response.helper.ApiResponse
import id.health.mate.databinding.FragmentResultBinding
import id.health.mate.presentation.helper.delegate.viewBinding
import id.health.mate.presentation.helper.factory.ViewModelFactory
import id.health.mate.presentation.home.MainActivity
import id.health.mate.presentation.home.MainViewModel

class FragmentResult : Fragment(R.layout.fragment_result) {

    private val binding: FragmentResultBinding by viewBinding()

    private val viewModel by activityViewModels<MainViewModel> { ViewModelFactory.getInstance() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.submit.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResponse.Success -> binding.tvResult.text = it.data.result

                is ApiResponse.Error -> it.apiError?.errors?.forEach { str ->
                    @SuppressLint("SetTextI18n")
                    binding.tvResult.text = "${binding.tvResult.text} $str"
                }
            }
            binding.progressBar.isVisible = false
        }

        binding.cvBackToHome.setOnClickListener(this::moveToHome)
    }

    private fun moveToHome(view: View) {
        requireActivity().apply {
            startActivityFromFragment(
                this@FragmentResult, Intent(view.context, MainActivity::class.java), 1
            )
            overridePendingTransition(0, 0)
            finish()
        }
    }
}