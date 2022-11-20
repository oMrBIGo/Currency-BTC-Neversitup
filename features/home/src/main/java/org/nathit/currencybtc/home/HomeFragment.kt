package org.nathit.currencybtc.home

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.nathit.currencybtc.common.ui.base.BaseFragment
import org.nathit.currencybtc.common.ui.base.BaseViewModel

import org.nathit.currencybtc.home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private val mainHandler = Handler(Looper.getMainLooper())


    override fun initView() {
        initToolbar()
        onBackPress()
    }

    override fun initViewModel() {
        /*** Cool-down Update Time 1 min ***/
        mainHandler.post(object : Runnable {
            override fun run() {
                viewModel.getCurrentPriceList()
                mainHandler.postDelayed(this, 60 * 1000)
            }
        })
    }

    private fun initToolbar() {
        viewModel.initToolbar(titleRes = R.string.home_title)
    }

    /*** Add History ***/
    fun addHistoryEur(code: String, description: String, rate: String, rateFloat: Double) {
        lifecycleScope.launch {
            //val eur = Eur(code = code, description = description, rate = rate, rateFloat = rateFloat)
        }
    }
}