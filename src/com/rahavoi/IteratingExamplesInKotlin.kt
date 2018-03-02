package com.rahavoi

import java.util.*

/**
 * Example of a for loop in Kotlin using downTo and step
 */
fun main(args: Array<String>){
    //for (i in 1 .. 1000 step 2) println(fizzBuzz(i))
    //Same as:
    //for (i in 1 until 1000 step 2) println(fizzBuzz(i))
    //Reverse:
    //for (i in 1000 downTo 1 step 2) println(fizzBuzz(i))

    //iteratingAMap()

    //iteratingAListWithIndex()

    println(inCheckExample('W'))
    println(isNotADigit('9'))

    //Ranges are not limited to primitives. If objects can be compared, we can use them in ranges:
    println("Kotlin" in "Java" .. "Scala")

    //Same with Collections
    println("Kotlin" in setOf("Java", "Scala"))
}


fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun iteratingAMap(){
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A' .. 'Z'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps.put(c, binary)
    }

    for((letter, binary) in binaryReps){
        println("$letter -> $binary")
    }
}

fun iteratingAListWithIndex(){
    val list = arrayListOf("10", "20", "30", "40", "50")

    for((index, element) in list.withIndex()){
        println("$index: $element")
    }
}

fun isNotADigit(c: Char) = c !in '0' .. '9'

fun inCheckExample(c: Char) = c in 'a' .. 'z' || c in 'A' .. 'Z'