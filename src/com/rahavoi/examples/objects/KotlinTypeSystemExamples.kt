package com.rahavoi.examples.objects

fun main(args: Array<String>){



    //Kotlin tries to protect you from NPE by introducing nullable types. You have to explicitly
    //Allow the value to be nullable. Otherwise compiler will complain if the non-nulllable type is null.
    //Therefore NPE becomes compile-time error, not runtime.
    //printLength(null) //compiler: null cannot be a value of non-null type String
    //printLengthToleratingNulls(null)

    //elvisOperatorExample(null)

    //safeCastOperatorExample()

    //throws KotlinNullPointerException
    //notNullAssertionExample(null)

    letExample(null)
    letExample("ImnotNull")

    //If your class has a non-null member that is not initialized immediately in constructor,
    //you can use lateinit key word
    //(most common exampe is members that are initialize as a result of dependency injection)

}

fun printLength(msg: String){
    println("$msg: ${msg.length}")
}

//if you want to allow nullable types, you have to do it explicitly using the question mark after the arg:
fun printLengthToleratingNulls(msg: String?){
    if(msg != null){ //have to check explicitly, or compiler will complain..
        println("$msg: ${msg.length}")
    }

    //Another option is to use the safe-call operator:
    val upper = msg?.toUpperCase();

    //The statement above is equivalent to:
    val upper_ = if(msg != null){
        msg.toUpperCase()
    } else {
        null
    }

    //You can use the safe call operator to access properties:
    //country?.city?.house?.room (otherwise you'd have to have 4 null-checks here)
}

fun elvisOperatorExample(msg: String?){
    //?: - elvis operator that defines the default value instead of null:
    //println(msg ?: "Nothing to say")

    //Elvis operator can be used to throw exceptions:
    msg ?: throw IllegalArgumentException("Null msg is not allowed!")
}
//The as? operator tries to cast a value to the specified type and returns null if the
//value doesn’t have the proper type.
fun safeCastOperatorExample(){
  val test = 2;

  val strResult = test as? String
  println(strResult)

  val intResult = test as? Int
  println(intResult)

  //often combined with elvis operator:
  val result = test as? String ?: "not a string"
  println(result)
}

fun notNullAssertionExample(arg : String?){
    //Well, double exclamation marks are ugly: "I know the value  isn’t null, and I’m ready for an exception if it turns out I’m wrong."
    val sNotNull : String = arg!!

    println(sNotNull.length)
}

/**
 * All the
let function does is turn the object on which it’s called into a parameter of the lambda. If
you combine it with the safe call syntax, it effectively converts an object of a nullable
type on which you call let into a non-null type

 Elegant null check solution:
 */
fun letExample(arg : String?){
    arg?.let { println(it) }
}