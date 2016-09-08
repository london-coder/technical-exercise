/* ===================================
 * test suite for programmer test 
 =================================== */
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import scala.collection.mutable.ListBuffer


class ExerciseTest extends FlatSpec with Matchers {
  // shopping cart test content
  val basket = new ShoppingCart()

  basket.basket ++= List("Apple", "Apple", "Orange", "Apple")

  
  "The price list" should "include an apple" in {
    
    assert(basket.priceList contains("Apple"))
  }
  
  "An apple" should "have a price" in {

    assert(basket.priceList("Apple") == 60)
  }
  
  "The price list" should "include an orange" in {

    assert(basket.priceList contains("Orange"))
  }
  
  "An orange" should "have a price" in {

    assert(basket.priceList("Orange") == 25)
  }
  
  "A shopping cart" should "contains items" in {
    
     assert(basket.basket.size == 4)
  }
  
  "The content of shopping cart" should "add up to" in {
    assert(basket.priceOfItems == 205)
  }
  
  "The total price as a string" should "include currency symbol" in {
    assert(basket.formatPrice(basket.priceOfItems) == "£2.05")
  }
  
  // step 2, where promotional offers are applied
  // BOGOF for apples
  "The discount on apples" should "mean only 2 are charged" in {
    assert(basket.applyDiscount == 145)
  }
  
  "Correct discount" should 
    "be applied in all scenarios" in {
      basket.clearBasket()
      basket.basket ++= List("Orange", "Orange", "Orange")
      assert(basket.applyDiscount == 50)
  } 
  it should "cost 3 when 4 oranges are purchased" in {
    basket.basket ++= List("Orange")
    assert(basket.applyDiscount == 75)
    basket.basket ++= List("Orange", "Orange")
    assert(basket.applyDiscount == 100)
  }
  it should "cost 2 when 4 apples are purchased" in {
    basket.clearBasket()
    basket.basket ++= List("Apple", "Apple", "Apple", "Apple")
    assert(basket.applyDiscount == 120)
  }
  it should "not apply discount when purchase does not reach threshold" in {
    basket.clearBasket()
    basket.basket ++= List("Apple", "Orange", "Orange")
    assert(basket.applyDiscount == 110)
  }
    
}