import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert

class HammingTest extends AnyFunSuite {

  test("empty strands") {
    assert(Hamming.distance("", "") == Some(0))
  }

  test("identical strands") {
    assert(Hamming.distance("A", "A") == Some(0))
  }

  test("long identical strands") {
    assert(Hamming.distance("GGACTGA", "GGACTGA") == Some(0))
  }

  test("complete distance in single nucleotide strands") {
    assert(Hamming.distance("A", "G") == Some(1))
  }

  test("complete distance in small strands") {
    assert(Hamming.distance("AG", "CT") == Some(2))
  }

  test("small distance in small strands") {
    assert(Hamming.distance("AT", "CT") == Some(1))
  }

  test("small distance") {
    assert(Hamming.distance("GGACG", "GGTCG") == Some(1))
  }

  test("small distance in long strands") {
    assert(Hamming.distance("ACCAGGG", "ACTATGG") == Some(2))
  }

  test("non-unique character in first strand") {
    assert(Hamming.distance("AAG", "AAA") == Some(1))
  }

  test("non-unique character in second strand") {
    assert(Hamming.distance("AAA", "AAG") == Some(1))
  }

  test("same nucleotides in different positions") {
    assert(Hamming.distance("TAG", "GAT") == Some(2))     
  }

  test("large distance") {
    assert(Hamming.distance("GATACA", "GCATAA") == Some(4))     
  }

  test("large distance in off-by-one strand") {
    assert(Hamming.distance("GGACGGATTCTG", "AGGACGGATTCT") == Some(9))     
  }

  test("disallow first strand longer") {
    assert(Hamming.distance("AATG", "AAA") == None)     
  }

  test("disallow second strand longer") {
    assert(Hamming.distance("ATA", "AGTG") == None)     
  }
}
