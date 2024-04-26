package com.foxbit

import com.foxbit.flog.Flog

fun main() {

    val flog: Flog = Flog()

    flog.log("Hello, World. This is a Test!")

    flog.setLevel(2)

    flog.log("Error while writing file xyz to folder abc.")

    println("Hello World!")
}