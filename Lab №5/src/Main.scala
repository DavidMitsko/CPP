import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]): Unit = {
    val array: List[Int] = List(5, 2, 3, 8, 1, 0, 3, 7)
    println(array);
    val result1 = ListBuffer[Int]()
    searchTailRecursion(array, 0, result1)
    println(result1)
    val result2 = ListBuffer[Int]()
    result2 ++= searchNonTailRecursion(array, 0)
    println(result2)
  }

  def searchTailRecursion (array: List[Int], arrayIndex: Int, result: ListBuffer[Int]): Any = {
    if (arrayIndex == 8){
      return null
    }
    if(arrayIndex == 0 || arrayIndex == 1) {
      result += array(arrayIndex)
      return searchTailRecursion(array, arrayIndex + 1, result)
    }
    if(array(arrayIndex) <= (array(arrayIndex - 2) - array(arrayIndex - 1))) {
      result += array(arrayIndex)
      return searchTailRecursion(array, arrayIndex + 1, result)
    }
    return searchTailRecursion(array, arrayIndex + 1, result)
  }
  
  def searchNonTailRecursion(array: List[Int], arrayIndex: Int): ListBuffer[Int] = {
    val result = ListBuffer[Int]()
    if (arrayIndex == 8){
      return result
    }
    if(arrayIndex == 0 || arrayIndex == 1) {
      result += array(arrayIndex)
      return result ++= searchNonTailRecursion(array, arrayIndex + 1)
    }
    if(array(arrayIndex) <= (array(arrayIndex - 2) - array(arrayIndex - 1))) {
      result += array(arrayIndex)
      return result ++= searchNonTailRecursion(array, arrayIndex + 1);

    }
    return result ++= searchNonTailRecursion(array, arrayIndex + 1)
  }
  
}