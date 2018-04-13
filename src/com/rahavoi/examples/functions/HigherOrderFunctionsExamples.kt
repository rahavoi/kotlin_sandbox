package com.rahavoi.examples.functions

fun main(args: Array<String>){
    //Compiler can infer function types on the fly:
    val sum = {x: Int, y: Int -> x+y}

    higherExample(sum)

    //You can return a function from your function:
    val aFunction = getSomeMathFunction()
    println(aFunction(4))
}


//Higher-order function is a function that can accept lambdas ar arguments or return a lambda
fun higherExample(aLambda : (Int, Int) -> Int){
    println(aLambda(2,3))
}


fun getSomeMathFunction(): (Int) -> Int {
    return { x:Int -> x * x }
}