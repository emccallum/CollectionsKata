import java.io.PrintStream

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworks
 * Date: 10/14/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
class Collections {
  val printer = new PrintStream(System.out)

  def findIntersection(set1: Set[String], set2: Set[String]) {
    if (set1.size > 0 && set2.size > 0) {
      for (string <- set1 | set2)
        printer.println(string)
    }
  }
}
