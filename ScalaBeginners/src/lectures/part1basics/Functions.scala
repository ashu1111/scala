package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {
  def aFunction(a: String, x:Int) : String =
    a+" " +x

  println(aFunction("Hello",3))
  println(anotherFunction("hello",3))
  println(factorialFunction(20,1))
  def anotherFunction(aString:String, x:Int): String = {
    if(x==1) aString
    else aString + anotherFunction(aString, x-1)

  }
  @tailrec
  def factorialFunction(x:Int, acc:BigInt):BigInt = {
    if(x<=0) acc
    else factorialFunction(x-1, x*acc)
  }


}
