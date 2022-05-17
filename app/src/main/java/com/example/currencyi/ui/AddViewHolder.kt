package com.example.currencyi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyi.R

class AddViewHolder (
    inflater: LayoutInflater,
    parent: ViewGroup
): RecyclerView.ViewHolder(inflater.inflate(R.layout.add_item, parent, false)) {

    private val addView = itemView.findViewById<View>(R.id.add_bg_view)

    fun onBind(clickListener: () -> Unit) {
        addView.setOnClickListener {
            clickListener()
        }
    }
}