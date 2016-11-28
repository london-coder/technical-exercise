// shopping cart 
// the container (basket) was chosen to be mutable for expediency 
import scala.collection.mutable._

class Checkout extends ProduceOffers {
  // holds price of items
  private val priceList = Map("Apple" -> 60, "Orange" -> 25)
  // the shopping cart container
  private val basket: ListBuffer[String] = ListBuffer()

  def contains(item: String): Boolean = {
    priceList contains(item)
  }
  
  def basketSize: Int = {
    basket.size
  }
  
  def itemPrice(item: String): Int = {
    if(priceList.contains(item)) priceList(item) else 0
  }
  
  def priceOfItems: Int = {
    basket map(priceList) sum
  }
  
  def formatPrice(price: Int): String = {
    val amount: Double = BigDecimal(price.toDouble / 100).setScale(2, BigDecimal.RoundingMode.UP).toDouble 
    f"£$amount"
  }
  
  def discount: Int = {
    applePromotion + orangePromotion
  }
  
  def applePromotion: Int = {
    val appleCount = appleDiscount(basket)
    if (appleCount != 0) appleCount * priceList("Apple") else 0
  }
  
  def orangePromotion: Int = {
    val orangeCount = orangeDiscount(basket)
    if(orangeCount != 0) orangeCount * priceList("Orange") else 0
  }
  
  def applyDiscount(): Int = {
    priceOfItems - discount
  }
  
  def clearBasket(): Unit = {
    basket.clear()
  }
  
  def additem(item: String): Unit = {
    basket append item
  }
  
  def addItems(items: List[String]): Unit = {
    basket ++= items
  }
}