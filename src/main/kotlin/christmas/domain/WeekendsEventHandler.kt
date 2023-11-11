package christmas.domain

import christmas.data.CONSTNUM
import christmas.data.Category

class WeekendsEventHandler(val orderMenu : List<MenuResult>) {

    private var discount = 0


    init {
        calculateDiscount()
    }
    fun calculateDiscount(){
        orderMenu.forEach {
            if(it.menu.category == Category.Main) discount += CONSTNUM.DOWDISCOUNT
        }
    }

    fun getDiscount() : Int {
        return discount
    }


}