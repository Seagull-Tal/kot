package orders

sealed class OrderState {
    object Created : OrderState()
    object Paid : OrderState()
    object Shipped : OrderState()
    object Completed : OrderState()
}
