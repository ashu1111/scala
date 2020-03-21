package lectures.part2

object Exceptions extends App {

  val value: String = throw new OutOfMemoryError()
  println(value)

}
