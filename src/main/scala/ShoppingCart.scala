// shopping cart 
import scala.collection.mutable._

class ShoppingCart extends ProduceOffers {
  // holds price of items
  val priceList = Map("Apple" -> 60, "Orange" -> 25)
  val basket: ListBuffer[String] = ListBuffer()

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
}