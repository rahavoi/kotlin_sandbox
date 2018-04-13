package com.rahavoi.examples.conventions

fun main(args: Array<String>){
    println(Point(10,10) + Point(20,20))
    println(Point(10,10) - Point(20,20))
}

data class Point(val x: Int, val y: Int){
    //Overloading plus operator
    operator fun plus(other: Point): Point{
        return Point(x + other.x, y + other.y)
    }

    //Overloading minus operator
    operator  fun minus(other: Point): Point{
        return Point(x - other.x, y - other.y)
    }
}