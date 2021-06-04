package id.health.mate.data.source.remote.response.model.get

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id") val id: Int,
    @SerializedName("type") val type: String,
    @SerializedName("question") val question: String,
    @SerializedName("answers") val answers: List<Answers>
)