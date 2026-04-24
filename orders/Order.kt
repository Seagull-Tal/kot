package orders

import models.Product
import users.User

class Order(
    val id: Int,
    val user: User,
    private val products: MutableList<Product>
) : Payable {

    var status: OrderStatus = OrderStatus.CREATED
        private set

    var state: OrderState = OrderState.Created
        private set

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun getTotal(): Double {
        return products.sumOf { it.price }
    }

    override fun pay() {
        if (status == OrderStatus.CREATED) {
            status = OrderStatus.PAID
            state = OrderState.Paid
        }
    }

    fun ship() {
        if (status == OrderStatus.PAID) {
            status = OrderStatus.SHIPPED
            state = OrderState.Shipped
        }
    }

    fun complete() {
        if (status == OrderStatus.SHIPPED) {
            status = OrderStatus.COMPLETED
            state = OrderState.Completed
        }
    }
}
