package christmas.data

enum class Appetizer(val menuName : String, val prize : Int) {
    Soup("스프",2000),
    Tapas("타파스",5500),
    Salad("시저샐러드",8000)
}

enum class Main(val menuName :String, val prize : Int){
    TboneStake("티본스테이크",55000),
    BarbequeLib("바비큐립",54000),
    SeaFoodPasta("해산물파스타",35000),
    ChristmasPasta("크리스마스파스타",25000)
}

enum class Dessert(val menuName:String,val prize:Int){
    ChocoCake("초코케이크",15000),
    IceCream("아이스크림",5000)
}

enum class Drink(val menuName: String, val prize: Int){
    ZeroCola("제로콜라",3000),
    RedWine("레드와인",60000),
    Champagne("샴페인",25000)
}

