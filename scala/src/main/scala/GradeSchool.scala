import scala.collection.immutable.SortedMap

class School {
  type DB = Map[Int, Seq[String]]
  private var _database: DB = Map().withDefaultValue(Seq())

  def db: DB = _database

  def add(name: String, g: Int) = {    
      _database = _database.updated(g, _database(g).:+(name))  
  }  

  def grade(g: Int) = _database(g)

  def sorted: DB = _database.keys.toList.sorted.map( k => k -> _database(k).sorted).toMap
}

