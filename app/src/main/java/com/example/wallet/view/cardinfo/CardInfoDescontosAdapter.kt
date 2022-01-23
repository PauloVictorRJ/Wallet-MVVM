package com.example.wallet.view.cardinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.models.Descontos
import com.example.wallet.util.load


class CardInfoDescontosAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val listDescontos = mutableListOf<Descontos>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return DescontosViewHolder(
            inflater.inflate(
                R.layout.item_card_info_descontos,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DescontosViewHolder -> holder.bind(listDescontos[position])
        }
    }

    override fun getItemCount() = listDescontos.size

    fun setListDescontos(listRx: MutableList<Descontos>) {
        listDescontos.clear()
        listDescontos.addAll(listRx)
        notifyDataSetChanged()
    }

    class DescontosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imagem: ImageView = view.findViewById(R.id.rv_descontos_image)

        fun bind(item: Descontos) {
            imagem.load(item.image)
        }
    }
}