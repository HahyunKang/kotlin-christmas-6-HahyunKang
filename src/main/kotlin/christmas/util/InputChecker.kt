package christmas.util

import christmas.data.CONSTNUM
import christmas.data.Category
import christmas.data.Menu
import christmas.data.MenuResult


object ErrorMessage {
    const val EROOR = "[ERROR]"
    const val SHOW_ERROR_DATE = "${ErrorMessage.EROOR} 유효하지 않은 날짜입니다. 다시 입력해 주세요."
    const val SHOW_ERROR_ORDER = "${ErrorMessage.EROOR} 유효하지 않은 주문입니다. 다시 입력해 주세요."
    const val ERROR_CODE = -1
    const val MENU_SPLIT = "-"
}


object InputChecker {


    fun checkInputIsInt(input : String) : Int {
        input.toIntOrNull() ?: return ErrorMessage.ERROR_CODE
        return CONSTNUM.RETURN_CODE
    }

    fun checkDateIs1to31(date : Int) : Int{
        if(date < 1 || date > 31) return ErrorMessage.ERROR_CODE
        return CONSTNUM.RETURN_CODE
    }

    fun checkMenuContainDash(menuItem : String) :Int {
        if(!menuItem.contains(ErrorMessage.MENU_SPLIT)) return ErrorMessage.ERROR_CODE
        return CONSTNUM.RETURN_CODE
    }

    fun checkMenuIsValid(menu : String) : Int {
        val menuItems : List<String> = Menu.entries.map {
                it.menuName
        }
        if(!menuItems.contains(menu)) return ErrorMessage.ERROR_CODE
        return CONSTNUM.RETURN_CODE
    }

    fun checkNumIsOverZero(num : Int) : Int{
        if(num <= 0) return ErrorMessage.ERROR_CODE
        return CONSTNUM.RETURN_CODE
    }


    fun checkMenuIsDuplicate(orderMenus : List<MenuResult>) : Int{
        val menuNames : List<String> = orderMenus.map {
            it.menu.menuName
        }
        val distinctMenu = menuNames.distinct()
        if(menuNames.size != distinctMenu.size ) return ErrorMessage.ERROR_CODE


        return CONSTNUM.RETURN_CODE
    }

    fun checkMenuIsOnlyDrinks(orderMenus : List<MenuResult>) : Int {
        val menuCategories : List<Category> = orderMenus.map {
            it.menu.category
        }
        if(menuCategories.all {
             it == Category.Drink
        }) return ErrorMessage.ERROR_CODE

        return CONSTNUM.RETURN_CODE
    }

    fun checkMenuNumsIsOverTwenty(orderMenus: List<MenuResult>) : Int {
        var count = 0
        orderMenus.forEach {
            count += it.orderCount
        }
        if(count > CONSTNUM.MENUNUMSCRITERIA) return ErrorMessage.ERROR_CODE

        return CONSTNUM.RETURN_CODE
    }
}