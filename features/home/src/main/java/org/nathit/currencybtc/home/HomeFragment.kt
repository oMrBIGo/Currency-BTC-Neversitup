package org.nathit.currencybtc.home

import org.koin.androidx.viewmodel.ext.android.viewModel
import org.nathit.currencybtc.common.ui.base.BaseFragment
import org.nathit.currencybtc.common.ui.base.BaseViewModel
import org.nathit.currencybtc.home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {

    }

    override fun initViewModel() {
    }


}