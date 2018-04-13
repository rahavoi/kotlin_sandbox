package com.rahavoi.examples.objects



fun main(args: Array<String>){
    val  bob = Employee("Bob", "Developer", 100500)

    /**
     * In Kotlin data classes have a convenience function called copy.
     * It allows to create a clone of your immutable (val) data object and if needed, override certain values.
     */
    val illia = bob.copy(name = "Illia", salary = 1000000)

    Payroll.allEmployees.add(bob)
    Payroll.allEmployees.add(illia)

    Payroll.printSalaries()

    AClass.Helper.foo() //calling companion object functions in Kotlin is very similar to calling class static methods in Java
    AClass.foo()  //Name of the companion object is optional and can be omitted

    AClass.currentTime() //accessing extension function

}

data class Employee(val name: String, val title: String, val salary: Int)


/*
Object declaration in Kotlin is defining a singleton
Just like a class, an object declaration can contain declarations of properties, methods,
initializer blocks, and so on. The only things that aren’t allowed are constructors (either
primary or secondary). Unlike instances of regular classes, object declarations are created
immediately at the point of definition, not through constructor calls from other places in
the code. Therefore, defining a constructor for an object declaration doesn’t make sense.

Objects can extend classes and implement interfaces.
 */
object Payroll {
    val allEmployees = arrayListOf<Employee>()

    fun printSalaries(){
        for(empl in allEmployees){
            //some logic here
            println(empl.name + ": " +empl.salary)
        }
    }
}


class AClass{

    //Companion objects are no different from regular Kotlin objects. They can implement interfaces, have extension functions..
    companion object Helper {
        fun foo(){
            println("Foo can be called from class AClass")
        }
    }
}


//Defining an extension function on companion object
fun AClass.Helper.currentTime(){
    println("Current time in ms: " +System.currentTimeMillis())
}