package com.rahavoi

import java.io.BufferedReader
import java.io.StringReader

fun main(args: Array<String>){
    exceptionsDemo(BufferedReader(StringReader("NaN")))
}

fun exceptionsDemo(reader: BufferedReader){ //In Kotlin there is no throws declaration. If you need to handle exception, you handle it, otherwise you don't
    val number = try { //try can be an expression and it can return a value. It can also be used the same way as in Java.
        Integer.parseInt(reader.readLine())
    } catch (e:NumberFormatException){
        -1 //this will be assigned to number in case of NFE
    }

    println(number)
}