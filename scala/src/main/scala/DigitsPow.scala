package main.scala

object DigitsPow {

  def digPow(number: Int, initialPow: Int): Int = {
    number.toString.zipWithIndex.map { case (digit, pow) =>
      math.pow(digit.asDigit, initialPow + pow)
    }.sum / number match {
      case result if result.isWhole => result.toInt
      case _                        => -1
    }    
  }  

}
