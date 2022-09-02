package com.example.jurajapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tim1bodovi = findViewById<TextView>(R.id.tim1bodovi)
        val tim2bodovi = findViewById<TextView>(R.id.tim2bodovi)
        val tim1rezultat = findViewById<TextView>(R.id.tim1rezultat)
        val tim2rezultat = findViewById<TextView>(R.id.tim2rezultat)
        val obrisi = findViewById<Button>(R.id.obrisibutton)


        var sum1 = intent.getIntExtra("igra1",0)
        var sum2 = intent.getIntExtra("igra2",0)
        tim1bodovi.text = sum1.toString()
        tim2bodovi.text = sum2.toString()

        var pobjeda1 = intent.getIntExtra("povecaj1",0)
        var pobjeda2 = intent.getIntExtra("povecaj2",0)
        tim1rezultat.text = pobjeda1.toString()
        tim2rezultat.text = pobjeda2.toString()

        val button = findViewById<Button>(R.id.noviunos)
        button.setOnClickListener {
            val intent1 = Intent(this, Unos::class.java)
            intent1.putExtra("main1", sum1)
            intent1.putExtra("main2", sum2)
            intent1.putExtra("rez1",pobjeda1)
            intent1.putExtra("rez2",pobjeda2)
            startActivity(intent1)
        }

        obrisi.setOnClickListener {
            tim1bodovi.text = "0"
            tim2bodovi.text = "0"
            tim1rezultat.text = "0"
            tim2rezultat.text = "0"
            sum1 = 0
            sum2 = 0
            pobjeda1 = 0
            pobjeda2 = 0
        }

    }
}