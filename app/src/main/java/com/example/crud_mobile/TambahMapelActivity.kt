package com.example.crud_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class TambahMapelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_mapel)

        val txtNama = findViewById<EditText>(R.id.txtNama)
        val txtGuruMapel = findViewById<EditText>(R.id.txtGuruMapel)
        val txtRuangMapel = findViewById<EditText>(R.id.txtRuang)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val dbSaya = MyDBHelper(this)
            dbSaya.tambahMapel(
                txtNama.text.toString().trim(),
                txtGuruMapel.text.toString().trim(),
                Integer.valueOf(txtRuangMapel.text.toString().trim())
            )
        }

    }
}