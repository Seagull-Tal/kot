package users

abstract class User(
    val id: Int,
    val name: String
) {
    abstract fun getRole(): String
}
