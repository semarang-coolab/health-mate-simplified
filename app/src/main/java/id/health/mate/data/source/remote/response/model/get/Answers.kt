package id.health.mate.data.source.remote.response.model.get

import com.google.gson.annotations.SerializedName

data class Answers(
    @SerializedName("id") val id: Int,
    @SerializedName("answer") val answer: String
)