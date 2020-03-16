package exercises

abstract class MyList[+A] {

  def head(): A

  def tail(): MyList[A]

  def isEmpty: Boolean

  def add[B>:A](element: B): MyList[B]
  def printElements : String

  override def toString: String = "[ " +printElements+ " ]"
}

 object MyArray extends MyList[Nothing] {
   override def head(): Nothing = throw new NoSuchElementException

   override def tail(): MyList[Nothing] = throw new NoSuchElementException

   override def isEmpty: Boolean = true

   override def add[B>:Nothing](element: B): MyList[B] = new Cons(element, MyArray)

   //override def toString: String = "To be implemented"
   override def printElements: String = "List is Empty"
 }

class Cons[+A] (head: A, tail : MyList[A]) extends MyList[A] {
  override def head(): A = head

  override def tail(): MyList[A] = tail

  override def isEmpty: Boolean = false

  override def add[B>:A](element: B): MyList[B] = new Cons(element, this)
  //override def toString: String = "To be implemented"
  override def printElements: String = {
    if (tail.isEmpty) ""+head
     else
       head + " " +tail.printElements
  }
}


object ListTest extends App {

  val intList = new Cons(1, new Cons(2, new Cons(3, MyArray)))
  val stringList = new Cons("Hello", new Cons("Scala", new Cons("Done", MyArray)))
  println(intList.toString())
  println(stringList.toString)


}
