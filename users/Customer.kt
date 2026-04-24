package users

class Customer(id: Int, name: String) : User(id, name) {
    override fun getRole(): String = "Customer"
}
