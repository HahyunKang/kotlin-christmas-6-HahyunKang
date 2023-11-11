package christmas.ui

import christmas.data.Menu
import christmas.data.OUTPUTSTRING
import christmas.domain.MenuResult

class EventScreen() {

    init {
        println(OUTPUTSTRING.BENEFITPREVIEW)
    }


    fun printOrderedMenu(menu:List<MenuResult>){
        menu.forEach {
            println("${it.menu.menuName} ${it.orderCount}개")
        }
    }

    fun printTotalPrice(totalPrice : Int) {
        println(OUTPUTSTRING.TOTALPRICE)
        println("${totalPrice}원")
    }

}