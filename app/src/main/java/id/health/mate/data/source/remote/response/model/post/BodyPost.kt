package id.health.mate.data.source.remote.response.model.post

import com.google.gson.JsonArray
import com.google.gson.JsonObject

class BodyPost(private val multipleChoiceAnswers: Array<Int>, private val essayAnswer: String) {

    companion object {
        private const val MULTIPLE_CHOICE_ANSWER = "multipleChoiceAnswers"
        private const val ESSAY_ANSWER = "essayAnswer"
    }

    fun get(): JsonObject {
        val jsonObject = JsonObject()

        val multipleChoiceAnswers = JsonArray()
        this.multipleChoiceAnswers.forEach {
            multipleChoiceAnswers.add(it)
        }
        jsonObject.add(MULTIPLE_CHOICE_ANSWER, multipleChoiceAnswers)
        jsonObject.addProperty(ESSAY_ANSWER, essayAnswer)

        return jsonObject
    }
}