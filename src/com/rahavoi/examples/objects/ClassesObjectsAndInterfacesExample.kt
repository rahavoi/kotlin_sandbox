package com.rahavoi.examples.objects

/**
 * Created by irahavoi on 2018-03-06.
 */

fun main(args: Array<String>){
    val button = Button()

    button.about()
    button.focus()
    button.click()

    val client = Client("username", "k2m2k2")

    println(client.copy(name = "New name").toString()) //Because Client is declared as data class, all convenience methods are already implemented
}

interface Clickable{
    fun click()

    fun about() = println("I'm Clickable! (Bro, no need for 'default' keyword in default methods, just provide implementation. Pretty cool, eh?)")
}


interface Focusable{
    fun about() = println("I'm focusable.")

    fun focus() = println("I've been focused!")
}

//':' <- Kotlin uses the colon instead of "extends" and "implements" keywords
//classes and methods are final by default in Kotlin. TO allow extend/override, use keyword 'open'
open class Button : Clickable, Focusable{
    //override modifier is used instead of @Override. Unlike Java, it is mandatory.
    //Which makes sense: you can't accidentally override the method, compiler will protect you from this.
    override fun click() {
        println("Button clicked")
    }

    override fun about(){
        println("I'm a Button. I have to implement this method, as both Clickable and Focusable have it, so compiler will not know which one to use..")
        //Super with supertype name in angle brackets: nice
        super<Clickable>.about()
        super<Focusable>.about()
    }

    //If you want to allow overriding, use open method
    open fun animate(){
        println("Pretty lame animation goes here")
    }

}

class RichButton : Button() {
    //Each member is public by default (package private default in Java is not present in Kotlin)
    override  fun animate(){
        println("Cool animation goes here")
    }
}


//Sealed classes are the classes that have ALL their children are nested in the superclass.
//You cannot extend the sealed class from outside..
sealed class Tree{
    class BinaryTree : Tree()
    class BlackRedTree : Tree()
}




//data modifier will ensure that all necessary methods are generated: equals, hashcode, toString
data class Client(val name: String, val postalcode: String)