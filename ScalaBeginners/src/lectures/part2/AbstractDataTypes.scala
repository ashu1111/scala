package lectures.part2

import lectures.part2.AbstractDataTypes.Animal

object AbstractDataTypes extends App {

  abstract class Animal{
    val creatureType : String
    def eat : Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "domestic"

    override def eat: Unit = println("Dog eat")
  }
  val dog : Animal = new Dog
  dog.eat

  val crocodile = new Crocodile
  crocodile.eat
  crocodile.eat(dog)
  crocodile.eatable()

}

  trait Carnivore{
    def eat (animal : Animal): Unit
    def eatable () =  println ("Carnivore eatable")
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    override def eat: Unit = println("Crocodile eats")

    override def eat(animal: Animal): Unit = println(s"Crocodile eats ${animal.creatureType}")

    override def eatable(): Unit = {
      super.eatable()
      println("Crococdile eatable")
    }
  }