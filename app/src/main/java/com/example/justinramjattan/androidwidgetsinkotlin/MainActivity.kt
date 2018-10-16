package com.example.justinramjattan.androidwidgetsinkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {

    lateinit var showImageButton: ImageButton
    lateinit var showImageToggleButton: ToggleButton
    lateinit var toggleImage: ImageView
    lateinit var showImage: ImageView
    lateinit var spinner: Spinner
    lateinit var marks: EditText
    lateinit var intentButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showImageButton = findViewById(R.id.showImg)
        showImageToggleButton = findViewById(R.id.toggleImg)
        toggleImage = findViewById(R.id.imgToggle)
        showImage = findViewById(R.id.clickShow)
        spinner = findViewById(R.id.spinner)
        marks = findViewById(R.id.mark)
        intentButton=findViewById(R.id.intent_button)
        intentButton.setOnClickListener (this)
        showImageButton.setOnClickListener(this)
        showImageToggleButton.setOnClickListener(this)
        spinner.onItemSelectedListener = this
    }
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val course = p0?.getItemAtPosition(p2).toString()
        when (course) {
            "COMP3150" ->marks.setText("51")
            "COMP3275" ->marks.setText("60")
            "COMP1603" ->marks.setText("86")
            "COMP1602"->marks.setText("84")
            "COMP1601" ->marks.setText("70")
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(p0: View?) {
        when (p0) {
            showImageButton -> showImage.visibility = View.VISIBLE
            showImageToggleButton -> {
                if (showImageToggleButton.isChecked)
                    toggleImage.visibility = View.VISIBLE
                else
                    toggleImage.visibility = View.INVISIBLE
            }
            intentButton ->{
                val intent= Intent(this,SecondScreen::class.java)
                intent.putExtra("message","Hello From Main Screen")
                startActivity(intent)
            }
        }
    }
}
