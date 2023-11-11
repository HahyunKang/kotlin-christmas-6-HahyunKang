package christmas.domain

class EventController {

    private var date = 0
    private var menu = ""
    private var orderMenus = listOf<MenuResult>()
    private var orderedPrice = 0


    init {
        orderMenu()
        handleMenu()
        calculatePrice()
    }


    fun orderMenu(){
        val customer = Customer()
        date = customer.getVisitDate()
        menu = customer.getMenu()
    }

    fun handleMenu(){
        val menuHandler = MenuHandler(menu)
        orderMenus = menuHandler.getOrderMenus()
        orderMenus.forEach {
            println("${it.menu} ${it.orderCount}")
        }
    }

    fun calculatePrice(){
        val priceCalculator = PriceCalculator(orderMenus)
        orderedPrice = priceCalculator.getOrderedPrice()
        println(orderedPrice)
    }



}