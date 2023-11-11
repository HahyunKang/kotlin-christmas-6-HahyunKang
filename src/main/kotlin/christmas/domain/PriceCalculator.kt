package christmas.domain

class PriceCalculator(val menu : List<MenuResult>) {

    private var orderPrice = 0

    init {
        calculatePrice()
    }

    fun calculatePrice(){
        menu.forEach {
            orderPrice += it.menu.price * it.orderCount
        }
    }

    fun getOrderedPrice() : Int {
        return orderPrice
    }

}