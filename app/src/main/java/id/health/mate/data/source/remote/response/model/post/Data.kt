package id.health.mate.data.source.remote.response.model.post

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id") val id: Int,
    @SerializedName("result") val result: String,
    @SerializedName("createdAt") val createdAt: String
)