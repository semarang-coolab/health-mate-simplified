package id.health.mate.presentation.home.essay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import id.health.mate.R
import id.health.mate.databinding.FragmentEssayBinding
import id.health.mate.presentation.helper.delegate.viewBinding
import id.health.mate.presentation.helper.extension.add
import id.health.mate.presentation.helper.extension.removeFragment
import id.health.mate.presentation.helper.factory.ViewModelFactory
import id.health.mate.presentation.home.MainViewModel
import id.health.mate.presentation.home.result.FragmentResult

class FragmentEssay : Fragment(R.layout.fragment_essay) {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA_FRAGMENT_ESSAY"
    }

    private val binding: FragmentEssayBinding by viewBinding()

    private val viewModel by activityViewModels<MainViewModel> { ViewModelFactory.getInstance() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val currentPage = arguments?.getInt(EXTRA_DATA) ?: -1

        val pageSize = viewModel.dataEssay.size

        @SuppressLint("SetTextI18n")
        binding.tvQuestionPage.text = "$currentPage / $pageSize"

        val data = viewModel.getDataChoice(currentPage - 1)

        binding.tvQuestion.text = data.question

        binding.cvEssayAnswer.setOnClickListener {
            requestFocus(binding.etEssayAnswer)
        }

        binding.ivClose.setOnClickListener { removeFragment() }

        binding.cvDone.setOnClickListener {
            viewModel.setEssayAnswer("${binding.etEssayAnswer.text}")
            showResult()
        }
    }

    private fun showResult() {
        add(R.id.container, FragmentResult())
    }

    private fun requestFocus(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(requireContext(), InputMethodManager::class.java)
            imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}