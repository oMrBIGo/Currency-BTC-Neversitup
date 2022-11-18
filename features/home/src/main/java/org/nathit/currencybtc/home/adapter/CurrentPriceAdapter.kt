package org.nathit.currencybtc.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.nathit.currencybtc.domain.model.CurrentPrice
import org.nathit.currencybtc.home.R
import org.nathit.currencybtc.home.databinding.ItemCurrentPriceBinding

class CurrentPriceAdapter(
    private val result: ArrayList<CurrentPrice.Bpi>
) : RecyclerView.Adapter<CurrentPriceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_current_price,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    inner class ViewHolder(private val binding: ItemCurrentPriceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            position: Int
        ) {
            binding.model = result[position].eUR[position]
            binding.executePendingBindings()
        }
    }

}