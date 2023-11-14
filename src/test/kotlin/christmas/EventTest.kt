package christmas

import christmas.data.*
import christmas.domain.CheckEvent
import christmas.domain.EventHandler
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EventTest {

    private lateinit var eventHandler: EventHandler
    @BeforeEach
    fun setUp(){
        eventHandler =EventHandler(3, listOf(MenuResult(Menu.TboneStake,1),MenuResult(Menu.BarbequeLib,1),MenuResult(Menu.ChocoCake,2),MenuResult(Menu.ZeroCola,1)),142000)
    }

    @Test
    fun `총 할인 금액`(){
        val finalDiscount =  eventHandler.getFinalDiscount()
        Assertions.assertEquals(finalDiscount,-31246)
    }

    @Test
    fun `총 혜택 내역`(){
        val eventResult = eventHandler.getEachEvenDiscount()
        val expected = listOf(
            EventDiscount(ConstString.CHRISTMASDISCOUNT,-1200),
            EventDiscount(ConstString.WEEKDAYSDISCOUNT,-4046),
            EventDiscount(ConstString.SPECIALDISCOUNT,-1000),
            EventDiscount(ConstString.GIFTDISCOUNT,-25000)
        )
        Assertions.assertEquals(expected,eventResult)
    }

    @Test
    fun `배지 테스트`(){
        val badge = eventHandler.getBadge()
        val expected = Badge.SANTA
        Assertions.assertEquals(expected,badge)

    }

}