import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert
import main.scala.ValidBraces

class ValidBracesTest extends AnyFunSuite {

    test("test valid simple parentesis ()") {
        assert(ValidBraces.test("()"))
    }

    test("test valid simple braces {}()[]") {
        assert(ValidBraces.test("{}()[]"))
    }

    test("test valid complex braces ()({[[[{[{{}}]}]]]})") {
        assert(ValidBraces.test("()({[[[{[{{}}]}]]]})"))
    }
    
    test("test valid complex parentesis ([{()}])[]{}") {
        assert(ValidBraces.test("([{()}])[]{}"))
    }

    test("test invalid simple parentesis ({)") {
        assert(!ValidBraces.test("({)"))
    }

    test("test invalid braces ]((}[(()["){
        assert(!ValidBraces.test("]((}[(()["))

    }
}