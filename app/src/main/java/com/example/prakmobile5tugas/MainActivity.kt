package com.example.prakmobile5tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.prakmobile5tugas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val kota = resources.getStringArray(R.array.Kota)
        val dari = resources.getStringArray(R.array.Dari)
        with(binding){
            val adapterKota = ArrayAdapter(this@MainActivity,
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item, kota)
            adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerKota.adapter = adapterKota

            val adapterDari = ArrayAdapter(this@MainActivity,
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item, dari)
            adapterDari.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerDari.adapter = adapterDari

            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                val ambiltanggal = "$dayOfMonth/${monthOfYear + 1}/$year"



                timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
                    val ambilwaktu = String.format("%02d:%02d", hourOfDay, minute)


                binding.pesan.setOnClickListener {
                    val nama = binding.nama.text.toString()
                    val tanggal = ambiltanggal
                    val waktu = ambilwaktu
                    val kota = spinnerKota.selectedItem.toString()
                    val dari = spinnerDari.selectedItem.toString()
                    val toast = Toast.makeText(applicationContext, "Pesanan Berhasil untuk: $nama\nTanggal: $tanggal\nWaktu: $waktu\nDari Kota:$dari\nKe Kota: $kota", Toast.LENGTH_LONG)
                    toast.show()
                }

            }
            }
        }
    }
}
