import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert
import main.scala.PascalTriangle

class PascalTriangleTest extends AnyFunSuite {

    test("get the (0,2) position value") {     
        assert(PascalTriangle.pascal(0,2) == 1)
    }

    test("get the (1,2) position value") {
        assert(PascalTriangle.pascal(1,2) == 2)
    }

    test("get the (1,3) position value") {
        assert(PascalTriangle.pascal(1,3) == 3)
    }

    test("get the (2,4) position value") {
        assert(PascalTriangle.pascal(2,4) == 6)
    }

    test("get the (2,5) position value") {
        assert(PascalTriangle.pascal(2,5) == 10)
    }
    
}