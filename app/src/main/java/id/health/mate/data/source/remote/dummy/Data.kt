package id.health.mate.data.source.remote.dummy

import id.health.mate.data.source.remote.response.ErrorResponse
import id.health.mate.data.source.remote.response.SuccessResponse
import id.health.mate.data.source.remote.response.model.get.Answers
import id.health.mate.data.source.remote.response.model.get.Data

object Data {

    val getResponseSuccess = SuccessResponse(
        status = 200,
        message = "OK",
        data = listOf(
            Data(
                1, "choice", "How do you feel?",
                listOf(
                    Answers(1, "Not Good"),
                    Answers(2, "Great"),
                    Answers(3, "IDK"),
                    Answers(4, "Feeling good. Like a should~"),

                    ),
            ),

            Data(
                2, "choice", "y g?",
                listOf(
                    Answers(5, "y"),
                    Answers(6, "g"),
                    Answers(7, "?"),
                    Answers(8, "apasih"),

                    ),
            ),

            Data(
                3, "choice", "1 + 1 = 5?",
                listOf(
                    Answers(9, "Nah"),
                    Answers(10, "Absolutely"),
                    Answers(11, "1 + 1 = 24"),
                    Answers(12, "IDK i can't count"),

                    ),
            ),

            Data(
                4, "choice", "What is the shape of earth?",
                listOf(
                    Answers(13, "triangle"),
                    Answers(14, "cube"),
                    Answers(15, "spiral"),
                    Answers(16, "hexagon"),

                    ),
            ),

            Data(
                5, "essay", "What you're feeling today?",
                listOf(),
            ),
        )
    )

    val getResponseError = ErrorResponse(
        status = 500,
        message = "Error",
        errors = listOf("Server error, try again later.")
    )

    val postSuccess = SuccessResponse(
        status = 201,
        message = "Created",
        data = id.health.mate.data.source.remote.response.model.post.Data(
            1, "Certified pengangguran", "2021-05-20T06:25:44.678655153+07:00"
        )
    )

    val postInvalidResponse = ErrorResponse(
        status = 500,
        message = "Invalid",
        errors = listOf("Missing some answers", "Essay answer is too short")
    )

    val postErrorResponse = ErrorResponse(
        status = 500,
        message = "Error",
        errors = listOf("Server error, try again later.")
    )
}