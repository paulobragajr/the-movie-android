package br.com.juniorbraga.themovieandroid.component

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun percentView(totalPercent: Int, percent: Int): Int {
    var returnPercent = totalPercent / 100
    returnPercent = returnPercent * percent
    return returnPercent
}

fun <T> merge(first: List<T>, second: List<T>): List<T> {
    val list: MutableList<T> = ArrayList()
    list.addAll(first!!)
    list.addAll(second!!)
    return list
}

fun showSimpleDialog(context: Context, message: String, listener: (Any, Any) -> Unit) {
    var alertDialog = AlertDialog.Builder(context)
    alertDialog.setTitle("Error")
    alertDialog.setMessage(message)
    alertDialog.setPositiveButton("OK", { _, _ -> })
    alertDialog.setNegativeButton("Repetir", listener)
    alertDialog.show()
}