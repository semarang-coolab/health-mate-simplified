package id.health.mate.data.source.remote

import id.health.mate.data.source.remote.response.model.post.BodyPost
import id.health.mate.data.source.remote.service.Service
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RemoteDataSourceTest {

    private val service = Retrofit.create<Service>()

    private val remoteDataSource = RemoteDataSource(service)

    @Test
    fun getTests() = runBlocking {
        println(
            remoteDataSource.getTests().firstOrNull()
        )
    }

    @Test
    fun postTest() = runBlocking {
        val data = BodyPost(arrayOf(1, 2, 3, 4), "test test")
        println(remoteDataSource.postTest(data).firstOrNull())
    }
}