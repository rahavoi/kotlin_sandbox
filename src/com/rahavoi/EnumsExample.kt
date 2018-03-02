package com.rahavoi

/**
 * Created by irahavoi on 2018-02-28.
 */

fun main(args: Array<String>){
    println(getFavoriteMovie(FamMember.SONIA))
}

fun getFavoriteMovie(member : FamMember) =
    when(member) {
        FamMember.ILLIA,
        FamMember.MIKE -> "Simpsons"
        FamMember.NADIA -> "Friends"
        else -> "Walking dead"
    }

enum class FamMember(val role : String, val motto: String){
    ILLIA("father", "Another day, another dollar"),
    NADIA("mother", "Carpe diem"),
    SONIA("daughter", "Shine bright"),
    MIKE("son", "eat, play, sleep, repeat");

    fun talk(){
        println(this.motto)
    }
}