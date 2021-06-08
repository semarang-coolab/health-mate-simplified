package id.health.mate.presentation.home.choice

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.getColor
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import id.health.mate.R
import id.health.mate.R.color.card_answer_selected
import id.health.mate.data.source.remote.response.model.get.Answers
import id.health.mate.databinding.FragmentChoiceBinding
import id.health.mate.presentation.helper.delegate.viewBinding
import id.health.mate.presentation.helper.extension.add
import id.health.mate.presentation.helper.extension.removeFragment
import id.health.mate.presentation.helper.factory.ViewModelFactory
import id.health.mate.presentation.home.MainViewModel
import id.health.mate.presentation.home.essay.FragmentEssay

class FragmentChoice : Fragment(R.layout.fragment_choice) {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }

    private val viewModel by activityViewModels<MainViewModel> { ViewModelFactory.instance() }

    private val binding: FragmentChoiceBinding by viewBinding()

    private val stat = LinkedHashSet<CardView>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val currentPage = arguments?.getInt(EXTRA_DATA) ?: -1

        val pageSize = viewModel.dataChoice.size

        @SuppressLint("SetTextI18n")
        binding.tvQuestionPage.text = "$currentPage / $pageSize"

        val data = viewModel.getDataChoice(currentPage - 1)

        binding.tvQuestion.text = data.question

        setChoose(binding.tvChoose1, data.answers[0])
        setChoose(binding.tvChoose2, data.answers[1])
        setChoose(binding.tvChoose3, data.answers[2])
        setChoose(binding.tvChoose4, data.answers[3])

        binding.cvBack.setOnClickListener {
            if (currentPage > 1) {
                removeFragment()
            } else {
                requireActivity().supportFinishAfterTransition()
            }
        }

        binding.cvNext.setOnClickListener {
            if (isAnswerSelection(stat)) {
                if (currentPage != pageSize) {
                    nextChoice(currentPage)
                } else {
                    moveToEssay()
                }
            } else {
                Toast.makeText(it.context, "please select choose one", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ivClose.setOnClickListener {
            if (removeAnswerSelection(stat)) return@setOnClickListener

            if (currentPage > 1) {
                removeFragment()
            } else {
                requireActivity().supportFinishAfterTransition()
            }
        }
    }

    private fun removeAnswerSelection(stat: LinkedHashSet<CardView>): Boolean {
        stat.forEach {
            if (it.cardBackgroundColor.defaultColor != getColor(it.context, R.color.white)) {
                it.setCardBackgroundColor(getColor(it.context, R.color.white))
                return true
            }
        }
        return false
    }

    private fun moveToEssay() {
        add(R.id.container, FragmentEssay(), bundleOf(FragmentEssay.EXTRA_DATA to 1))
    }

    private fun nextChoice(currentPage: Int) = add(
        R.id.container,
        FragmentChoice(),
        bundleOf(EXTRA_DATA to currentPage.plus(1))
    )

    private fun isAnswerSelection(stat: LinkedHashSet<CardView>): Boolean {
        return stat.map {
            it.cardBackgroundColor.defaultColor == getColor(it.context, card_answer_selected)
        }.contains(true)
    }

    private fun <T : TextView> setChoose(view: T, answers: Answers) {
        view.text = answers.answer

        val cardView = (view.parent as CardView)

        stat.add(cardView)

        cardView.setOnClickListener {
            stat.forEach { card ->
                card.setCardBackgroundColor(getColor(card.context, R.color.white))
            }
            cardView.setCardBackgroundColor(getColor(it.context, card_answer_selected))

            viewModel.answers[arguments?.getInt(EXTRA_DATA)?.minus(1) ?: -1] = answers.id
        }
    }
}