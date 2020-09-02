/*
                  "Head First Kotlin"
        Chapter 6 "Abstract Classes and Interfaces"
 */

interface Roamable {
    fun roam(myDestination: String)
}

abstract class Animal: Roamable {
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    abstract val hunger: Int

    abstract fun makeNoise()
    abstract fun eat()
    override fun roam(myDestination: String) { // fun in the interface!?
        println("The " +  Animal::class + " is roaming " + myDestination)
    }
    abstract fun sleep()
}

class Hippo(): Animal() { //forgot to make this a kind of an animal! (so it had no roam())
    override val image="Hippo.jpg"
    override val food="Grass, Alga"
    override val habitat="Rivers, Lakes"
    override val hunger=10
    val className="Hippo" // in which property or interface or where is this really?

    override fun makeNoise() {
        println("" + this + " says: Grunt! Grunt!")
    }
    override fun eat() {
        println("" + this + " is eating.")
    }
    override fun roam(myDestination: String) { // override the fun in the interface?
        // compiler says "roam" is a "member of supertype 'Animal' and needs 'override' modifier

        //super.roam() <-compiler says: "Abstract member cannot be accessed directly."
        //println("(the "+className+" roams like any animal)")
        // again forgot how to include 'me is a kind of...' in the string. Repeating the class name is error prone!
        println("" + this + " is roaming " + myDestination)
    }
    override fun sleep() {
        println("" + this + " is sleeping.")
    }
}

fun main(args: Array<String>) {
    var h1=Hippo()
    println("main() function of Interfaces.kt")
    h1.makeNoise()
    h1.eat()
    h1.roam("to the next lake.")
    h1.sleep()
}
