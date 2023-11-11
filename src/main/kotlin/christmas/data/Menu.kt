package christmas.data


enum class Menu(val menuName: String,val price: Int, val category: Category){
    Soup(ConstString.SOUP,2000,Category.Appetizer),
    Tapas(ConstString.TAPAS,5000,Category.Appetizer),
    Salad(ConstString.SALAD,8000,Category.Appetizer),
    TboneStake(ConstString.TBONESTAKE,55000,Category.Main),
    BarbequeLib(ConstString.BARBEQUELIB,54000,Category.Main),
    SeaFoodPasta(ConstString.SEAFOODPASTA,35000,Category.Main),
    ChristmasPasta(ConstString.CHRISTMASPASTA,25000,Category.Main),
    ChocoCake(ConstString.CHOCOCAKE,15000,Category.Dessert),
    IceCream(ConstString.ICECREAM,5000,Category.Dessert),
    ZeroCola(ConstString.ZEROCOLA,3000,Category.Drink),
    RedWine(ConstString.REDWINE,60000,Category.Drink),
    Champagne(ConstString.CHAMPAGNE,25000,Category.Drink);

    companion object {
        val menuNames: Array<String> = Menu.values().map { it.menuName }.toTypedArray()
    }




}

enum class Category {
    Appetizer,Main,Dessert,Drink
}