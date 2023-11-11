package christmas.domain

import christmas.data.CONSTNUM
import christmas.data.Category

class SpecialEventHandler {



    private var discount = 0

    init {
        calculateDiscount()
    }


    fun calculateDiscount(){
        discount = CONSTNUM.SPECIALEVENTDEFAULT
    }

    fun getDiscount() : Int {
        return discount
    }



}