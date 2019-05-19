import org.scalatest.FunSuite

class MainTest extends FunSuite {

  test("testFindPolynomial") {
    val array = List[String]("x^2+2/x-50",
    "rtg n",
    "q+x+tg(x)",
    "tg(x)")
    val newArray = Main.findPolynomial(array, Main.parse)
    val result = List[String]("x^2+2/x-50", "q+x+tg(x)", "tg(x)")
    assert(newArray.equals(result))
  }

}
