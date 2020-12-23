import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Assertions.assert

class SpaceAgeTest extends AnyFunSuite {

  test("age on Earth") {
   assert(SpaceAge.onEarth(1000000000) == 31.69)
  }

  test("age on Mercury") {
    assert(SpaceAge.onMercury(2134835688) == 280.88)    
  }

  test("age on Venus") {
    assert(SpaceAge.onVenus(189839836) == 9.78)        
  }

  test("age on Mars") {  
    assert(SpaceAge.onMars(2.329871239E9) == 39.26)      
  }

  test("age on Jupiter") {   
    assert(SpaceAge.onJupiter(901876382) == 2.41)           
  }

  test("age on Saturn") {
    assert(SpaceAge.onSaturn(3.0E9) == 3.23)     
  }

  test("age on Uranus") {    
    assert(SpaceAge.onUranus(3.210123456E9) == 1.22)         
  }

  test("age on Neptune") {    
    assert(SpaceAge.onNeptune(8.210123456E9) == 1.58)     
  }
}