package christmas.domain

import christmas.data.CONSTNUM

class SpecialEventHandler {
    private var discount = 0

    init {
        calculateDiscount()
    }
    private fun calculateDiscount(){
        discount = CONSTNUM.SPECIALEVENTDEFAULT
    }
    fun getDiscount() : Int {
        return discount
    }

}