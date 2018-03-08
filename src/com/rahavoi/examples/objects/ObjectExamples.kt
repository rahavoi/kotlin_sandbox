package com.rahavoi.examples.objects

/**
 * Summary:
 * Interfaces in Kotlin are similar to Java’s but can contain default implementations and
properties.
All declarations are final and publicby default.
To make a declaration non-final, mark it as open.
internal declarations are visible in the same module.
Nested classes aren’t inner by default. Use the keyword inner to store a reference to an
outer class.
A sealed class can only have subclasses nested in its declaration.
Initializer blocks and secondary constructors provide flexibility for initializing class
instances.
You use the field identifier to reference a property backing field from the accessor
body.
Data classes provide compiler-generated equals(), hashCode(), toString(), copy(),
and other methods.
Class delegation helps to avoid many similar delegating methods in your code.
Object declaration is Kotlin’s way to define a singleton class.
Companion objects (along with package-level functions and properties) replace Java’s
static method and field definitions.
Companion objects, like other objects, can implement interfaces or have extension
functions or properties.
Object expressions are Kotlin’s replacement for Java’s anonymous inner classes, with
added power such as the ability to implement multiple interfaces
 */

fun main(args: Array<String>){
    A.foo() //All methods of companion object are accessible from the outer class.


    //An anonymous object
    val clk = object : Clickable {
        override fun click(){}
    }

}

class A {
    companion object FooShouter{
        fun foo(){
            println("Foo!")
        }
    }
}


//The easiest way to declare a singleton:
//Constructors are not allowed for objects
//But they can extend classes and interfaces
object SingletonButton : Button(){
    override fun click() {
        super.click()
    }
}