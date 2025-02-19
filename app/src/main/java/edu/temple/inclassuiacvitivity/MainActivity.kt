package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        val numberArray = IntArray(20) { i -> (i + 1) * 5 }

        /* TODO Step 3: Create adapter to display items from array in Spinner */
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, numberArray.toList())
        spinner.adapter = adapter

        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedSize = numberArray[position]

                displayTextView.textSize = selectedSize.toFloat()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }
}