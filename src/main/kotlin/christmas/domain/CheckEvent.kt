package christmas.domain

import christmas.data.CONSTNUM

class CheckEvent(private val date: Int) {

    private val weekends = listOf(1,2,8,9,15,16,22,23,29,30)
    private val specialDays= listOf(3,10,17,24,25,31)

    fun checkIsEventApply(totalPrice : Int) : Boolean {
        return totalPrice >= CONSTNUM.EVENCRITERIA
    }

    fun checkChristmasEvent() : Boolean{
        return date <= CONSTNUM.CHRISTMAS
    }

    fun checkWeekDaysEvent() : Boolean{
        return !weekends.contains(date)
    }
    fun checkWeekendsEvent() : Boolean{
        return weekends.contains(date)
    }

    fun checkSpecialEvent() : Boolean{
        return specialDays.contains(date)
    }

    fun checkGiftEvent(totalPrice:Int) : Boolean{
        return totalPrice >= CONSTNUM.GIFTEVENTCRITERIA
    }

}