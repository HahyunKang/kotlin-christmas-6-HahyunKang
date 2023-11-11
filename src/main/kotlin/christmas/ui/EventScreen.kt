package christmas.ui

import christmas.data.*
import christmas.domain.MenuResult
import java.text.DecimalFormat

class EventScreen(date: Int) {
    val dec = DecimalFormat("#,###")
    init {
        println(OUTPUTSTRING.BENEFITPREVIEW.format(date))
    }


    fun printOrderedMenu(menu:List<MenuResult>){
        println(OUTPUTSTRING.ORDEREDMENU)
        menu.forEach {
            println("${it.menu.menuName} ${it.orderCount}개")
        }
    }

    fun printTotalPrice(totalPrice : Int) {
        println(OUTPUTSTRING.TOTALPRICE)
        println("${dec.format(totalPrice)}원")
    }

    fun printGiftMenu(isGift : Boolean){
        println(OUTPUTSTRING.GIFTMENU)
        if(isGift) println(ConstString.CHAMPAGNE)
        else println(ConstString.NONE)
    }

    fun printDiscounts(eventDiscount: List<EventDiscount>){
        println(OUTPUTSTRING.BENEFITLIST)
        if(eventDiscount.isEmpty()) println(ConstString.NONE)
        else eventDiscount.forEach {
            println("${it.eventName}: ${dec.format(it.eventDiscount)}원")
        }
    }

    fun printTotalDiscount(totalDiscount : Int){
        println(OUTPUTSTRING.TOTALBENEFIT)
        println("${dec.format(totalDiscount)}원")
    }

    fun printAmountAfterDiscount(amount:Int){
        println(OUTPUTSTRING.AMOUNTAFTERDISCOUNT)
        println("${dec.format(amount)}원")
    }

    fun printBadge(badge: Badge){
        println(OUTPUTSTRING.EVENTBADGE)
        println(badge.badgeName)
    }

}