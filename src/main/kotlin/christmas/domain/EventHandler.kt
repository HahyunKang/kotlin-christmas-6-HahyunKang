package christmas.domain

import christmas.data.*

class EventHandler(val date:Int, val orderMenu : List<MenuResult>, val totalPrice: Int) {

    private val checkEvent = CheckEvent(date)
    private var _finalDiscount = 0
    private var _realDiscount = 0
    private var _eventDiscounts = mutableListOf<EventDiscount>()
    private var _badge = Badge.NONE


    init {
        if(checkEvent.checkIsEventApply(totalPrice))handleEvent()
    }

    private fun handleEvent() {
        if(checkEvent.checkChristmasEvent()) _eventDiscounts.add(EventDiscount(ConstString.CHRISTMASDISCOUNT,ChristmasEventHandler(date).getDiscount() * -1))
        if(checkEvent.checkWeekDaysEvent())_eventDiscounts.add(EventDiscount(ConstString.WEEKDAYSDISCOUNT, WeekDaysEventHandler(orderMenu).getDiscount() * -1))
        if(checkEvent.checkWeekendsEvent())_eventDiscounts.add(EventDiscount(ConstString.WEEKENDDISCOUNT,WeekendsEventHandler(orderMenu).getDiscount() * -1))
        if(checkEvent.checkSpecialEvent())_eventDiscounts.add(EventDiscount(ConstString.SPECIALDISCOUNT,SpecialEventHandler().getDiscount() * -1))
        if(checkEvent.checkGiftEvent(totalPrice))_eventDiscounts.add(EventDiscount(ConstString.GIFTDISCOUNT,GiftEventHandler().getDiscount() * -1))
        badgeEvent()
        calculateDiscount()
        calculateRealDiscount()
    }

    private fun calculateDiscount(){
        _eventDiscounts.forEach {
            _finalDiscount += it.eventDiscount
        }

    }

    private fun calculateRealDiscount(){
        _eventDiscounts.forEach {
           if(it.eventName != ConstString.GIFTDISCOUNT) _realDiscount += it.eventDiscount
        }
    }

    private fun badgeEvent(){
        val badgeHandler = BadgeHandler(totalPrice)
        val badge = badgeHandler.getBadge()
        _badge = badge
    }

    fun getFinalDiscount() : Int {
        return  _finalDiscount
    }

    fun getRealDiscount() : Int {
        return _realDiscount
    }

    fun getEachEvenDiscount() : List<EventDiscount> {
        return _eventDiscounts
    }

    fun getBadge() : Badge {
        return _badge
    }

}