import models.Product
import orders.Order
import results.Result
import users.Customer

fun main() {
    val user = Customer(1, "Alice")

    val product1 = Product(1, "Book", 10.0)
    val product2 = Product(2, "Pen", 2.5)

    val order = Order(1, user, mutableListOf())

    order.addProduct(product1)
    order.addProduct(product2)

    println("User: ${user.name}, role: ${user.getRole()}")
    println("Total: ${order.getTotal()}")

    order.pay()
    println("Status after pay: ${order.status}")

    order.ship()
    println("Status after ship: ${order.status}")

    order.complete()
    println("Final status: ${order.status}")

    val result: Result = Result.Success("Order completed")
    when (result) {
        is Result.Success -> println(result.message)
        is Result.Error -> println(result.error)
    }
}
