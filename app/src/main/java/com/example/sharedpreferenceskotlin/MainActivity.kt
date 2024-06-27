package com.example.sharedpreferenceskotlin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferenceskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //You can create fully functional note app by adding recyclerView.
    //I just made a basic note app because I just want to learn "Shared Preferences" using project
    //For full note app you can check out my previous repository that is "Notes SQLite"

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPreferences = getSharedPreferences("NoteData", Context.MODE_PRIVATE)

        binding.saveNoteButton.setOnClickListener {
            val note = binding.notesEditText.text.toString()
            val sharedEdit = sharedPreferences.edit()

            sharedEdit.putString("note", note)
            sharedEdit.apply()
            binding.notesEditText.text.clear()
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

        binding.displayNoteButton.setOnClickListener {
            val displayNote = sharedPreferences.getString("note", "")
            binding.noteTextView.text = "$displayNote"
        }
    }
}