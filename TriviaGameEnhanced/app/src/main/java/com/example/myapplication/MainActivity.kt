package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val arrOfQuestions = arrayOf(
        Question("¿El tipo de dato del atributo R.id.tvQuestion es int?", true),
        Question("¿En 'AndroidManifest.xml' se declaran los string resources?", false),
        Question("Las clases creadas por el usuario en un programa de Android Studio deben ser necesariamente .java", false),
        Question("variables creadas con 'val' NO son modificables", true),
        Question("'var' no se usa para declarar variables en Kotlin", false)
    )
    private var iterator = CircularIterator(0, arrOfQuestions.size-1);
    private var score = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        tvQuestion.text = arrOfQuestions[iterator.currentPosition].question
        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = "0"

        val btnNo = findViewById<Button>(R.id.btnNo)
        btnNo.setOnClickListener{
            if(arrOfQuestions[iterator.currentPosition].answer == false){
                score += 1
                Toast.makeText(this@MainActivity, "You are correct, No is the answer", Toast.LENGTH_SHORT).show()
                tvScore.text = "${score}"
                nextQuestion()
            }
            else{
                Toast.makeText(this@MainActivity, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        val btnYes = findViewById<Button>(R.id.btnYes)
        btnYes.setOnClickListener {
            if(arrOfQuestions[iterator.currentPosition].answer == true){
                score += 1
                Toast.makeText(this@MainActivity, "You are correct, Yes is the answer", Toast.LENGTH_SHORT).show()
                tvScore.text = "${score}"
                nextQuestion()
            }
            else{
                Toast.makeText(this@MainActivity, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun nextQuestion() {
        iterator.nextPosition()
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        tvQuestion.text = arrOfQuestions[iterator.currentPosition].question
    }
}