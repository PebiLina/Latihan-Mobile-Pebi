package com.example.crud_mobile

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class UbahMapelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_mapel)

        val actionBar =supportActionBar
        if (intent.hasExtra("nama")) {
            actionBar?.title = intent.getStringExtra("nama")
        }
        val btnUbah = findViewById<Button>(R.id.btn_ubah)

        getIntentData()

        btnUbah.setOnClickListener {
            val dbKita = MyDBHelper(this)

            val idMapel = intent.getStringExtra("id")
            val namaMapel = findViewById<EditText>(R.id.txt_nama).text.toString()
            val guruMapel = findViewById<EditText>(R.id.txt_gurumapel).text.toString()
            val ruangMapel = findViewById<EditText>(R.id.txt_ruang).text.toString()

            dbKita.ubahMapel(idMapel, namaMapel, guruMapel, ruangMapel)
        }
        val  btnHapus = findViewById<Button>(R.id.btnHapus)
        btnHapus.setOnClickListener {
            dialogKonfirmasi()
        }
    }
    fun getIntentData() {
        if (
            intent.hasExtra("id") &&
            intent.hasExtra("nama") &&
            intent.hasExtra("gurumapel") &&
            intent.hasExtra("ruang")
        ){

            val idmapel          = intent.getStringExtra("id")
            val namamapel       = intent.getStringExtra("nama")
            val gurumapel   = intent.getStringExtra("gurumapel")
            val ruang      = intent.getStringExtra("ruang")

            val txtnama = findViewById<EditText>(R.id.txt_nama)
            val txtgurumapel = findViewById<EditText>(R.id.txt_gurumapel)
            val txtruang = findViewById<EditText>(R.id.txt_ruang)

            txtnama.setText(namamapel)
            txtgurumapel.setText(gurumapel)
            txtruang.setText(ruang)
        } else{
            Toast.makeText(this,"Tidak Ada Data !", Toast.LENGTH_SHORT).show()
        }
    }
    fun dialogKonfirmasi(){
        val idMapel  = intent.getStringExtra("id")
        val namaMapel = intent.getStringExtra("nama")

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Delete " + namaMapel + " ?")
        alertDialog.setMessage("Apakah anda yakin menghapus " + namaMapel + " ?")

        alertDialog.setPositiveButton("iya", DialogInterface.OnClickListener{dialog, which ->
            val dbKita = MyDBHelper(this)
            dbKita.hapusMapel(idMapel)
            startActivity(Intent(this, MainActivity::class.java))
        })
        alertDialog.setNegativeButton("Tidak", DialogInterface.OnClickListener { dialog, which ->  })
        alertDialog.create().show()
    }

}