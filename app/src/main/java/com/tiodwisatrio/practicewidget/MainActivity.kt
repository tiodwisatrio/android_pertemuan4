package com.tiodwisatrio.practicewidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var cb_membaca: CheckBox
    private lateinit var cb_bermusik: CheckBox
    private lateinit var cb_memasak: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen-komponen yang akan kita ambil datanya
        val ed_nim = findViewById<EditText>(R.id.ed_nim)
        val ed_nama = findViewById<EditText>(R.id.ed_nama)
        val radioGroup = findViewById<RadioGroup>(R.id.rg_jenis_kelamin)
        val sp_prodi = findViewById<Spinner>(R.id.sp_prodi)

        cb_membaca = findViewById(R.id.cb_membaca)
        cb_bermusik = findViewById(R.id.cb_bermusik)
        cb_memasak = findViewById(R.id.cb_memasak)

        // Tombol untuk menampilkan pesan Toast
        val btn_simpan = findViewById<Button>(R.id.btn_simpan)

        btn_simpan.setOnClickListener(View.OnClickListener {
            val nim = ed_nim.text.toString()
            val nama = ed_nama.text.toString()

            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val radioButtonValue = if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                selectedRadioButton.text.toString()
            } else {
                "Jenis Kelamin tidak dipilih"
            }

            val selectedValue = sp_prodi.selectedItem.toString()

            val selectedCheckboxes = StringBuilder()
            if (cb_membaca.isChecked) {
                selectedCheckboxes.append("Membaca\n")
            }
            if (cb_bermusik.isChecked) {
                selectedCheckboxes.append("Bermusik\n")
            }
            if (cb_memasak.isChecked) {
                selectedCheckboxes.append("Memasak")
            }

            val message = "NIM: $nim\nNama: $nama\nJenis Kelamin: $radioButtonValue\nProdi: $selectedValue\nHobi: $selectedCheckboxes"

            showToast(message)
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}