package com.example.currencyi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyi.model.Add
import com.example.currencyi.model.Currency
import com.example.currencyi.model.Views
import com.example.currencyi.ui.Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        setupCurrency()
    }

    private fun setupCurrency() {
        val currencyAdapter = Adapter(
            clickListener = {
                Log.d("currency name:", it.textview)
            }
        )
        val currencyManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = currencyAdapter
            layoutManager = currencyManager
        }

        val currencyList = listOf<Views>(
            Currency("Тенге, Казахстан", 150000, R.drawable.kz),
            Currency("Доллары, США", 23400, R.drawable.usa),
            Currency("Тенге, Казахстан", 1350000, R.drawable.kz),
            Currency("Тенге, Казахстан", 671000, R.drawable.kz),
            Currency("Доллары, США", 45000, R.drawable.usa),
            Currency("Доллары, США", 67000, R.drawable.usa),
            Currency("Тенге, Казахстан", 250000, R.drawable.kz),
            Add()
        )

        currencyAdapter.setItems(currencyList)
    }
}