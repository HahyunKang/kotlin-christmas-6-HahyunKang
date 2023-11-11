package christmas.domain

import camp.nextstep.edu.missionutils.Console
import christmas.data.ConstString

class Customer {

    private var _visitDate = 0
    private var _menu = ""

    init {
        inputDate()
        inputMenu()
    }

    private fun inputDate(){
        println(ConstString.ASK_WHEN_TO_VISIT)
        val date = Console.readLine()
        _visitDate = date.toInt()


    }

    private fun inputMenu(){
        println(ConstString.ASK_WHAT_TO_ORDER)
        val menu = Console.readLine()
        _menu = menu


    }

    fun getVisitDate(): Int{
        return _visitDate
    }

    fun getMenu() : String {
        return _menu
    }




}