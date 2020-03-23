package lectures.part3

object ScalaFunction extends App {

  val concatenate: ((String,String) => String) = new Function2[String, String,String] {
    override def apply(a:String, b:String):String = a + b

  }
  println(concatenate("Hello" , " World"))

//  trait MyFunction[Int]{
//    def apply(element:Int): Int = element
//  }
/*

val functionOnFunction: Function1[Int, Function1[Int,Int]] = new Function1[Int, Function1[Int,Int]]{
      override def apply(element : Int):Function1[Int, Int] = new Function1[Int,Int] {
        override def apply(aVal:Int): Int = element * aVal
    }

 */
// val functionOnFunction: (Int) => ((Int) => Int) = (element: Int) => (aVal: Int) => element * aVal
  val functionOnFunction = (element: Int) => (aVal: Int) => element * aVal
  //val doubler: (Int) => Int = (x: Int) => x * 2
  val doubler = (x: Int) => x * 2

  val incrementer= (x:Int) => x + 1
  /*
  OR
  val incrementer: Int => Int = x => x+1

   */
  val moarSyntacticIncrementer : Int => Int = _ + 1

  val moarSyntacticAdder: (Int,Int)=>Int = _ + _


  println(doubler(functionOnFunction(3)(4)))

  println(moarSyntacticIncrementer(incrementer(5)))

  println(moarSyntacticAdder(3,5))

}
