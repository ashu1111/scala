package lectures.part1basics

object ValuesTypesVariable extends App {

  val x: Int = 5
  println("The value of x is " +x)


  def amethod() : Int = x

  println("Value from method is " +amethod())

}
