package com.example.tipscalculator

import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnCloseListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage = 0

        // recuperar os radio groups
        binding.rb1.setOnCheckedChangeListener { _, isChecked ->
            println("teste")
            percentage = 10

        }

        binding.rb2.setOnCheckedChangeListener { _, isChecked ->
            println("teste")
            percentage = 15

        }

        binding.rb3.setOnCheckedChangeListener { _, isChecked ->
            println("teste")
            percentage = 20

        }

        binding.calcular.setOnClickListener {

            val ValorTotal = binding.tilTotalConta.text.toString().toFloat()
            val NumPessoas = binding.tilNumPessoas.text.toString().toFloat()

            val ValporPessoa = ValorTotal / NumPessoas
            val Gorjeta =  ValporPessoa * (percentage / 100)
            val TotalComGorj = (ValorTotal / NumPessoas) * (percentage / 100)




            println(binding.tilNumPessoas)
        }


    }
}