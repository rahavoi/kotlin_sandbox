package com.rahavoi.examples.objects

/**
 * Created by irahavoi on 2018-03-09.
 */
fun main(args: Array<String>){
    val people = listOf(Person("Illia", 31), Person("Nadia", 32), Person("Mike", 2), Person("Sonia", 6))

    //
    println(people.joinToString { p:Person -> p.name })
    //Same same but shorter:
    println(people.joinToString { it.name })

    //Kotlin provides some convenience methods for collections:
    //var oldest = people.maxBy { Person::age }
    //Same ("it" is an autogenerated argument name.)
    var oldest = people.maxBy { it.age }
    println("The oldest in the family is ${oldest?.name}(${oldest?.age})")

    //storing lambdas in a variable:
    val sum = {a: Int, b: Int -> a + b}

    println(sum(5 , 5))

    //Lambdas can be created and called directly (but why?):
    //{ println("I do not see any value in this") }()
    //Or like this:
    run{
        println("Doh")
    }

    //Referencing a top-level function with ::
    var coolLambdaExample = :: accessingAndModifyingVariablesFromLambda

    //Referencing a constructor:
    val createPerson = ::Person

    val p = createPerson("Joe", 10)

    coolLambdaExample()
}


fun accessingAndModifyingVariablesFromLambda() {
    println("No more: 'Variable used in lambda expression should be final or effectively final'!")
    var count = 0

    listOf(1, 2, 3, 4, 5).forEach({
        count += 2
        println("Look, ma, I'm accessing and modifying non-final var from lambda: $count")
    })

}

data class Person(val name: String, var age: Int)