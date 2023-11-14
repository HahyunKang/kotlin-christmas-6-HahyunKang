package christmas.domain

import christmas.data.CONSTNUM
import christmas.data.Category
import christmas.data.MenuResult

class WeekDaysEventHandler(val orderMenu : List<MenuResult>) {

    private var discount = 0

    init {
        calculateDiscount()
    }


    private fun calculateDiscount(){
        orderMenu.forEach {
            if(it.menu.category == Category.Dessert) discount += CONSTNUM.DOWDISCOUNT
        }
    }

    fun getDiscount() : Int {
        return discount
    }


}