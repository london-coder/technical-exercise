import org.scalatest.FlatSpec
import org.scalatest.Matchers

class AccountExercise extends FlatSpec with Matchers {
  
  "A 0 amount" should "have a interest of 0" in {
      interest(0.0d) should equal(0.0d)
  }
  
  "An amount of 100" should "pay interest of 1 percent" in {
    interest(100.00d) should equal(1.0d)
  }
  
  "An amount of greater than 1000" should "pay interest of 2 percent" in {
    interest(2000.00d) should equal(40.00d)
  }
  
  "An amount of 10000" should "pay interest of 3 percent" in {
    interest(10000.00d) should equal(300.00)
  }
  
  "Interest on a specific value" should "be calculated correctly" in {
    interest(6257.15d) should equal(187.72)
  }
  
  "An invalid value less than zero" should "produce zero interest" in {
    interest(-1.00d) should equal(0.0)
  }
  
  def interest(am: Double): Double = {
    if(am > 0.0d) {
      val lowest = 1000.00d
      val middle = 5000.00d
      if(am  <= lowest) interestValue(1, am) else if(am <= middle) interestValue(2, am) else interestValue(3, am)
    }
    else 0d
  }
  
  def interestValue(rate: Int, am: Double): Double = {
    BigDecimal(rate.toDouble/100 * am).setScale(2, BigDecimal.RoundingMode.UP).toDouble
  }
}