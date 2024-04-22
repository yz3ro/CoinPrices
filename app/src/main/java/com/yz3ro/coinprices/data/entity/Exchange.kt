package com.yz3ro.coinprices.data.entity

data class Exchange(
    val Ccode: String,
    val FullName: String,
    val Mcode: String,
    val ShortName: String,
    val buying: Double,
    val changeRate: Double,
    val code: String,
    val dayMax: Double,
    val dayMin: Double,
    val lastupdate: String,
    val latest: Double,
    val selling: Double,
    val volume: String
)