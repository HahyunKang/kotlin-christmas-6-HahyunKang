package christmas.domain

import christmas.data.MenuResult

class PriceCalculator(val menu : List<MenuResult>) {

    private var orderPrice = 0

    init {
        calculatePrice()
    }

    private fun calculatePrice(){
        menu.forEach {
            orderPrice += it.menu.price * it.orderCount
        }
    }

    fun getOrderedPrice() : Int {
        return orderPrice
    }

}