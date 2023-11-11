package christmas.domain

class EventController {

    private var date = 0
    private var menu = ""
    private var orderMenus = listOf<MenuResult>()


    init {
        orderMenu()
        handleMenu()
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



}