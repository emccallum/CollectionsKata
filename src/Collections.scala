import java.io.PrintStream
import java.util.HashMap

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworks
 * Date: 10/14/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
class Collections {
  val printer = new PrintStream(System.out)
  var nameMap = new HashMap[String, String]

  def findIntersection(set1: Set[String], set2: Set[String]) {
    if (set1.size > 0 && set2.size > 0) {
      for (string <- set1 | set2)
        printer.println(string)
    }
  }

  def loadNames {
    nameMap.put("Bill", "832-367-0666")
    nameMap.put("Archer", "818-555-1234")
    nameMap.put("Lana", "818-555-4321")
  }

  def lookupPhoneNumber(name: String) {
    loadNames
    if (nameMap.get(name) != null)
      printer.println(nameMap.get(name))
  }
}
