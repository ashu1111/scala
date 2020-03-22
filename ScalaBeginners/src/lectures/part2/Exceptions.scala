package lectures.part2

object Exceptions extends App {

  //val value: String = throw new OutOfMemoryError()

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  object PocketCalculator {
    def add (x:Int, y:Int) = {
      val result = x + y
      if (x>0 && y>0 && result<0) throw new OverflowException
      else if (x<0 && y <0 && result>0) throw new UnderflowException
      else result
    }

  }

  println(PocketCalculator.add(Int.MaxValue,4))
}


