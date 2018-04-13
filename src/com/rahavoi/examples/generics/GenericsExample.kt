package com.rahavoi.examples.generics

import org.omg.CORBA.INTERNAL

/**
 * Generics in Java are optional for collections. (to support backwards compatibility for prior to Java 1.5 versions)
 * In Kotlin they are required (must be inferred or specified explicitly)
 */
fun main(args: Array<String>){
    val people  = listOf("Illia", "Nadia") //String type has been inferred

    //As list is empty, compiler demands an explicit declaration of the type
    val numbers : MutableList<Int> = mutableListOf()
    val numbersUsingAnotherNotation = mutableListOf<Int>() //same
}