package id.health.mate.data.source.remote.response

data class ErrorResponse(
    val status: Int,
    val message: String,
    val errors: List<String> = listOf()
)