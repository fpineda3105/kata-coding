package main.scala

import scala.annotation.tailrec

/*
        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1    
*/
object PascalTriangle {

  
  def pascal(column: Int, row: Int): Int = {
    if (row <= 1) 1

    @tailrec
    def findPosition(currentRow: Int, prevRowList: Array[Int]): Int = {

      val currentRowList = retrieveNextRowList(prevRowList)
      if (currentRow == row)
        currentRowList(column)
      else
        findPosition(currentRow + 1, currentRowList)
    }

    def retrieveNextRowList(prevRowList: Array[Int]): Array[Int] = {
      val length = prevRowList.length + 1
      val nextRowList = Array.fill(length)(1)
      for (i <- Range(1, (length / 2) + 1)) {
        val middleValue = prevRowList(i - 1) + prevRowList(i)
        nextRowList(i) = middleValue
        nextRowList(length - 1 - i) = middleValue
      }
      nextRowList
    }

    findPosition(2, Array(1, 1))
  }
}
