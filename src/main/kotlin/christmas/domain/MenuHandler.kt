package christmas.domain

import christmas.data.ConstString
import christmas.data.Menu

class MenuHandler(val menus: String) {
   val menuSplit = ","
    val priceSplit = "-"
    private var _orderMenus = mutableListOf<MenuResult>()

    init {
        menuHandle()
    }

     fun menuHandle(){
        val menuNamesAndPrices= menus.split(menuSplit)
        menuNamesAndPrices.forEach {
            val menus = it.split(priceSplit)
            val menuType = matchNames(menus.get(0))
            val orderCount = menus.get(1).toInt()
            _orderMenus.add(MenuResult(menuType,orderCount))
        }
    }

    fun getOrderMenus() : List<MenuResult>{
        return _orderMenus
    }

    private fun matchNames(menuName :  String) : Menu{
        var menu = Menu.Soup

        when(menuName) {
            ConstString.SOUP -> menu  = Menu.Soup
            ConstString.TAPAS -> menu = Menu.Tapas
            ConstString.SALAD -> menu  = Menu.Salad
            ConstString.TBONESTAKE -> menu = Menu.TboneStake
            ConstString.BARBEQUELIB -> menu = Menu.BarbequeLib
            ConstString.SEAFOODPASTA -> menu = Menu.SeaFoodPasta
            ConstString.CHRISTMASPASTA -> menu = Menu.ChristmasPasta
            ConstString.CHOCOCAKE -> menu = Menu.ChocoCake
            ConstString.ICECREAM -> menu = Menu.IceCream
            ConstString.REDWINE -> menu = Menu.RedWine
            ConstString.CHAMPAGNE -> menu = Menu.Champagne
        }

        return menu

    }
}