package com.example.wallet.view.payment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallet.R
import com.example.wallet.databinding.FragmentPagamentoBinding
import com.example.wallet.models.Concessionaires
import com.example.wallet.util.load


class PaymentAdapter(private val items: List<Concessionaires>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ConcessionairesViewHolder(inflater.inflate(R.layout.item_concessionaires, parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ConcessionairesViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size
}

class ConcessionairesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.con_name)
    private val adress: TextView = view.findViewById(R.id.con_address)
    private val image: ImageView = view.findViewById(R.id.con_image)

    fun bind(item: Concessionaires) {
        nome.text = item.name
        adress.text = item.address
        image.setImageResource(item.image)
    }
}