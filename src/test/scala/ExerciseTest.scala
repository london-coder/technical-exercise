/* ===================================
 * test suite for programmer test 
 =================================== */
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import scala.collection.mutable.ListBuffer


class ExerciseTest extends FlatSpec with Matchers {
  // holds price of items
  val priceList = Map("Apple" -> 60, "Orange" -> 25)
  // shopping cart content
  val shoppingCart = List("Apple", "Apple", "Orange", "Apple")
  
  "The price list" should "include an apple" in {
    
    assert(priceList contains("Apple"))
  }
  
  "An apple" should "have a price" in {

    assert(priceList("Apple") == 60)
  }
  
  "The price list" should "include an orange" in {

    assert(priceList contains("Orange"))
  }
  
  "An orange" should "have a price" in {

    assert(priceList("Orange") == 25)
  }
  
  "A shopping cart" should "contains items" in {
    
     assert(shoppingCart.size == 4)
  }
  
  "The content of shopping cart" should "add up to" in {
    assert(sumOfItems(shoppingCart) == 205)
  }
  
  "The total price as a string" should "include currency symbol" in {
    assert(formatPrice(sumOfItems(shoppingCart)) == "£2.05")
  }
  
  def sumOfItems(cart: List[String]): Int = {
    cart map(priceList) sum
  }
  
  def formatPrice(price: Int): String = {
    val amount: Double = price.toDouble / 100 
    f"£$amount%.2f"
  }
}