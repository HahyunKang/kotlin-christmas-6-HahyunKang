package christmas.domain

class EventHandler(val date:Int, val orderMenu : List<MenuResult>,val totalPrice: Int) {

    val checkEvent = CheckEvent(date)
    private var _finalDiscount = 0


    init {
        handleEvent()
    }

    private fun handleEvent(){
        if(checkEvent.checkChristmasEvent())_finalDiscount += ChristmasEventHandler(date).getDiscount()
        if(checkEvent.checkWeekDaysEvent())_finalDiscount+= WeekDaysEventHandler(orderMenu).getDiscount()
        if(checkEvent.checkWeekendsEvent())_finalDiscount += WeekendsEventHandler(orderMenu).getDiscount()
        if(checkEvent.checkSpecialEvent())_finalDiscount += SpecialEventHandler().getDiscount()
        if(checkEvent.checkGiftEvent(totalPrice))_finalDiscount += GiftEventHandler().getDiscount()
    }

    fun getFinalDiscount() : Int {
        return _finalDiscount
    }

}