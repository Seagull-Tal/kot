package results

sealed class Result {
    data class Success(val message: String) : Result()
    data class Error(val error: String) : Result()
}
