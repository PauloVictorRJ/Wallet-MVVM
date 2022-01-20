package com.example.wallet.view.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.models.Transaction


private const val HEADER = 0
private const val CONTENT = 1

class HomeAdapters {

    class HomeRvTransactionsAdapater(private val lista:List<Transaction>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            if (viewType == HEADER) {
                return HomeRvHeaderViewHolder(inflater.inflate(R.layout.item_transaction_header,parent,false))
            }
            return homeRvContentViewHolder(inflater.inflate(R.layout.item_transaction, parent, false))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is homeRvContentViewHolder -> holder.bind(lista[position])
                is HomeRvHeaderViewHolder -> holder.bindHeader(lista[position])

            }
        }

        override fun getItemCount() = lista.size

        override fun getItemViewType(position: Int): Int {
            if (lista[position].viewType == 0) {
                return HEADER
            }
            return CONTENT
        }
    }

    class homeRvContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.transaction_item_title)
        private val subtitle: TextView = view.findViewById(R.id.transaction_item_subtitle)
        private val valor: TextView = view.findViewById(R.id.transaction_item_valor)
        private val imagem: ImageView = view.findViewById(R.id.transaction_item_image)

        fun bind(item: Transaction) {
            title.text = item.title
            subtitle.text = item.subtitle
            valor.text = item.value
            item.image?.let {
                //imagem.load(it)
            }
            if (subtitle.text == "Pagamento") {
                valor.setTextColor(Color.parseColor("#FFFB6969"))
            } else {
                valor.setTextColor(Color.parseColor("#FF45C232"))
            }
        }
    }

    class HomeRvHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.transaction_header_title)

        fun bindHeader(headerTitle: Transaction) {
            title.text = headerTitle.title
        }
    }
}