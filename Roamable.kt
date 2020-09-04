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
    abstract fun eat(food: String)
    override fun roam(myDestination: String) { // fun in the interface!?
        println("The " +  Animal::class + " is roaming " + myDestination)
    }
    abstract fun sleep()
}

abstract class Canine: Animal() {
    override fun roam(myDestination: String) {
        println("The Canine is roaming")
    }
}

class Wolf(): Canine() {
    override val image="Wolf.jpg"
    override val food="Meat"
    override val habitat="Forests"
    override val hunger=3
    val className="Hippo" // in which property or interface or where is this really?

    override fun makeNoise() {
        println("" + this + " says: Hooooowl!")
    }
    override fun eat(food: String) {
        println("" + this + " is eating $food.")
    }
    override fun roam(myDestination: String) {
        println("" + this + " is roaming " + myDestination)
    }
    override fun sleep() {
        println("" + this + " is sleeping.")
    }
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
    override fun eat(food: String) {
        println("" + this + " is eating $food.")
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

/*
 * 'Smart casting' pp184
 */
class MyRoamable {
    val r :Animal = Wolf() // making this a 'var' -> compiler complains when calling it,
    // because it might change between declare/create and the call later on.

    fun myFunc() {
        if (r is Wolf) {
            r.eat(r.food)
        }
    }
}


/*
 *
 */

fun main(args: Array<String>) {
    var h1=Hippo()
    println("main() function of Interfaces.kt")
    h1.makeNoise()
    h1.eat(h1.food)
    h1.roam("to the next lake.")
    h1.sleep()

    var r1 = MyRoamable()
    // 'r' is an instance of Wolf() and of class 'Animal' inside of MyClass
    r1.r.roam("into the woods.") // possible, if 'r1' is of class Roamable
    r1.r.eat(r1.r.food) // only possible, if 'r1' is ???
    r1.r.makeNoise() // 'r' will howl, because 'Animal' is abstract and 'r' is a 'Wolf'
    r1.myFunc()
}
