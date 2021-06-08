package id.health.mate.data

import id.health.mate.data.source.remote.RemoteDataSource
import id.health.mate.data.source.remote.Retrofit
import id.health.mate.data.source.remote.response.model.post.BodyPost

class Repository private constructor(private val remoteDataSource: RemoteDataSource) {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(): Repository {
            synchronized(Repository::class) {
                if (instance == null) instance = Repository(RemoteDataSource(Retrofit.create()))
            }
            return instance as Repository
        }
    }

    fun getTest() = remoteDataSource.getTests()

    fun postTest(bodyPost: BodyPost) = remoteDataSource.postTest(bodyPost)

}