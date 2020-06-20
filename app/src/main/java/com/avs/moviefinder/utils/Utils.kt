package com.avs.moviefinder.utils

import java.math.BigDecimal
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun formatDate(dateToFormat: String) : String {
    val inputFormat: DateFormat = SimpleDateFormat("yyyy-mm-dd", Locale.US)
    val outputFormat: DateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.US)
    val date: Date?
    var formattedDate = dateToFormat
    try {
        date = inputFormat.parse(dateToFormat)
        formattedDate = outputFormat.format(date)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return formattedDate
}

fun round(value: String, decimalPlace: Int): Double {
    var number = BigDecimal(value)
    number = number.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP)
    return number.toDouble()
}

fun formatRating(number: String) : String {
    if (number.contains("-")) {
        return ""
    }
    var result = round(number, 2).toString()
    if (result.contains('.') && result.endsWith('0')) {
        var i = result.length - 1
        while (result[i] == '0') {
            i -= 1
        }
        result = result.substring(0, i + 1)
    }
    if (result.endsWith('.')) {
        result = result.substring(0, result.length - 1)
    }
    return result
}