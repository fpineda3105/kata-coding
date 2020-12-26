object Hamming {

    def distance(strA: String, strB: String): Option[Int] = {
        if (strA.length != strB.length)
            None
        else 
            Some(strA.zip(strB).count(ab => ab._1 != ab._2))                            
    }
}