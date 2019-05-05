// Home work for Lec1: Functions in Scala
// Fix errors, rewrite functions or write your own implementations here
// bku Apr 27 2019

object Simple extends App {

  // Fix error
  //--------------------------------------------------------------------------------------------
  def Func0(a: Int): Some[Int] = {
    Some(-1 * a)
  }

  val res0: Int = Func0(7).get

  // Rewrite to accept the lambda
  //--------------------------------------------------------------------------------------------

  def Func1(f: (Int, Int) => Int): Int = {
    f(1, 2)
  }

  val res1 = Func1((x: Int, y: Int) => 2 * x + y)

  // Curry Func2 and write the full curried definition, as in Func0
  //--------------------------------------------------------------------------------------------
  def Func2(a: Int, b: Int, c: Int): Int = { a + b + c }

  // f(x) = 1/x was definied as Partially Defined Function. Rewrite it with
  // A. pattern matching
  // B. Option
  //--------------------------------------------------------------------------------------------
  def Func3a(a: Int): Option[Float] = {
    try {
      Some(1 / a)
    } catch {
      case _: Throwable => None
    }
  }
  def Func3b(a: Int): Option[Float] = a match {
    case 0 => None
    case _ => Some(1 / a)
  }

  // Higher order function (HOF) "reduce" from lecture notes returns incorrect result for the add reducer
  // correct the error and implement a valid "reduce" for add and mul reducers
  //--------------------------------------------------------------------------------------------
  def reduce(arr: Vector[Int], foldVal: Int, f: (Int, Int) => Int): Int = {

    val tmp = arr.foldLeft(foldVal) { f }
    tmp

  }

  // Reducers
  def add(a: Int, b: Int) = a + b
  def mul(a: Int, b: Int) = a * b

  val data = Vector(-1, 2, 4)

  val res10 = reduce(data, 0, add)
  println(s"res10 = $res10")

  val res11 = reduce(data, 1, mul)
  println(s"res11 = $res11")

  // Write an implicit function to support the operation below
  //--------------------------------------------------------------------------------------------

  implicit def Func4(a: Float): Int = a.toInt

  def doubleme(a: Int) = 2 * a

  val res2 = Func4(2.5F)

}

