package id.health.mate.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SuccessResponse<T>(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: T
)