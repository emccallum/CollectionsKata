import java.io.PrintStream
import org.specs2.mock.Mockito
import org.specs2.mutable._

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworks
 * Date: 10/14/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
class CollectionsTest extends Specification with Mockito {
  isolated
  val mockPrinter = mock[PrintStream]
  val collections = new Collections{
    override val printer = mockPrinter
  }
  "Two empty sets" should {
    "print nothing" in {
      collections.findIntersection(Set(), Set())
      there was no(mockPrinter).println(anyString)
    }
  }

  "An empty set and a set with content" should {
    "print nothing" in {
      collections.findIntersection(Set(), Set("hi"))
      there was no(mockPrinter).println(anyString)
    }
  }

  "Two sets with overlapping content" should {
    "only print matching elements" in {
      collections.findIntersection(Set("you", "hi"), Set("hi", "you", "there"))
      there was one(mockPrinter).println("hi")
      there was one(mockPrinter).println("you")
    }
  }

}
