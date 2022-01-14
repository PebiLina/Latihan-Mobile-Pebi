package com.example.crud_mobile

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val mapel_id: ArrayList<String>      = arrayListOf()
    val mapel_nama: ArrayList<String>   = arrayListOf()
    val mapel_gurumapel: ArrayList<String> = arrayListOf()
    val mapel_ruang: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTambah = findViewById<FloatingActionButton>(R.id.float_add)
        btnTambah.setOnClickListener {
            val intentKita = Intent(this, TambahMapelActivity::class.java)
            startActivity(intentKita)
        }
        simpanDataDiArray()
        val mapelAdapter = MapelAdapter(this,mapel_id,mapel_nama,mapel_gurumapel,mapel_ruang)
        val rv_mapel = findViewById<RecyclerView>(R.id.rv_mapel)
        rv_mapel.adapter = mapelAdapter
        rv_mapel.layoutManager = LinearLayoutManager(this)
        rv_mapel.itemAnimator = DefaultItemAnimator()
    }
    fun simpanDataDiArray(){
        val dbSaya            = MyDBHelper(this)
        val dataSaya: Cursor = dbSaya.BacaSemuaData()

        if(dataSaya.count == 0){
            Toast.makeText(this,"Data Tidak Ada!", Toast.LENGTH_SHORT).show()
        }
        else{
            while (dataSaya.moveToNext()){
                mapel_id.add(dataSaya.getString(0))
                mapel_nama.add(dataSaya.getString(1))
                mapel_gurumapel.add(dataSaya.getString(2))
                mapel_ruang.add(dataSaya.getString(3))
            }
        }
    }
}