object AdvancedOne extends App {

  // def Sum (vec:Vector[Int]):Int = ???

  // Task 1

  // Implement a function, which sums all elevements in the int vector in several different ways

  // With a lib function
  // Using vars
  // using immutables only
  // using for iteration
  // using recursion
  // your own idea

  def Sum(vec: Vector[Int]): Int = {
    // lib function
    val res1 = vec.sum

    // vars
    var res2: Int = 0
    var i: Int = 0
    while (i < vec.length) {
      res2 += vec(i)
      i += 1
    }

    // immutables
    val res3: Int = vec.foldLeft(0)(_ + _)

    // for iteration
    var res4: Int = 0

    for (value <- vec)
      res4 += value

    // recursion
    def recursiveSum(vec2: Vector[Int]): Int = {
      if (vec2.isEmpty) 0
      else {
        vec2(vec2.length - 1) + recursiveSum(vec2.dropRight(1))
      }
    }
    val res5: Int = recursiveSum(vec)

    // your own idea(foreach)
    var res6: Int = 0
    vec.foreach(res6 += _)

    res1

  }

  val nums = Vector(1, 2, 3)

}

