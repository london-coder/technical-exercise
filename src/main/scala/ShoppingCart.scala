// shopping cart 
// the container (basket) was chosen to be mutable for expediency 
import scala.collection.mutable._

class ShoppingCart extends ProduceOffers {
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
    val amount: Double = price.toDouble / 100 
    f"£$amount%.2f"
  }
  
  def discount: Int = {
    val appleCount = appleDiscount(basket)
    val appleDeduction: Int = if (appleCount != 0) appleCount * priceList("Apple") else 0
    
    val orangeCount = orangeDiscount(basket)
    val orangeDeduction = if(orangeCount != 0) orangeCount * priceList("Orange") else 0
    
    appleDeduction + orangeDeduction
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