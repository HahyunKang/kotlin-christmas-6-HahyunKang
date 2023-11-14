package christmas.domain

import camp.nextstep.edu.missionutils.Console
import christmas.data.ConstString
import christmas.util.ErrorMessage
import christmas.util.InputChecker

class Customer {

    private var _visitDate = 0
    private var _menu = ""
    private var _orderMenus = mutableListOf<MenuResult>()
    private val inputValidator = InputValidator()

    init {
        inputDate()
        inputMenu()
    }

    private fun inputDate(){
        println(ConstString.ASK_WHEN_TO_VISIT)
        try {
            val date = Console.readLine()
            inputValidator.checkInputDateIsValid(date)
            _visitDate = date.toInt()
            inputValidator.checkDateIsValid(_visitDate)
        } catch(e:IllegalArgumentException){
            println(e.message)
            inputDate()
        }

    }


    private fun inputMenu(){
        println(ConstString.ASK_WHAT_TO_ORDER)
        try {
            val menu = Console.readLine()

            _orderMenus= inputValidator.checkInputMenuIsValid(menu)
            inputValidator.menuIsInvalid(_orderMenus)

        }catch(e:IllegalArgumentException){
            println(e.message)
            inputMenu()
        }
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