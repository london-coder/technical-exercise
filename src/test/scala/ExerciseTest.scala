/* ===================================
 * test suite for programmer test 
 * =================================== */

import org.scalatest.FlatSpec
import org.scalatest.Matchers


class ExerciseTest extends FlatSpec with Matchers {
  // shopping cart test content
  val basket = new ShoppingCart()

  basket.addItems( List("Apple", "Apple", "Orange", "Apple"))

  
  "The price list" should "include an apple" in {
    
    basket.contains("Apple") shouldBe true
  }
  
  "An apple" should "have a price" in {

    basket.itemPrice("Apple") should equal (60)
  }
  
  "The price list" should "include an orange" in {

    basket.contains("Orange") shouldBe true
  }
  
  "An orange" should "have a price" in {

    basket.itemPrice("Orange") == 25 shouldBe true
  }
  
  "The shopping cart" should "contain items" in {
    
     basket.basketSize == 4 shouldBe true
  }
  
  "The content of shopping cart" should "add up all items" in {
    basket.priceOfItems should equal (205)
  }
  
  "The total price as a string" should "include currency symbol" in {
    basket.formatPrice(basket.priceOfItems) shouldBe "£2.05"
  }
  
  // step 2, where promotional offers are applied
  // BOGOF for apples
  "The discount on apples" should "mean only 2 are charged" in {
    basket.applyDiscount should equal (145)
  }
  
  "Correct discount" should 
    "be applied in all scenarios" in {
      basket.clearBasket()
      basket.addItems(List("Orange", "Orange", "Orange"))
      basket.applyDiscount should equal(50)
  } 
  
  it should "cost 3 oranges when 4 oranges are purchased" in {
    basket.additem("Orange")
    basket.applyDiscount should equal (75)
  }
  
  it should "cost 4 oranges when there are 6 in the basket" in {
    basket.addItems(List("Orange", "Orange"))
    basket.applyDiscount should equal (100)
  }
  
  it should "cost 2 apples when 4 apples are purchased" in {
    basket.clearBasket()
    basket.addItems(List("Apple", "Apple", "Apple", "Apple"))
    assert(basket.applyDiscount == 120)
  }
  
  it should "not apply discount when purchase does not reach threshold" in {
    basket.clearBasket()
    basket.addItems(List("Apple", "Orange", "Orange"))
    assert(basket.applyDiscount == 110)
  }
    
}