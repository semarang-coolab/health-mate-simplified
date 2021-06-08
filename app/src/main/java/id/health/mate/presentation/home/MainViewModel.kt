package id.health.mate.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import id.health.mate.data.Repository
import id.health.mate.data.source.remote.response.model.get.Data
import id.health.mate.data.source.remote.response.model.post.BodyPost
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextUInt

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val essayAnswer = StringBuilder()

    private val refresh = MutableStateFlow(0u)

    val dataChoice = HashSet<Data>()

    val dataEssay = HashSet<Data>()

    val answers = Array(4) { 0 }

    val submit by lazy {
        repository.postTest(
            BodyPost(answers, essayAnswer.toString())
        ).asLiveData()
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    val data = refresh.flatMapLatest {
        repository.getTest()
    }.asLiveData(viewModelScope.coroutineContext)

    fun getDataChoice(i: Int): Data {
        dataChoice.forEachIndexed { index, data ->
            if (i == index) return data
        }
        return Data(0, "choice", "---", listOf())
    }

    fun getDataEssay(i: Int): Data {
        dataEssay.forEachIndexed { index, data ->
            if (i == index) return data
        }
        return Data(0, "essay", "---", listOf())
    }

    fun setData(data: Data) {
        if (data.type == "choice") {
            dataChoice.add(data)
        } else if (data.type == "essay") {
            dataEssay.add(data)
        }
    }

    fun setEssayAnswer(str: String?) {
        essayAnswer.replace(0, essayAnswer.length, str ?: "---")
    }

    fun refreshData() {
        viewModelScope.launch { refresh.tryEmit(Random.nextUInt()) }
    }
}