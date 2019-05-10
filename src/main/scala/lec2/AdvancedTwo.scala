package lec2


object AdvancedTwo extends App {
// task 1: Implement the method for Vector[Int] and List[Int]
//  sealed abstract class Addable[A] {
//    def sum:A
//  }
//
//
//  class MyAddable[A] () extends Addable[A] {
//    override def sum:A
//  }
//
//  val myvec   = Vector (1,2,3)
//  val mylist  = List   (1,2,3)
//
//  val inst  = new MyAddable
//
//  val res0  = inst.sum(mylist)
//  val res1  = inst.sum(myvec)
//
//  println (s"res0 = $res0")
//  println (s"res1 = $res1")

  sealed abstract class Addable[A] {
    def sum(el: Seq[A]): A
  }

  class IntAddable extends Addable[Int] { // Allow automatic type derivation
    def sum(el: Seq[Int]): Int = {
      el.sum
    }
  }

  val myvec = Vector(1, 2, 3)
  val mylist = List (1, 2, 3)

  val mymap = Map ( 1 -> "one",
                    2 -> "two",
                    3 -> "three"
                  )

  val inst = new IntAddable

  val res0 = inst.sum(mylist)
  val res1 = inst.sum(myvec)
  //val res2 = inst.sum(mymap) // this won't work, since Map is a subclass of Traversable, but NOT Iterable, like Seq

  println(s"res0 = $res0")
  println(s"res1 = $res1")


  // second solution with help of SO https://stackoverflow.com/questions/56063547/sum-of-int-elements-in-list-and-vector-using-single-function-in-scala

//sealed abstract class Addable[A] {
//def sum(el: Seq[A]): A
//}

//class MyAddable[A: Numeric]() extends Addable[A] {
//override def sum(el: Seq[A]): A = {
//el.sum
//}
//}

//val myvec = Vector(1, 2, 3)
//val mylist = List(1, 2, 3)

//val inst = new MyAddable[Int]()

//val res0 = inst.sum(mylist)
//val res1 = inst.sum(myvec)

//println(s"res0 = $res0")
//println(s"res1 = $res1")

}

