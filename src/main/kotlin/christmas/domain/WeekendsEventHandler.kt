package christmas.domain

import christmas.data.CONSTNUM
import christmas.data.Category
import christmas.data.MenuResult

class WeekendsEventHandler(private val orderMenu : List<MenuResult>) {

    private var discount = 0


    init {
        calculateDiscount()
    }
    private fun calculateDiscount(){
        orderMenu.forEach {
            if(it.menu.category == Category.Main) discount += CONSTNUM.DOWDISCOUNT * it.orderCount
        }
    }

    fun getDiscount() : Int {
        return discount
    }


}