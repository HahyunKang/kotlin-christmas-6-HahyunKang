package christmas.domain

import christmas.data.CONSTNUM

class ChristmasEventHandler(val date: Int) {

    private var discount = CONSTNUM.CHRISTMASEVENTDEFAULT

    init {
        calculateDiscount()
    }
    private fun calculateDiscount() {
        discount += 100 * (date - 1)
    }

    fun getDiscount(): Int {
        return discount

    }
}