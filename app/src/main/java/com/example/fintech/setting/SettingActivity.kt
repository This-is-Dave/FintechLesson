package com.example.fintech.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.fintech.R
import com.example.fintech.profile.ProfileActivity
import java.lang.StringBuilder

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        title = "Menu Setting"
        val btnNama = findViewById<EditText>(R.id.namaLengkap)
        val btnNim = findViewById<EditText>(R.id.nim)
        val btnEmail = findViewById<EditText>(R.id.email)
        val btnNoHP = findViewById<EditText>(R.id.noHp)
        val btnPass = findViewById<EditText>(R.id.password)
        val btnJK = findViewById<RadioGroup>(R.id.radioGrup)
        val btnProdi = findViewById<Spinner>(R.id.spinner)
        val btnAmcc = findViewById<CheckBox>(R.id.amcc)
        val btnHimmsi = findViewById<CheckBox>(R.id.himmsi)
        val btnBem = findViewById<CheckBox>(R.id.bem)
        val btnMhs = findViewById<ToggleButton>(R.id.statusMhs)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val cekJK = btnJK.checkedRadioButtonId
            val JK = findViewById<RadioButton>(cekJK)

            val organisasi = StringBuilder()
            if (btnAmcc.isChecked) {
                organisasi.append("AMCC\n")
            }
            if (btnHimmsi.isChecked) {
                organisasi.append("HIMMSI\n")
            }
            if (btnBem.isChecked) {
                organisasi.append("BEM\n")
            }

            val bundle = Bundle()
            bundle.putString("nama", btnNama.text.toString())
            bundle.putString("nim", btnNim.text.toString())
            bundle.putString("email", btnEmail.text.toString())
            bundle.putString("nope", btnNoHP.text.toString())
            bundle.putString("jk", "${JK.text}")
            bundle.putString("prodi", btnProdi.selectedItem.toString())
            bundle.putString("org", organisasi.toString())
            bundle.putString("status", btnMhs.text.toString())

            if (!Patterns.EMAIL_ADDRESS.matcher(btnEmail.text.toString()).matches()) {
                btnEmail.error = "Email anda salah."
            }
            else if (btnPass.length()==0) {
                btnPass.error = "Mohon untuk mengisi password"
            }
            else {
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan..!")
                alertDialogBuilder.setMessage("Apakah anda sudah yakin dengan data anda ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes")
                    {
                        dialogInterface, i ->
                        val intent = Intent(this, ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this, "Data profil telah tersimpan", Toast.LENGTH_SHORT).show()
                    }

                    .setNegativeButton("No") {
                        dialogInterface, i->
                        dialogInterface.cancel() }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
                    }
            }

        }
}