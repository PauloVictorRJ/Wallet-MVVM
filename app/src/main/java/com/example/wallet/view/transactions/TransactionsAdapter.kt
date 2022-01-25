package com.example.wallet.view.transactions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.models.Transaction
import com.example.wallet.util.load


private const val HEADER = 0
private const val CONTENT = 1

class TransactionsAdapter(private val transactionItems: List<Transaction>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == HEADER) {
            return HeaderViewHolder(
                inflater.inflate(
                    R.layout.item_transaction_header, parent, false
                )
            )
        }
        return TransactionViewHolder(inflater.inflate(R.layout.item_transaction, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransactionViewHolder -> holder.bind(transactionItems[position])
            is HeaderViewHolder -> holder.bindHeader(transactionItems[position])
        }
    }

    override fun getItemCount() = transactionItems.size

    override fun getItemViewType(position: Int): Int {
        if (transactionItems[position].viewType == 0) {
            return HEADER
        }
        return CONTENT
    }
}

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView = view.findViewById(R.id.transaction_header_title)

    fun bindHeader(headerTitle: Transaction) {
        title.text = headerTitle.title
    }
}

class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView = view.findViewById(R.id.transaction_item_title)
    private val subtitle: TextView = view.findViewById(R.id.transaction_item_subtitle)
    private val valor: TextView = view.findViewById(R.id.transaction_item_valor)
    private val imagem: ImageView = view.findViewById(R.id.transaction_item_image)

    fun bind(item: Transaction) {
        title.text = item.title
        subtitle.text = item.subtitle
        valor.text = item.value
        item.image?.let {
            imagem.load(it)
        }

        if (subtitle.text == "Pagamento") {
            valor.setTextColor(ContextCompat.getColor(subtitle.context, R.color.bittersweet))
        } else {
            valor.setTextColor(ContextCompat.getColor(subtitle.context, R.color.apple))
        }
    }
}
