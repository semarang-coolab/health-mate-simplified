package id.health.mate

import id.health.mate.data.source.remote.response.SuccessResponse
import id.health.mate.data.source.remote.response.model.get.Answers
import id.health.mate.data.source.remote.response.model.get.Data

object DummyData {

    val data = SuccessResponse(
        status = 200,
        message = "OK",
        data = listOf(
            Data(
                1, "choice", "How do you feel?",
                listOf(
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),

                    ),
            ),

            Data(
                1, "choice", "How do you feel?",
                listOf(
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),

                    ),
            ),

            Data(
                1, "choice", "How do you feel?",
                listOf(
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),

                    ),
            ),

            Data(
                1, "choice", "How do you feel?",
                listOf(
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),

                    ),
            ),

            Data(
                1, "essay", "How do you feel?",
                listOf(
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),
                    Answers(1, "Not Good"),

                    ),
            ),
        )
    )
}