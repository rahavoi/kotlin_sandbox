package com.rahavoi

/**
 * Created by irahavoi on 2018-02-28.
 */


fun main(args: Array<String>){
    eval(Mul(Sum(Num(3), Num(5)), Sum(Num(100), Num(0))))
}



interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
class Mul(val left: Expr, val right: Expr) : Expr


fun eval(e: Expr) : Int =

    when(e){
        is Num ->  {
            e.value
        }
        is Sum -> {
            val result =eval(e.left) + eval(e.right)

            println(result)

            result
        }
        is Mul -> {
            val result =eval(e.left) * eval(e.right)

            println(result)

            result

        }
        else -> throw IllegalArgumentException("Invalid Expression!")

    }

