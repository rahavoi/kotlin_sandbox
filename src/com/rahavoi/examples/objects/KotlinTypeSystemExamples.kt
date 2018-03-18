package com.rahavoi.examples.objects

fun main(args: Array<String>){



    //Kotlin tries to protect you from NPE by introducing nullable types. You have to explicitly
    //Allow the value to be nullable. Otherwise compiler will complain if the non-nulllable type is null.
    //Therefore NPE becomes compile-time error, not runtime.
    //printLength(null) //compiler: null cannot be a value of non-null type String
    //printLengthToleratingNulls(null)

    elvisOperatorExample(null)

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