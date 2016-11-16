
import scala.collection.mutable.ListBuffer

trait ProduceOffers {
  
  // buy 1 get 1 free
  def appleDiscount(basket: ListBuffer[String]): Int = {
    val count = basket.count(_ == "Apple")
    if (count > 1)  count / 2  else 0
  }
  
  // buy 3 get 1 free
  def orangeDiscount(basket: ListBuffer[String]): Int = {
    val count = basket.count(_ == "Orange")
    if(count >= 3) count / 3 else 0
  }
}