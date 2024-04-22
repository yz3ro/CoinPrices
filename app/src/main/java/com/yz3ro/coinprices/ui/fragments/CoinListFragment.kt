package com.yz3ro.coinprices.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yz3ro.coinprices.R
import com.yz3ro.coinprices.adapters.CoinPricesAdapter
import com.yz3ro.coinprices.databinding.FragmentCoinListBinding
import com.yz3ro.coinprices.ui.viewmodels.CoinListVievModel
import com.yz3ro.coinprices.util.Constants.API_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinListFragment : Fragment() {
    private lateinit var binding : FragmentCoinListBinding
    private val viewModel : CoinListVievModel by viewModels()
    private lateinit var adapter: CoinPricesAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_coin_list, container, false)
        adapter = CoinPricesAdapter(requireContext(), listOf())
        binding.rvCoin.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvCoin.layoutManager = layoutManager
        viewModel.getCoinsName(API_KEY)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.coins.observe(viewLifecycleOwner) { coins ->
            Log.e("coin", coins.toString())
            adapter.updateList(coins)
        }
    }
}