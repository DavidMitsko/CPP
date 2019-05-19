import scala.collection.mutable.ListBuffer

object Main {
  /*def main(args: Array[String]): Unit = {
    val array = List[String]("x^2+2/x-50","rtg n","q+x+tg(x)", "tg(x)")
    findPolynomial(array, parse)
    //array.filter(_>2)
    //val nums = List(5, 1, 4, 3, 2)
    //nums.filter(_ > 2)
    //  val originalList = List(5, 1, 4, 3, 2)
    //val newList = originalList.filter(_ > 2)
    // println(newList)
  }*/

  type Filter = String => Boolean

  def p(pol: String):Boolean = {
    if(pol.contains("x") && (pol.contains("+") || pol.contains("-") || pol.contains("*") ||
      pol.contains("/")  || pol.contains("^") || pol.contains("sin(") ||
      pol.contains("cos(") || pol.contains("tg(") || pol.contains("ctg("))) {
      //println("q")
      println(pol)
      true
    }
    else false
  }

  val parse = p _

  def findPolynomial(array: List[String], parse:Filter):List[String] = {
    val newList = array.filter(parse)
    println(newList)
    newList
  }
}
