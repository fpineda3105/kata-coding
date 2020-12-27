package main.scala
import scala.collection.mutable.Stack

object ValidBraces {

  def test(str: String): Boolean = {
    val pairBracesOpenning =
      Map('{' -> '}', '[' -> ']', '(' -> ')')
    var stack = Stack[Char]()    

    def verifyBraces(charList: List[Char]): Boolean = {
      if (charList.isEmpty)
        true
      else {
        val head = charList.head
        head match {
          case '(' | '[' | '{' => {
            stack.push(head)            
            verifyBraces(charList.tail)
          }
          case ')' | ']' | '}' => {
            if (stack.isEmpty)
              false
            else {
              val lastOpenning = stack.pop()
              if (pairBracesOpenning(lastOpenning) != head)
                false
              else {                
                verifyBraces(charList.tail)
              }
            }
          }
          case _ => false
        }
      }
    }

    verifyBraces(str.toList) && stack.isEmpty
  }
}
