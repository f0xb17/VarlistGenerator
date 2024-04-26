/**
 * Flog.kt
 * Represents a simple logging library that can write all events to a corresponding file.
 *
 * Created by f0xb17 on 04/26/2024.
 * Copyright © 2024 f0xb17. All rights reserved.
 */

package com.foxbit.flog

import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Flog {
    private val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd | HH:mm:ss")
    private var level: FloggerLevel = FloggerLevel.Info

    /**
     * Sets the level to the desired error. The default is always Info, unless otherwise specified.
     * @param [level] Numerical value to determine which error type is logged.
     */
    fun setLevel(level: Int) {
        this.level = FloggerLevel.getLevel(level)
    }

    /**
     * Creates an entry with a timestamp based on an @link[event] and then attaches this line to a log file.
     * @param [event] The message to be logged.
     */
    fun log(event: String) {
        val timestamp: String = dateFormat.format(Date())
        try {
            FileWriter("logfile.txt", true).use { writer ->
                writer.appendLine("$timestamp: ${this.level} - $event")
            }
        } catch(e: IOException) {
            this.setLevel(4)
            println("$timestamp: ${this.level} - ${e.message}")
        }
    }
}