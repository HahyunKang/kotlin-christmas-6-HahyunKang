package christmas.domain

import christmas.data.Badge
import christmas.data.CONSTNUM
import christmas.data.EventResult

class BadgeHandler(val totalPrice : Int) {

    private var badge = Badge.NONE
    fun getBadge() : Badge {
        if(totalPrice>= CONSTNUM.SANTABADGECRITERIA) badge = Badge.SANTA
        else if(totalPrice >= CONSTNUM.TREEBADGECRITERIA) badge = Badge.TREE
        else if(totalPrice >= CONSTNUM.STARTBADGECRITERIA) badge = Badge.STAR

        return badge
    }

}