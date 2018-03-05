@file:JvmName("FunctionsExample") // <- This will change the name of the generated Java class (by default the class name will be the name of the file)

package com.rahavoi

/**
 * Created by irahavoi on 2018-03-05.
 */
fun main(args : Array<String>){
    printParams("Illia", 30, "n00b", "active") //Java style
    printParams(age = 18) // named param in the function call (skipping the default params)
    printParams(nickname = "chillwill", status = "deactivated", age = 3) //Order of the named params does not matter

    println("It's a good day".toCanadianPhrase())

    var strings : List<String> = listOf("one", "two", "three")

    println(strings.last()) //Kotlin uses implementation of standard Java collections but adds extra functions to them.

    localFunctionExample("what's up")

    tripleQuoteSyntaxExample()
}

//In kotlin you can provide default values for parameters. This way
fun printParams(name : String = "no name", age: Int, nickname: String = "no nickname", status: String = "unknown"){
    println("Name: $name")
    println("Age: $age")
    println("Nickname: $nickname")
    println("Status: $status")
}

//Extension function example: Kotlin allows to add new methods to exising classes!
// (Unlike real methods, extension cannot access private members, so encapsulation is not breaking)
//Extension functions are not becoming available across the project: You have to explicitly import them.
//You can change the name of the extension function in the import statement:
//import strings.lastChar as last
//Under the hood (when compiled) extenstion functions become static methods that accept the extended object.
//That's why extension functions cannot be overridden.
fun String.toCanadianPhrase() = this + ", eh?"



fun infixCallsExample(){
    //Syntactic sugar of Infix method calls:
    //1 to "One" is equivalent to 1.to("one")
    //method to returns a Pair of any elements.
    //Infix calls can be used with regular methods that require one parameter.
    val map = mapOf(1 to "One", 7 to "seven", 53.to("fifty three"))
}


fun localFunctionExample(msg: String){
    val testParam = "test"

    fun aNicelittleNestedFunction(){
        println("Look, I have access to all access and parameters of the eclosing function: $msg, $testParam")
    }

    aNicelittleNestedFunction()
}



//Nice to have for multi-line strings
fun tripleQuoteSyntaxExample(){
    val str = """



        Summary:
        Kotlin doesn’t define its own collection classes and instead extends the Java collection
        classes with a richer API.
        Defining default values for function parameters greatly reduces the need to define
        overloaded functions, and the named-argument syntax makes calls to functions with
        many parameters much more readable.
        Functions and properties can be declared directly in a file, not just as members of a class,
        allowing for a more flexible code structure.
        Extension functions and properties let you extend the API of any class, including classes
        defined in external libraries, without modifying its source code and with no runtime
        overhead.
        Infix calls provide a clean syntax for calling operator-like methods with a single
        argument.
        Kotlin provides a large number of convenient string-handling functions for both regular
        expressions and plain strings.
        Triple-quoted strings provide a clean way to write expressions that would require a lot of
        noisy escaping and string concatenation in Java.
        Local functions help you structure your code more cleanly and eliminate duplication.
    """

    println(str)
}

