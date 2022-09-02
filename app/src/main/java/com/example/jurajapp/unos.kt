package com.example.jurajapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged

class Unos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unos)
        val igra1 = findViewById<EditText>(R.id.igra1)
        val igra2 = findViewById<EditText>(R.id.igra2)
        val zvanje1 = findViewById<EditText>(R.id.zvanje1)
        val zvanje2 = findViewById<EditText>(R.id.zvanje2)
        val bodovi1 = findViewById<TextView>(R.id.bodovi1)
        val bodovi2 = findViewById<TextView>(R.id.bodovi2)
        val unesi = findViewById<Button>(R.id.prebaci)
        val izracunaj = findViewById<Button>(R.id.izracunaj)

        var igramain1 = intent.getIntExtra("main1",0)
        var igramain2 = intent.getIntExtra("main2",0)
        var zbroj1 = Sum("zbr1",igramain1)
        var zbroj2 = Sum("zbr2",igramain2)
        var rezultat1 = intent.getIntExtra("rez1",0)
        var rez1 = Sum("ukupnirezultatigre1",rezultat1)
        var rezultat2 = intent.getIntExtra("rez2",0)
        var rez2 = Sum("ukupnirezultatigre2",rezultat2)

        igra1.doOnTextChanged { text, start, before, count ->
            val rez1 = (162 - (igra1.text.toString().toIntOrNull() ?: 0)).toString()
            if (igra2.text.toString() != rez1) {
                igra2.setText(rez1)
            }
            val uk1 = ((igra1.text.toString().toIntOrNull()?:0) + (zvanje1.text.toString().toIntOrNull()?:0)).toString()
            if(bodovi1.text.toString() != uk1)
            {
                bodovi1.text = uk1
            }
        }

   igra2.doOnTextChanged { text, start, before, count ->
       val rez2 = (162 - (igra2.text.toString().toIntOrNull() ?: 0)).toString()
       if(igra1.text.toString() != rez2){
           igra1.setText(rez2)
       }
       val uk2 = ((igra2.text.toString().toIntOrNull()?:0) + (zvanje2.text.toString().toIntOrNull()?:0)).toString()
       if(bodovi2.text.toString() != uk2)
       {
           bodovi2.text = uk2
       }
   }

   izracunaj.setOnClickListener {
       bodovi1.text = ((igra1.text.toString().toIntOrNull()?:0)?.plus((zvanje1.text.toString().toIntOrNull())?:0)).toString()
       bodovi2.text =((igra2.text.toString().toIntOrNull()?:0)?.plus(zvanje2.text.toString().toIntOrNull()?:0)).toString()

   }

   unesi.setOnClickListener {
       val intent2 = Intent(this, MainActivity::class.java)
       zbroj1.zbroj += (igra1.text.toString().toIntOrNull()?:0) + (zvanje1.text.toString().toIntOrNull()?:0)
       zbroj2.zbroj += (igra2.text.toString().toIntOrNull()?:0) + (zvanje2.text.toString().toIntOrNull()?:0)
       if(usporedi(zbroj1.zbroj)) {
           zbroj1.zbroj = 0
           zbroj2.zbroj = 0
           rez1.zbroj += 1
       }
       if(usporedi(zbroj2.zbroj)) {
           zbroj1.zbroj = 0
           zbroj2.zbroj = 0
           rez2.zbroj += 1
       }

       intent2.putExtra("igra1", zbroj1.zbroj)
       intent2.putExtra("igra2", zbroj2.zbroj)
       intent2.putExtra("povecaj1", rez1.zbroj)
       intent2.putExtra("povecaj2", rez2.zbroj)
       startActivity(intent2)

   }

}
private fun usporedi(i: Int): Boolean {
   if(i>=1001) {
       return true
   }
   return false
}


}