package com.birujung.universe

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var namaEditText: EditText
    private lateinit var npmEditText: EditText
    private lateinit var angkatanEditText: EditText
    private lateinit var programStudiEditText: EditText
    private lateinit var pembimbingAkademisEditText: EditText
    private lateinit var statusAkademisEditText: EditText
    private lateinit var submitButton: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase
        database = FirebaseDatabase.getInstance().reference

        // Initialize UI components
        namaEditText = findViewById(R.id.nama)
        npmEditText = findViewById(R.id.npm)
        angkatanEditText = findViewById(R.id.angkatan)
        programStudiEditText = findViewById(R.id.program_studi)
        pembimbingAkademisEditText = findViewById(R.id.pembimbing_akademis)
        statusAkademisEditText = findViewById(R.id.status_akademis)
        submitButton = findViewById(R.id.submit)

        submitButton.setOnClickListener {
            // When the "Submit" button is clicked, insert data into Firebase
            addStudentToFirebase()
        }
    }

    private fun addStudentToFirebase() {
        val nama = namaEditText.text.toString()
        val npm = npmEditText.text.toString().toInt()
        val angkatan = angkatanEditText.text.toString().toInt()
        val programStudi = programStudiEditText.text.toString()
        val pembimbingAkademis = pembimbingAkademisEditText.text.toString()
        val statusAkademis = statusAkademisEditText.text.toString()

        val newStudent = Student(
            Nama = nama,
            NPM = npm,
            Angkatan = angkatan,
            ProgramStudi = programStudi,
            PembimbingAkademis = pembimbingAkademis,
            StatusAkademis = statusAkademis
        )

        // Call the provided writeNewStudent function
        writeNewStudent(newStudent)

        // Clear EditText fields after insertion
        namaEditText.text.clear()
        npmEditText.text.clear()
        angkatanEditText.text.clear()
        programStudiEditText.text.clear()
        pembimbingAkademisEditText.text.clear()
        statusAkademisEditText.text.clear()
    }

    // Provided writeNewStudent function
    private fun writeNewStudent(student: Student) {
        val studentValues = student.toMap()
        database.child("students").push().setValue(studentValues)
    }
}
