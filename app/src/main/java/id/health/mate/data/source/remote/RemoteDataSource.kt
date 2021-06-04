package id.health.mate.data.source.remote

import id.health.mate.data.source.remote.Retrofit.errorConverter
import id.health.mate.data.source.remote.response.ErrorResponse
import id.health.mate.data.source.remote.response.helper.ApiResponse.Error
import id.health.mate.data.source.remote.response.helper.ApiResponse.Success
import id.health.mate.data.source.remote.response.model.post.BodyPost
import id.health.mate.data.source.remote.service.Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@Suppress("BlockingMethodInNonBlockingContext", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class RemoteDataSource(private val service: Service) {

    fun getTests() = flow {
        val result = try {
            Success(service.getTest())
        } catch (err: Throwable) {
            val errResult = when (this) {
                is retrofit2.HttpException -> errorConverter<ErrorResponse>()
                    .convert(this.response()?.errorBody())
                else -> ErrorResponse(status = 502, err.message.toString())
            }; Error(errResult)
        }; emit(result)
    }.flowOn(Dispatchers.IO)

    fun postTest(bodyPost: BodyPost) = flow {
        val result = try {
            val res = service.postTest(bodyPost.get())
            Success(res.data)
        } catch (err: Throwable) {
            val resError = when (err) {
                is retrofit2.HttpException -> errorConverter<ErrorResponse>()
                    .convert(err.response()?.errorBody())
                else -> ErrorResponse(status = 502, err.message.toString())
            }; Error(resError)
        }; emit(result)
    }.flowOn(Dispatchers.IO)
}