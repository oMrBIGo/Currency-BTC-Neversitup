package org.nathit.currencybtc.home

import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.nathit.currencybtc.common.ui.base.BaseFragment
import org.nathit.currencybtc.common.ui.base.BaseViewModel
import org.nathit.currencybtc.domain.model.CurrentPrice
import org.nathit.currencybtc.home.adapter.CurrentPriceAdapter
import org.nathit.currencybtc.home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: CurrentPriceAdapter? = null

    override fun initView() {
        initToolbar()
        onBackPress()
    }

    override fun initViewModel() {
        viewModel.getCurrentPriceList()
        viewModel.currentPriceResult.observe(
            this
        ) {
            setCurrentPriceAdapter(it.bpi)
        }
    }

    private fun initToolbar() {
        viewModel.initToolbar(titleRes = R.string.home_title)
    }

    private fun setCurrentPriceAdapter(data: ArrayList<CurrentPrice.Bpi>) {
        adapter = CurrentPriceAdapter(
            data
        )
        binding.rcvCurrentPrice.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvCurrentPrice.adapter = adapter
    }
}