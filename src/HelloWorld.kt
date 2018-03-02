import com.rahavoi.Person
import com.rahavoi.createZombies

/**
 * Created by irahavoi on 2018-02-28.
 */

fun main(args: Array<String>){
    val name = if(args.isNotEmpty()) args[0] else "World"
    val zombieCount:Int = if(args.size > 1) args[1].toInt() else 100

    val person = Person(name)

    println("Hello, ${person.name}, nice to meet you.")

    createZombies(zombieCount)
            .forEach { zombie -> println("Watch out, ${person.name}, ${zombie.name} wants to eat your brain") }
}

//fun max(a: Int, b: Int) = if(a > b) a else b
