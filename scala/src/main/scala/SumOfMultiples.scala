object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    Range(0, limit)
      .filter(number => factors.exists(fact => number % fact == 0))
      .sum
  }
}
