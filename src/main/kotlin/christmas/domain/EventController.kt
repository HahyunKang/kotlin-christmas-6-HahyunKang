package christmas.domain

import christmas.data.Badge
import christmas.data.ConstString
import christmas.data.EventDiscount
import christmas.data.EventResult
import christmas.ui.EventScreen
import net.bytebuddy.dynamic.scaffold.TypeInitializer.None

class EventController {

    private var date = 0
    private var menu = ""
    private var orderMenus = listOf<MenuResult>()
    private var totalPrice = 0
    private var finalDiscount = 0
    private var realDiscount = 0
    private var eventResult = EventResult()
    private var eventDiscount = emptyList<EventDiscount>()
    private var isChampagne = false
    private var badgeName = Badge.NONE



    init {
        println(ConstString.FIRST_MESSAGE)
        orderMenu()
        handleMenu()
        calculatePrice()
        handleEvent()
        getBadge()
        printOutput()
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
            println("${it.menu.menuName} ${it.orderCount}")
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
        eventDiscount = eventHandler.getEachEvenDiscount()
        realDiscount = eventHandler.getRealDiscount()
        val checkGiftEvent = CheckEvent(date).checkGiftEvent(totalPrice)
        if(checkGiftEvent)isChampagne =  true
        println("할인된 금액")
        println(finalDiscount)
    }

    fun getBadge(){
        val badgeHandler = BadgeHandler(totalPrice)
        val badge = badgeHandler.getBadge()
        badgeName = badge
    }


    fun printOutput(){
        val eventScreen = EventScreen(date)
        eventScreen.printOrderedMenu(orderMenus)
        eventScreen.printTotalPrice(totalPrice)
        eventScreen.printGiftMenu(isChampagne)
        eventScreen.printDiscounts(eventDiscount)
        eventScreen.printTotalDiscount(finalDiscount)
        eventScreen.printAmountAfterDiscount(totalPrice+realDiscount)
        eventScreen.printBadge(badgeName)
    }











}