package christmas.domain

import christmas.data.ConstString
import christmas.data.EventDiscount
import christmas.data.EventResult

class EventHandler(val date:Int, val orderMenu : List<MenuResult>,val totalPrice: Int) {

    val checkEvent = CheckEvent(date)
    private var _finalDiscount = 0
    private var _eventDiscounts = mutableListOf<EventDiscount>()



    init {
        handleEvent()
    }

    private fun handleEvent(){
        if(checkEvent.checkChristmasEvent()) _eventDiscounts.add(EventDiscount(ConstString.CHRISTMASDISCOUNT,ChristmasEventHandler(date).getDiscount() * -1))
        if(checkEvent.checkWeekDaysEvent())_eventDiscounts.add(EventDiscount(ConstString.WEEKDAYSDISCOUNT, WeekDaysEventHandler(orderMenu).getDiscount() * -1))
        if(checkEvent.checkWeekendsEvent())_eventDiscounts.add(EventDiscount(ConstString.WEEKENDDISCOUNT,WeekendsEventHandler(orderMenu).getDiscount() * -1))
        if(checkEvent.checkSpecialEvent())_eventDiscounts.add(EventDiscount(ConstString.SPECIALDISCOUNT,SpecialEventHandler().getDiscount() * -1))
        if(checkEvent.checkGiftEvent(totalPrice))_eventDiscounts.add(EventDiscount(ConstString.GIFTDISCOUNT,GiftEventHandler().getDiscount() * -1))

        calculateDiscount()
    }

    private fun calculateDiscount(){
        _eventDiscounts.forEach {
            _finalDiscount += it.eventDiscount
        }

    }

    fun getFinalDiscount() : Int {
        return  _finalDiscount
    }

    fun getEachEvenDiscount() : List<EventDiscount> {
        return _eventDiscounts
    }

}