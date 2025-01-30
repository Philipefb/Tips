package com.example.tipscalculator

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnCloseListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0

        // recuperar os radio groups
        binding.rb1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rb2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rb3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_pessoas,
            android.R.layout.simple_spinner_item
        )

        var numPessoas = 0
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                numPessoas = p2
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.clean.setOnClickListener {
            binding.tvResult.text = ""
            binding.tilTotalConta.setText("")
            binding.rb1.isChecked = false
            binding.rb2.isChecked = false
            binding.rb3.isChecked = false
            percentage = 0
        }

        binding.calcular.setOnClickListener {
            val ValorTotalTemp = binding.tilTotalConta.text

            if (ValorTotalTemp?.isEmpty() == true) {
                Snackbar.make(
                    binding.tilTotalConta,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val ValorTotal = ValorTotalTemp.toString().toFloat()
                val NumPessoas = numPessoas

                val ValporPessoa = ValorTotal / NumPessoas
                var Gorjeta = ValporPessoa * percentage / 100
                val TotalComGorj = ValporPessoa + Gorjeta
                binding.tvResult.text = "Total com a gorjeta " + "%.2f".format(TotalComGorj)
            }
        }


    }
}