package com.example.wallet.view.cardinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.models.Ofertas
import com.example.wallet.util.load


class CardInfoOfertasAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val listOfertas = mutableListOf<Ofertas>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return OfertasViewHolder(inflater.inflate(R.layout.item_card_info_ofertas, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OfertasViewHolder -> holder.bind(listOfertas[position])
        }
    }

    override fun getItemCount() = listOfertas.size

    fun setListOfertas(listRx: MutableList<Ofertas>) {
        listOfertas.clear()
        listOfertas.addAll(listRx)
        notifyDataSetChanged()
    }
}

class OfertasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imagem: ImageView = view.findViewById(R.id.rv_ofertas_image)

    fun bind(item: Ofertas) {
        imagem.load(item.image)
    }
}