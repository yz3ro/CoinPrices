package com.yz3ro.coinprices.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yz3ro.coinprices.data.entity.Exchange
import com.yz3ro.coinprices.databinding.ItemCoinBinding

class CoinPricesAdapter (var mContext: Context, var coinList : List<Exchange>) : RecyclerView.Adapter<CoinPricesAdapter.MyViewHolder>(){
    inner class MyViewHolder(var design : ItemCoinBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = ItemCoinBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(design)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val coin = coinList.get(position)
        val t = holder.design
        t.txtCoinName.text = coin.FullName
        t.txtBuying.text = coin.buying.toString()
        t.txtSelling.text = coin.selling.toString()
    }
    override fun getItemCount(): Int = coinList.size

    fun updateList(newList: List<Exchange>) {
        coinList = newList
        notifyDataSetChanged()
        Log.d("NearPharmaciesAdapter", "New list size: ${coinList.size}")
    }
}