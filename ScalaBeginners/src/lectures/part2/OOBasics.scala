package lectures.part2

object OOBasics extends App {
val person = new Person("John Bhau",45)
  val person2 = new Person("John ",35)
  println(person.age)
  person2.greet("Daniel")

  val writer = new Writer("Ash", "Raj", 1980)
  writer.fullName()

  val writer2 = new Writer("Ash", "Raj", 1980)

  val novel = new Novel("No Name", 2018, writer)
  println(novel.authorAge())
  println(novel.isWrittenBy(writer2))
  println((novel.copy(2020)).year)

  val counter = new Counter(1)
  counter.inc(5).print

  //println(counter.inc.count)

}

class Person(name :String, val age:Int){
  println(2+2)

  def greet(names: String):Unit = println(s"$name says , hi $names")
}


class Writer(firstName:String, lastName:String, val year:Int) {
  def fullName() = println(s"${this.firstName} ${this.lastName}")
}

class Novel (name:String, val year:Int, author:Writer){
  def authorAge ():Int = this.year - author.year
  def isWrittenBy(author:Writer):Boolean = this.author == author
  def copy (year: Int): Novel = new Novel(this.name, year, this.author)
}


class Counter(val count: Int){
  def inc() = {
    println("Incrementing")
    new Counter (count + 1)
  }
  def inc(x:Int): Counter = {
    if (x<=0) this
    else
      inc.inc(x-1)
  }

  def dec() : Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }
  def dec(x:Int) : Int = count - x

  def print = println(count)

}