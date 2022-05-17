package com.example.currencyi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyi.R
import com.example.currencyi.model.Currency
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CurrencyViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_currency, parent, false)) {

    private val TextField = itemView.findViewById<TextInputEditText>(R.id.TextField)
    private val currencyText = itemView.findViewById<TextInputLayout>(R.id.currencyText)
    private val Label = itemView.findViewById<TextView>(R.id.Label)
    private val img = itemView.findViewById<ImageView>(R.id.Image)
    fun onBind(item:Currency, clickListener:(name: Currency) -> Unit) {
        TextField.text?.append(item.value.toString())
        currencyText.hint = item.textview
        Label.text = item.textview
        img.setBackgroundResource(item.imageRes)
    }
}