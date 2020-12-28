import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert

class SumOfMultiplesTest extends AnyFunSuite {

  test("multiples of 3 or 5 up to 1") {
    assert(SumOfMultiples.sum(Set(3, 5), 1) == 0)
  }

  test("multiples of 3 or 5 up to 4") {
    assert(SumOfMultiples.sum(Set(3, 5), 4) == 3)
  }

  test("multiples of 3 up to 7") {
    assert(SumOfMultiples.sum(Set(3), 7) == 9)
  }

  test("multiples of 3 or 5 up to 10") {
    assert(SumOfMultiples.sum(Set(3, 5), 10) == 23)
  }

  test("multiples of 3 or 5 up to 100") {
    assert(SumOfMultiples.sum(Set(3, 5), 100) == 2318)
  }

  test("multiples of 3 or 5 up to 1000") {
    assert(SumOfMultiples.sum(Set(3, 5), 1000) == 233168)
  }

  test("multiples of 43 or 47 up to 10000") {
    assert(SumOfMultiples.sum(Set(43, 47), 10000) == 2203160)
  }

}
