package christmas.domain

import christmas.data.CONSTNUM

class CheckEvent(val date: Int) {


    fun checkChristmasEvent() : Boolean{
        if(date <= CONSTNUM.CHRISTMAS) return true

        return false
    }

    fun checkWeekDaysEvent() : Boolean{
        val weekends = listOf(1,2,8,9,15,16,22,23,29,30)
        return weekends.contains(date)
    }
    fun checkWeekendsEvent() : Boolean{
        val weekends = listOf(1,2,8,9,15,16,22,23,29,30)
        return !weekends.contains(date)
    }

    fun checkSpecialEvent() : Boolean{
        val specialDays= listOf(3,10,17,24,25,31)
        return specialDays.contains(date)
    }

    fun checkGiftEvent(totalPrice:Int) : Boolean{
        return totalPrice >= CONSTNUM.GIFTEVENTCRITERIA
    }



}