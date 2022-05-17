package com.example.currencyi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyi.R
import com.example.currencyi.model.Add
import com.example.currencyi.model.Currency
import com.example.currencyi.model.Views

class Adapter (
    private val clickListener: (name: Currency) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<Views>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            R.layout.item_currency -> CurrencyViewHolder(inflater, parent)
            R.layout.add_item -> AddViewHolder(inflater, parent)
            else -> CurrencyViewHolder(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CurrencyViewHolder -> holder.onBind(data[position] as Currency, clickListener)
            is AddViewHolder -> holder.onBind { clickListener }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when(data[position]){
            is Currency -> R.layout.item_currency
            is Add ->  R.layout.add_item
            else ->  R.layout.item_currency
        }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setItems(list: List<Views>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}