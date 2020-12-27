import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert

class EtlTest extends AnyFunSuite {

  test("a single letter") {
    val scores = Map(1 -> Seq("A"))
    val expected = Map("a" -> 1)
    assert(Etl.transform(scores) == expected)
  }

  test("single score with multiple letters") {
    val scores = Map(1 -> Seq("A", "E", "I", "O", "U"))
    val expected = Map("a" -> 1, "e" -> 1, "i" -> 1, "o" -> 1, "u" -> 1)
    assert(Etl.transform(scores) == expected)
  }

  test("multiple scores with multiple letters") {
    val scores = Map(1 -> Seq("A", "E"), 2 -> Seq("D", "G"))
    val expected = Map("a" -> 1, "d" -> 2, "e" -> 1, "g" -> 2)
    assert(Etl.transform(scores) == expected)
  }

  test("multiple scores with differing numbers of letters") {
    val scores = Map(1 -> Seq("A", "E", "I", "O", "U", "L", "N", "R", "S", "T"),
      2 -> Seq("D", "G"), 3 -> Seq("B", "C", "M", "P"), 4 -> Seq("F", "H", "V", "W", "Y"),
      5 -> Seq("K"), 8 -> Seq("J", "X"), 10 -> Seq("Q", "Z"))

    val expected = Map("a" -> 1,
        "b" -> 3, "c" -> 3, "d" -> 2, "e" -> 1, "f" -> 4, "g" -> 2, "h" -> 4,
        "i" -> 1, "j" -> 8, "k" -> 5, "l" -> 1, "m" -> 3, "n" -> 1, "o" -> 1, 
        "p" -> 3, "q" -> 10, "r" -> 1, "s" -> 1, "t" -> 1, "u" -> 1, "v" -> 4,
        "w" -> 4, "x" -> 8, "y" -> 4, "z" -> 10)
        
    assert(Etl.transform(scores) == expected)
  }

}
