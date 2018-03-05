@file:JvmName("FunctionsExample") // <- This will change the name of the generated Java class (by default the class name will be the name of the file)

package com.rahavoi

/**
 * Created by irahavoi on 2018-03-05.
 */
fun main(args : Array<String>){
    printParams("Illia", 30, "n00b", "active") //Java style
    printParams(age = 18) // named param in the function call (skipping the default params)
    printParams(nickname = "chillwill", status = "deactivated", age = 3) //Order of the named params does not matter

}

//In kotlin you can provide default values for parameters. This way
fun printParams(name : String = "no name", age: Int, nickname: String = "no nickname", status: String = "unknown"){
    println("Name: $name")
    println("Age: $age")
    println("Nickname: $nickname")
    println("Status: $status")
}