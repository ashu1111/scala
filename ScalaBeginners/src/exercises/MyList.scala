package exercises

abstract class MyList[+A] {
  def head(): A
  def tail(): MyList[A]
  def isEmpty: Boolean
  def add[B>:A](element: B): MyList[B]
  def printElements : String
  override def toString: String = "[ " +printElements+ " ]"
  def map[B] (transformer : MyTransformer [A,B]) : MyList[B]
 // def flatMap[B](transformer: MyTransformer [A, MyList[B]]):MyList[B]
  def filter(predicate: MyPredicate[A]) : MyList[A]

  def ++[B>:A] (list: MyList[B] ) : MyList[B]
}

 object MyArray extends MyList[Nothing] {
   override def head(): Nothing = throw new NoSuchElementException
   override def tail(): MyList[Nothing] = throw new NoSuchElementException
   override def isEmpty: Boolean = true
   override def add[B>:Nothing](element: B): MyList[B] = new Cons(element, MyArray)
   //override def toString: String = "To be implemented"
   override def printElements: String = "List is Empty"
   override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = MyArray
  // override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = MyArray
   override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = MyArray

   override def ++[B >: Nothing](list: MyList[B]): MyList[B] = MyArray
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

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons (transformer.transform(head), tail.map(transformer))
  }

  //override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = ???

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(head)) new Cons(head, tail.filter(predicate))
    else tail.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(head, tail ++ list)

}


trait MyPredicate[-T]{
  def test(elem: T) : Boolean
}

trait MyTransformer[-A,B]{
  def transform(elem: A) : B

}

object ListTest extends App {

  val intList: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, MyArray)))
  val stringList = new Cons("Hello", new Cons("Scala", new Cons("Done", MyArray)))
  println(intList.toString())
  println(stringList.toString)

  println(intList.map((elem: Int) => elem * 2))

  println (intList.filter((elem: Int) => elem % 2 == 0))

  val anotherIntList : MyList[Int] =  new Cons(4,new Cons(5, new Cons(6,MyArray)))

  println (( anotherIntList ++ intList).toString)


}
