package lec2


object SimpleTwo extends App {
// task 1: Dynamic Polymorphism
// Implement a class hierarchy, according to the company.png UML diagram
// Implement method def speak():Unit, which will display "I'm an employee", for example

  trait Speakable {
    val name: String
    val message = "I'm "
    def speak {println(message + name)}
  }
  
  trait Person extends Speakable {
    override val name = "a person"
  }

  trait Employee extends Person {
    override val name = "an employee"
  }

  trait Engineer extends Speakable {
    override val name = "an egineer"
  }

  trait Founder extends Person with Engineer {
    override val name = "a founder"
  }

  trait Investor extends Speakable {
    override val name = "an investor"
  }

  trait Owner extends Investor with Founder {
    override val name = "an owner"
  }

  trait Manager extends Employee {
    override val name = "a manager"
  }

  trait Coworker extends Owner with Manager {
    override val name = "a coworker"
  }

  class Test extends Coworker {}
  val t = new Test()
  t.speak

// task2: Parametric Polymorphism
// Implement a correct version of the less() method for Int and String types

//class Duo[T] (first:T, second:T) {

//  def less ():T = {
//    if ( first < second ) first else second
//  }
//
//}

  class Duo[T](first: T, second: T)(implicit ord: Ordering[T]) {
    def less(): T = {
      if (ord.lt(first, second)) first else second
    }
  }

  val p = new Duo("d", "c")
  val d = new Duo(1.1, 2.2)
  println(p.less())
  println(d.less())

// task 3: Ad-hoc Polymorphism
// Reimplement the reduce function from lec1 home work with ad-hoc Polymorphism. Implement both handwritten and library solutions

  trait Addable[T] {
    def plus(v: Vector[T]): T
  }

  object Addable {
    implicit object AddableString extends Addable[String] {
      override def plus(v: Vector[String]) = {
        v.mkString("")
      }
    }

    implicit object AddableInt extends Addable[Int] {
      override def plus(v: Vector[Int]) = {
        v.sum
      }
    }
  }

  def ownReduce[T](v: Vector[T])(implicit ev: Addable[T]) = {
    ev.plus(v)
  }

  val data = Vector(-1, 2, 4)
  val dataStr = Vector("a", "b", "c")

  val res11 = ownReduce(dataStr)
  println(res11)

}

