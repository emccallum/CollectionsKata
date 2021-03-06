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

  "If Bill's phone number is stored" should {
    "then I should look it up and print it out" in {
      collections.lookupPhoneNumber("Bill")
      there was one(mockPrinter).println("832-367-0666")
    }
  }

  "If a phone number is not stored" should {
    "then I should print nothing" in {
      collections.lookupPhoneNumber("Elise")
      there was one(mockPrinter).println("")
    }
  }

  "A collection with a set of names" should {
    "print them in alphabetical order" in {
      collections.printNamesInMap()
      there was one(mockPrinter).println("Archer") before (mockPrinter).println("Bill")
      there was one(mockPrinter).println("Lana") after (mockPrinter).println("Bill")
    }
  }

}
