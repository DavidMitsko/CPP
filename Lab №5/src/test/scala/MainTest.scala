import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

class MainTest extends FunSuite {

  test("testSearchTailRecursion") {
    val array: List[Int] = List(5, 2, 3, 8, 1, 0, 3, 7)
    val newArray = ListBuffer[Int]()
    val result = ListBuffer[Int](5, 2, 3, 0)
    Main.searchTailRecursion(array, 0, newArray)
    assert(newArray.equals(result))
  }

  test("testSearchNonTailRecursion") {
    val array: List[Int] = List(5, 2, 3, 8, 1, 0, 3, 7)
    val newArray = ListBuffer[Int]()
    val result = ListBuffer[Int](5, 2, 3, 0)
    newArray ++= Main.searchNonTailRecursion(array, 0)
    assert(newArray.equals(result))
  }

}
