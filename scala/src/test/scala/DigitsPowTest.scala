import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert
import main.scala.DigitsPow

class DigitsPowTest extends AnyFunSuite {

 test("digPow(89,1) should return 1") {      
    assert(DigitsPow.digPow(89, 1) == 1)
  }

  test("digPow(92,1) should return -1") {      
    assert(DigitsPow.digPow(92, 1) == -1)
  }

  test("digPow(46288,3) should return 51") {
    assert(DigitsPow.digPow(46288, 3) == 51)
  }

  test("digPow(46288,5) should return -1") {    
    assert(DigitsPow.digPow(46288,5) == -1)
  }
}
