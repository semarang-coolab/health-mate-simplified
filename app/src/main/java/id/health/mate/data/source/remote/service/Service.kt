package id.health.mate.data.source.remote.service

import com.google.gson.JsonObject
import id.health.mate.data.source.remote.response.SuccessResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

    @GET("api/tests")
    suspend fun getTest(): SuccessResponse<List<id.health.mate.data.source.remote.response.model.get.Data>>

    @POST("api/tests")
    suspend fun postTest(@Body body: JsonObject): SuccessResponse<id.health.mate.data.source.remote.response.model.post.Data>
}