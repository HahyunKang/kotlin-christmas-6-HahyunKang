package christmas.domain

import christmas.data.ConstString
import christmas.data.Menu

class MenuHandler() {


    fun splitInput(menu : String) : List<String>{
        return menu.split(",")
    }

    fun splitMenu(menu : String) : List<String>{
        return menu.split("-")
    }

     fun matchNames(menuName :  String) : Menu{
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
            ConstString.ZEROCOLA-> menu = Menu.ZeroCola
            ConstString.REDWINE -> menu = Menu.RedWine
            ConstString.CHAMPAGNE -> menu = Menu.Champagne
        }

        return menu

    }
}