package com.rahavoi.examples.objects

/**
 * Created by irahavoi on 2018-03-09.
 */


fun main(args: Array<String>){
    //mapAndFilterExamples()
    //sequenceExample()
    //println(withExample())
    //println(applyExample())
    //println(alphabet())

    println(printShortSummaryAboutLambdasInKotlin())
}

private fun mapAndFilterExamples() {
    val aList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //Standard filter and map library functions:
    aList.filter { it % 2 == 0 }.map { "$it is even" }.forEach { println(it) }


    val people = listOf<Person>(Person("Illia", 31), Person("Nadia", 32), Person("Mike", 2))

    //Max By - another helpful function:
    println(people.maxBy(Person::age).toString())


    val signLanguageGroups = mapOf("German Sign" to "German Sign",
            "Polish Sign" to "German Sign",
            "Israely Sign" to "German Sign",
            //
            "Japanese Sign" to "Japanese Sign",
            "Korean Sign" to "Japanese Sign",
            "Taiwan Sign" to "Japanese Sign")


    //Maps have some helpful functions as well:
    val numberOfJapaneseSignLanguages = signLanguageGroups.filterValues { it.equals("Japanese Sign") }
            .filterKeys { it.contains("Sign") }
            .count()


    //group by:
    people.groupBy(Person::age)

    println(numberOfJapaneseSignLanguages)
}


fun sequenceExample(){

    val people = listOf<Person>(Person("Illia", 31), Person("Nadia", 32), Person("Mike", 2))
    //Filter and map functions are eager by default.

    //For higher efficiency use sequences:

    //Sequence is exactly the same concept as streams in Java 8 (Kotlin does not support parallel streams!!!)
    //For sequences all operations are applied on each element sequentially.
    //For collections, each operation creates an intermediate collection.
    people.asSequence()
            .map (Person::name) //intermidiate operation
            .filter { it.startsWith("I") } //intermidiate operation
            .toList() //terminal operation

    //Sequences support the same API as collections.
    //The elements in a sequenc are evaluated lazily:
    //This allows to create chains of operations (filter, map, etc) without creating intermediate collections for each operation.
    //As a rule, use a sequence whenever you have a chain of operations on a large collection



    //Creating a sequence:
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numsTo10000 = naturalNumbers.takeWhile { it <= 10000 }

    //sequences are laze: no calculation is happening until you call .sum() (or any other terminal operation)
    println(numsTo10000.sum())
}

//Lambdas with Receivers:
fun withExample(): String{
    return with(StringBuilder()){ //sb is a receiver for this lambda:
        for(letter in 'A' .. 'Z'){
            this.append(letter)//receiver (sb) can be accessed using this
        }
        this.append("\nNow I know the alphabet!")
        this.toString()
    }

    //'with' is not a keyword. it is just a function that takes 2 arguments: receiver and a lambda
}

//Aplpy works the same as with, the only difference is that apply returns the receiver object.
fun applyExample() = StringBuilder().apply {
        for(letter in 'A' .. 'Z'){
            append(letter)
        }

        append("\n Done!")
    }.toString()


fun printShortSummaryAboutLambdasInKotlin() = """
    Lambdas allow you to pass chunks of code as parameters to methods.
Kotlin lets you pass lambdas to methods outside of parentheses and refer to a single
lambda parameter as it.
Code in a lambda can access and modify variables in the function containing the call to
the lambda.
You can create references to methods, constructors, and properties by prefixing the name
of the function with ::, and pass such references to methods instead of lambdas.
Most common operations with collections can be performed without manually iterating
over elements, using functions such as filter, map, all, any, and so on.
Sequences allow you to combine multiple operations on a collection without creating
collections to hold intermediate results.
You can pass lambdas as arguments to methods that take a Java functional interface (an
interface with a single abstract method, also known as a SAM interface) as a parameter.
Lambdas with receivers are lambdas in which you can directly call methods on a special
receiver object.
The with standard library function allows you to call multiple methods on the same
object without repeating the reference to the object. apply lets you construct and
initialize any object using a builder-style API.
""".trimIndent()


//Elegant solution for building strings with lambda:
fun alphabet() = buildString {
    for(letter in 'A' .. 'Z'){
        append(letter)
    }

    append("\n That's it!")

}