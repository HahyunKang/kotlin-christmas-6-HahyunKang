package christmas.domain

import christmas.data.CONSTNUM

class GiftEventHandler {

    private var discount = 0

    init {
        calculateDiscount()
    }
    private fun calculateDiscount() {
        discount = CONSTNUM.CHAMPAGNEPRICE
    }

    fun getDiscount(): Int {
        return discount

    }
}