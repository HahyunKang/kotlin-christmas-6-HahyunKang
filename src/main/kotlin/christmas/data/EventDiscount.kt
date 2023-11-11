package christmas.data

data class EventResult(
    var totalDiscount : Int = 0,
    var getChampagne : Boolean = false,
    var badge: Badge = Badge.NONE
)

data class EventDiscount(
    var eventName: String,
    var eventDiscount: Int
)

