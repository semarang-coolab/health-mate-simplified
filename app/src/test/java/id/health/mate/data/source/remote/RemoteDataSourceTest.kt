package id.health.mate.data.source.remote

import com.google.gson.JsonObject
import id.health.mate.data.source.remote.response.model.post.BodyPost
import id.health.mate.data.source.remote.service.Service
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
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
        val data = JSONObject(
            """
                {
                    "status": 200,
                    "message": "OK",
                    "data": [
                        {
                            "id": 1,
                            "type": "choice",
                            "question": "How do you feel?",
                            "answers": [
                                {
                                    "id": 1,
                                    "answer": "Not good"
                                },
                                {
                                    "id": 2,
                                    "answer": "Great"
                                },
                                {
                                    "id": 3,
                                    "answer": "IDK"
                                },
                                {
                                    "id": 4,
                                    "answer": "Feeling good. Like a should~"
                                }
                            ]
                        },
                        {
                            "id": 2,
                            "type": "choice",
                            "question": "y g?",
                            "answers": [
                                {
                                    "id": 5,
                                    "answer": "y"
                                },
                                {
                                    "id": 6,
                                    "answer": "g"
                                },
                                {
                                    "id": 7,
                                    "answer": "?"
                                },
                                {
                                    "id": 8,
                                    "answer": "apasih"
                                }
                            ]
                        },
                        {
                            "id": 3,
                            "type": "choice",
                            "question": "1 + 1 = 5?",
                            "answers": [
                                {
                                    "id": 9,
                                    "answer": "Nah"
                                },
                                {
                                    "id": 10,
                                    "answer": "Absolutely!"
                                },
                                {
                                    "id": 11,
                                    "answer": "1 + 1 = 24"
                                },
                                {
                                    "id": 12,
                                    "answer": "IDK i can't count"
                                }
                            ]
                        },
                        {
                            "id": 4,
                            "type": "choice",
                            "question": "What is the shape of earth?",
                            "answers": [
                                {
                                    "id": 13,
                                    "answer": "triangle"
                                },
                                {
                                    "id": 14,
                                    "answer": "cube"
                                },
                                {
                                    "id": 15,
                                    "answer": "spiral"
                                },
                                {
                                    "id": 16,
                                    "answer": "hexagon"
                                }
                            ]
                        },
                        {
                            "id": 5,
                            "type": "essay",
                            "question": "What you're feeling today?",
                            "answers": []
                        }
                    ]
                }
            """.trimIndent()
        )
//        val data = BodyPost(arrayOf(1, 2, 3, 4), "test test")
//        println(remoteDataSource.postTest(data).firstOrNull())

        println(data)
    }


    @Test
    fun test(){
        val data = JSONObject(
            """
                {
                    "status": 200,
                    "message": "OK",
                    "data": [
                        {
                            "id": 1,
                            "type": "choice",
                            "question": "How do you feel?",
                            "answers": [
                                {
                                    "id": 1,
                                    "answer": "Not good"
                                },
                                {
                                    "id": 2,
                                    "answer": "Great"
                                },
                                {
                                    "id": 3,
                                    "answer": "IDK"
                                },
                                {
                                    "id": 4,
                                    "answer": "Feeling good. Like a should~"
                                }
                            ]
                        },
                        {
                            "id": 2,
                            "type": "choice",
                            "question": "y g?",
                            "answers": [
                                {
                                    "id": 5,
                                    "answer": "y"
                                },
                                {
                                    "id": 6,
                                    "answer": "g"
                                },
                                {
                                    "id": 7,
                                    "answer": "?"
                                },
                                {
                                    "id": 8,
                                    "answer": "apasih"
                                }
                            ]
                        },
                        {
                            "id": 3,
                            "type": "choice",
                            "question": "1 + 1 = 5?",
                            "answers": [
                                {
                                    "id": 9,
                                    "answer": "Nah"
                                },
                                {
                                    "id": 10,
                                    "answer": "Absolutely!"
                                },
                                {
                                    "id": 11,
                                    "answer": "1 + 1 = 24"
                                },
                                {
                                    "id": 12,
                                    "answer": "IDK i can't count"
                                }
                            ]
                        },
                        {
                            "id": 4,
                            "type": "choice",
                            "question": "What is the shape of earth?",
                            "answers": [
                                {
                                    "id": 13,
                                    "answer": "triangle"
                                },
                                {
                                    "id": 14,
                                    "answer": "cube"
                                },
                                {
                                    "id": 15,
                                    "answer": "spiral"
                                },
                                {
                                    "id": 16,
                                    "answer": "hexagon"
                                }
                            ]
                        },
                        {
                            "id": 5,
                            "type": "essay",
                            "question": "What you're feeling today?",
                            "answers": []
                        }
                    ]
                }
            """.trimIndent()
        )
//        val data = BodyPost(arrayOf(1, 2, 3, 4), "test test")
//        println(remoteDataSource.postTest(data).firstOrNull())

        println(data)
    }
}