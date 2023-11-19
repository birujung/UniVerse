package com.birujung.universe

import com.google.firebase.database.*

@IgnoreExtraProperties
data class Student(
    var Nama: String? = "",
    var NPM: Int? = 0,
    var Angkatan: Int? = 0,
    var ProgramStudi: String? = "",
    var PembimbingAkademis: String? = "",
    var StatusAkademis: String? = ""
) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Nama" to Nama,
            "NPM" to NPM,
            "Angkatan" to Angkatan,
            "ProgramStudi" to ProgramStudi,
            "PembimbingAkademis" to PembimbingAkademis,
            "StatusAkademis" to StatusAkademis
        )
    }
}

