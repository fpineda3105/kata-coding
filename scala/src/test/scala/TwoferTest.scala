import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions._

class TwoferTest extends AnyFunSuite {

  test("no name given") {
    assert(Twofer.twofer() == "One for you, one for me.")
  }

  test("a name given") {
    assert(Twofer.twofer("Alice") == "One for Alice, one for me.")
  }

  test("another name given") {
    assert(Twofer.twofer("Bob") == "One for Bob, one for me.")
  }

}