/* ===================================
 * test suite for programmer test 
 =================================== */
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import scala.collection.mutable.ListBuffer


class ExerciseTest extends FlatSpec with Matchers {
  // holds price of items
  val priceList = Map("Apple" -> 60, "Orange" -> 25)
  
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
    val cart = List("Apple", "Apple", "Orange", "Apple")
    
     assert(cart.size == 4)
  }
  
  def sumOfItems(cart: List[String]): Int = {
    0
  }
}