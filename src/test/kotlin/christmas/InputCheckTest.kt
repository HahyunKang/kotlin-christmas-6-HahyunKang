package christmas

import christmas.data.Menu
import christmas.data.MenuResult
import christmas.util.ErrorMessage
import christmas.util.InputChecker
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputCheckTest {
    @Test
    fun `날짜 입력 예외 테스트`() {
        val input = "a"
        val code =  InputChecker.checkInputIsInt(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }
    @Test
    fun `날짜 입력 1이상 31이하 예외 테스트`() {
        val input = 44
        val code =  InputChecker.checkDateIs1to31(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }

    @Test
    fun `메뉴,개수 입력 테스트`() {
        val input = "제로콜라1개"
        val code =  InputChecker.checkMenuContainDash(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }
    @Test
    fun `메뉴 유효한지 테스트`() {
        val input = "사이다"
        val code =  InputChecker.checkMenuIsValid(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }

    @Test
    fun `메뉴 개수 1개 이상인지 예외 테스트`(){
        val input = 0
        val code = InputChecker.checkNumIsOverZero(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }

    @Test
    fun `메뉴 중복 예외 테스트`(){
        val input = listOf(MenuResult(Menu.Salad,1), MenuResult(Menu.Salad,1))
        val code = InputChecker.checkMenuIsDuplicate(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }

    @Test
    fun `메뉴 음료만 있을 경우 예외 테스트`(){
        val input = listOf(MenuResult(Menu.ZeroCola,1), MenuResult(Menu.RedWine,1))
        val code = InputChecker.checkMenuIsOnlyDrinks(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }
    @Test
    fun `메뉴 20개 넘을 경우 예외 테스트`(){
        val input = listOf(MenuResult(Menu.ZeroCola,12), MenuResult(Menu.RedWine,12))
        val code = InputChecker.checkMenuNumsIsOverTwenty(input)
        assertEquals(code, ErrorMessage.ERROR_CODE)
    }



}