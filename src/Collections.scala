import java.io.PrintStream
import java.util.HashMap
import scala.collection.immutable.TreeMap

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworks
 * Date: 10/14/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
class Collections {
  val printer = new PrintStream(System.out)
  val nameMap = TreeMap[String, String]("Bill" -> "832-367-0666", "Archer" -> "818-555-1234", "Lana" -> "818-555-4321")

  def findIntersection(set1: Set[String], set2: Set[String]) {
    if (set1.size > 0 && set2.size > 0) {
      for (string <- set1 | set2)
        printer.println(string)
    }
  }

  def lookupPhoneNumber(name: String) {
    val phoneNumber: String = nameMap.getOrElse(name, "")
    printer.println(phoneNumber)
  }

  def printNamesInMap() {
    nameMap.foreach(p => printer.println(p._1))
  }
}

object Main {
  def main(args: Array[String]) {
    val c = new Collections
    c.printNamesInMap()
    c.lookupPhoneNumber("Elise")
  }
}