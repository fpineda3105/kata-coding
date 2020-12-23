object Planet extends Enumeration {

  type Planet = Value
  val Earth, Jupiter, Saturn, Mars, Uranus, Neptune, Venus, Mercury = Value  
}

import Planet._

object SpaceAge {

  def earthYearSeconds = 31557600.0

  def formatAge(age: Double): Double = (math ceil age * 100) / 100

  def calculateAge(seconds: Double, planet: Planet): Double = {
    planet match {
      case Earth   => seconds / earthYearSeconds
      case Mercury => seconds / (earthYearSeconds * 0.2408467)
      case Venus => seconds / (earthYearSeconds * 0.61519726)
      case Mars => seconds / (earthYearSeconds * 1.8808158)
      case Jupiter => seconds / (earthYearSeconds * 11.862615)
      case Saturn => seconds / (earthYearSeconds * 29.447498)
      case Uranus => seconds / (earthYearSeconds * 84.016846)
      case Neptune => seconds / (earthYearSeconds * 164.79132)
    }
  }

  def onEarth(seconds: Double): Double = {
    formatAge(calculateAge(seconds, Earth))
  }

  def onMercury(seconds: Double): Double = {
    formatAge(calculateAge(seconds, Mercury))
  }

  def onVenus(seconds: Double): Double = {    
    formatAge(calculateAge(seconds, Venus))
  }

  def onMars(seconds: Double): Double = {
      formatAge(calculateAge(seconds, Mars))
  }

  def onJupiter(seconds: Double): Double = {
    formatAge(calculateAge(seconds, Jupiter))
  }

  def onSaturn(seconds: Double): Double = {
    formatAge(calculateAge(seconds, Saturn))
  }

  def onUranus(seconds: Double): Double = {
      formatAge(calculateAge(seconds, Uranus))
  }

  def onNeptune(seconds: Double): Double = {
      formatAge(calculateAge(seconds, Neptune))
  }
  
}
