package com.example.fintech.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.fintech.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        title = "Menu Profile"
        val btnNama = findViewById<TextView>(R.id.tvnama)
        val btnNim = findViewById<TextView>(R.id.tvnim)
        val btnEmail = findViewById<TextView>(R.id.tvemail)
        val btnNoHP = findViewById<TextView>(R.id.tvnohp)
        val btnJK = findViewById<TextView>(R.id.tvjk)
        val btnProdi = findViewById<TextView>(R.id.tvstudi)
        val btnOrganisasi = findViewById<TextView>(R.id.tvorganisasi)
        val btnMhs = findViewById<TextView>(R.id.tvstatus)

        val bukabundle = intent.extras
        if (bukabundle != null) {
            btnNama.setText(bukabundle.getString("nama"))
            btnNim.setText(bukabundle.getString("nim"))
            btnEmail.setText(bukabundle.getString("email"))
            btnNoHP.setText(bukabundle.getString("nope"))
            btnJK.setText(bukabundle.getString("jk"))
            btnProdi.setText(bukabundle.getString("prodi"))
            btnOrganisasi.setText(bukabundle.getString("org"))
            btnMhs.setText(bukabundle.getString("status"))

        }
    }
}