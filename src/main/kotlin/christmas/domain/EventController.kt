package christmas.domain

class EventController {

    private var date = 0
    private var menu = ""
    private var orderMenus = listOf<MenuResult>()
    private var totalPrice = 0
    private var finalDiscount = 0



    init {
        orderMenu()
        handleMenu()
        calculatePrice()
        handleEvent()
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
        totalPrice = priceCalculator.getOrderedPrice()
        println("총 주문 금액")
        println(totalPrice)
    }

    fun handleEvent(){
        val eventHandler = EventHandler(date,orderMenus,totalPrice)
        finalDiscount = eventHandler.getFinalDiscount()
        println("할인된 금액")
        println(finalDiscount)
    }



}