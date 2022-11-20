package org.nathit.currencybtc.convert

import android.widget.Toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.nathit.currencybtc.common.ui.base.BaseFragment
import org.nathit.currencybtc.convert.databinding.FragmentConvertBinding
import java.text.DecimalFormat

class ConvertFragment : BaseFragment<ConvertViewModel, FragmentConvertBinding>() {

    override val viewModel: ConvertViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_convert
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        initToolbar()
        onBackPress()
        binding.listener = this
    }

    override fun initViewModel() {
    }

    private fun initToolbar() {
        viewModel.initToolbar(titleRes = R.string.convert_title)
    }

    fun convertEURtoBTC() {
        if (!binding.etAmountEur.text.toString().isNullOrEmpty()) {
            val eur = binding.etAmountEur.text.toString().toDouble()
            val btc = 0.000062 * eur
            val formatter = DecimalFormat("#,##0.0#####")
            formatter.groupingSize = 1000
            val formattedString = formatter.format(btc)
            binding.etBtcEur.text = "$formattedString BTC"
        } else {
            Toast.makeText(requireContext(), "Please enter the number!", Toast.LENGTH_SHORT).show()
        }
    }

    fun convertGBPtoBTC() {
        if (!binding.etAmountGBP.text.toString().isNullOrEmpty()) {
            val gbp = binding.etAmountGBP.text.toString().toDouble()
            val btc = 0.000072 * gbp
            val formatter = DecimalFormat("#,##0.0#####")
            formatter.groupingSize = 1000
            val formattedString = formatter.format(btc)
            binding.etBtcGBP.text = "$formattedString BTC"
        } else {
            Toast.makeText(requireContext(), "Please enter the number!", Toast.LENGTH_SHORT).show()
        }
    }

    fun convertUSDtoBTC() {
        if (!binding.etAmountUSD.text.toString().isNullOrEmpty()) {
            val usd = binding.etAmountUSD.text.toString().toDouble()
            val btc = 0.000060 * usd
            val formatter = DecimalFormat("#,##0.0#####")
            formatter.groupingSize = 1000
            val formattedString = formatter.format(btc)
            binding.etBtcUSD.text = "$formattedString BTC"
        } else {
            Toast.makeText(requireContext(), "Please enter the number!", Toast.LENGTH_SHORT).show()
        }
    }
}