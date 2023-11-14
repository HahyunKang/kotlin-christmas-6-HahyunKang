package christmas.domain

import christmas.data.*
import christmas.ui.EventScreen

class EventController {

    private var date = 0
    private var menu = ""
    private var orderMenus = listOf<MenuResult>()
    private var totalPrice = 0
    private var finalDiscount = 0
    private var realDiscount = 0
    private var eventDiscount = emptyList<EventDiscount>()
    private var isChampagne = false
    private var badge = Badge.NONE

    fun startEvent(){
        println(ConstString.FIRST_MESSAGE)
        orderMenu()
        calculatePrice()
        handleEvent()
        printOutput()
    }

    private fun orderMenu(){
        val customer = Customer()
        date = customer.getVisitDate()
        menu = customer.getMenu()
        orderMenus = customer.getOrderMenus()
    }

    private fun calculatePrice(){
        val priceCalculator = PriceCalculator(orderMenus)
        totalPrice = priceCalculator.getOrderedPrice()
    }

    private fun handleEvent(){
        val eventHandler = EventHandler(date,orderMenus,totalPrice)
        finalDiscount = eventHandler.getFinalDiscount()
        eventDiscount = eventHandler.getEachEvenDiscount()
        realDiscount = eventHandler.getRealDiscount()
        val checkGiftEvent = CheckEvent(date).checkGiftEvent(totalPrice)
        if(checkGiftEvent)isChampagne =  true
        badge = eventHandler.getBadge()
    }

    private fun printOutput(){
        val eventScreen = EventScreen(date)
        eventScreen.printOrderedMenu(orderMenus)
        eventScreen.printTotalPrice(totalPrice)
        eventScreen.printGiftMenu(isChampagne)
        eventScreen.printDiscounts(eventDiscount)
        eventScreen.printTotalDiscount(finalDiscount)
        eventScreen.printAmountAfterDiscount(totalPrice+realDiscount)
        eventScreen.printBadge(badge)
    }
}