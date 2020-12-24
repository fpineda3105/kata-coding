import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert

class GradeSchoolTest extends AnyFunSuite {
  def fixture = new {val school = new School}

  test ("empty school") {
    val school = fixture.school
    assert(school.db == Map())    
  }

  test ("add student") {
    val school = fixture.school    
    school.add("Aimee", 2)
    assert(school.db == Map(2 -> Seq("Aimee")))
  }

  test ("add more students in same class") { 
    val school = fixture.school   
    school.add("James", 2)
    school.add("Blair", 2)
    school.add("Paul", 2)
    assert(school.db == Map(2 -> Seq("James", "Blair", "Paul")))
  }

  test ("add students to different grades") {
    val school = fixture.school    
    school.add("Chelsea", 3)
    school.add("Logan", 7)
    assert( school.db == Map(3 -> Seq("Chelsea"), 7 -> Seq("Logan")))
  }

  test ("get students in a grade") {
    val school = fixture.school        
    school.add("Franklin", 5)
    school.add("Bradley", 5)
    school.add("Jeff", 1)
    assert(school.grade(5) == Seq("Franklin", "Bradley"))
  }

  test ("get students in a non-existent grade") {
    val school = fixture.school    
    assert(school.grade(1) == Seq())    
  }

  test ("sort school") {    
    val school = fixture.school     
    school.add("Jennifer", 4)
    school.add("Kareem", 6)
    school.add("Christopher", 4)
    school.add("Kyle", 3)
    val sorted = Map(
      3 -> Seq("Kyle"),
      4 -> Seq("Christopher", "Jennifer"),
      6 -> Seq("Kareem")
    )

    assert(sorted == school.sorted)
    assert(Seq(3, 4, 6) == school.sorted.keys.toList)    
  }
  
}
