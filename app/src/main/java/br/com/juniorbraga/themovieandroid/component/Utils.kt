package br.com.juniorbraga.themovieandroid.component

fun percentView(totalPercent: Int, percent: Int): Int {
    var returnPercent = totalPercent / 100
    returnPercent = returnPercent * percent
    return returnPercent
}