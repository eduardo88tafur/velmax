package com.tafur.velmax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {

    lateinit var btnSearch: Button
    lateinit var imageDelivery: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnSearch = findViewById(R.id.btnSearch)
        imageDelivery = findViewById(R.id.imageDelivery)

        btnSearch.setOnClickListener {
            imageDelivery.visibility = View.VISIBLE

            timer.start()
        }
    }

    val timer = object: CountDownTimer(5000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            btnSearch.text = "buscando conductor ..." + millisUntilFinished / 1000 + " segundos"
        }

        override fun onFinish() {
            val i = Intent(applicationContext, DriverActivity::class.java)
            startActivity(i)
        }
    }

}