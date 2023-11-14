package christmas.domain

import christmas.util.ErrorMessage
import christmas.util.InputChecker

class InputValidator {


    private var orderMenus = mutableListOf<MenuResult>()
    private val menuHandler = MenuHandler()

    fun checkInputDateIsValid(date: String) {
        if(InputChecker.checkInputIsInt(date) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(ErrorMessage.SHOW_ERROR_DATE)
    }


    fun checkDateIsValid(date : Int){
        if(InputChecker.checkDateIs1to31(date) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(ErrorMessage.SHOW_ERROR_DATE)

    }


    fun checkInputMenuIsValid(menu : String) : MutableList<MenuResult> {

        val menuInput = menuHandler.splitInput(menu)
        menuInput.forEach {
            if (InputChecker.checkMenuContainDash(it) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )
            val menusSplit = menuHandler.splitMenu(it)
            if (InputChecker.checkMenuIsValid(menusSplit[0]) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )
            val menuName = menuHandler.matchNames(menusSplit[0])
            if (InputChecker.checkInputIsInt(menusSplit[1]) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )
            val menuNum = menusSplit[1].toInt()
            if (InputChecker.checkNumIsOverZero(menuNum) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )

            orderMenus.add(MenuResult(menuName, menuNum))
        }

        return orderMenus


    }
    fun menuIsInvalid(orderMenus : List<MenuResult>){

        if (InputChecker.checkMenuIsDuplicate(orderMenus) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
            ErrorMessage.SHOW_ERROR_ORDER
        )
        if (InputChecker.checkMenuIsOnlyDrinks(orderMenus) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
            ErrorMessage.SHOW_ERROR_ORDER
        )
        if (InputChecker.checkMenuNumsIsOverTwenty(orderMenus) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
            ErrorMessage.SHOW_ERROR_ORDER
        )
    }


}