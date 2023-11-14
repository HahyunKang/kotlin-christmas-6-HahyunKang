package christmas.domain

import camp.nextstep.edu.missionutils.Console
import christmas.data.ConstString
import christmas.util.ErrorMessage
import christmas.util.InputChecker

class Customer {

    private var _visitDate = 0
    private var _menu = ""
    private var _orderMenus = mutableListOf<MenuResult>()
    private val menuHandler = MenuHandler()

    init {
        inputDate()
        inputMenu()
    }

    private fun inputDate(){
        println(ConstString.ASK_WHEN_TO_VISIT)
        try {
            val date = Console.readLine()
            if(InputChecker.checkInputIsInt(date) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(ErrorMessage.SHOW_ERROR_DATE)
            _visitDate = date.toInt()
            if(InputChecker.checkDateIs1to31(_visitDate) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(ErrorMessage.SHOW_ERROR_DATE)
        } catch(e:IllegalArgumentException){
            println(e.message)
            inputDate()
        }

    }

    private fun inputMenu(){
        println(ConstString.ASK_WHAT_TO_ORDER)
        try {
            val menu = Console.readLine()
            checkInputIsValid(menu)
            menuIsInvalid()

        }catch(e:IllegalArgumentException){
            println(e.message)
            inputMenu()
        }
    }

    private fun checkInputIsValid(menu : String){

        val menuInput = menuHandler.splitInput(menu)
        menuInput.forEach {
            if (InputChecker.checkMenuContainDash(it) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )
            val menusSplit = it.split("-")
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

            _orderMenus.add(MenuResult(menuName, menuNum))
        }


    }
    private fun menuIsInvalid(){

            if (InputChecker.checkMenuIsDuplicate(_orderMenus) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )
            if (InputChecker.checkMenuIsOnlyDrinks(_orderMenus) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )
            if (InputChecker.checkMenuNumsIsOverTwenty(_orderMenus) == ErrorMessage.ERROR_CODE) throw IllegalArgumentException(
                ErrorMessage.SHOW_ERROR_ORDER
            )
        }



    fun getVisitDate(): Int{
        return _visitDate
    }

    fun getMenu() : String {
        return _menu
    }
    fun getOrderMenus() : List<MenuResult>{
        return _orderMenus
    }



}