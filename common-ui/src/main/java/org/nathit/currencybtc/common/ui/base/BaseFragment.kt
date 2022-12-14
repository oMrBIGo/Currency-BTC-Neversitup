package org.nathit.currencybtc.common.ui.base

import NavigationCommand
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.nathit.currencybtc.common.R
import org.nathit.currencybtc.common.ui.dialog.ProgressDialog

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {
    protected abstract val viewModel: VM
    protected lateinit var binding: DB

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun getViewModelBindingVariable(): Int
    protected abstract fun initView()
    protected abstract fun initViewModel()

    companion object {
        var progressDialog: ProgressDialog? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
            initView()
        }
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(getViewModelBindingVariable(), viewModel)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        viewModel.alertDialogEvent.observeSingle(viewLifecycleOwner, Observer {
            it?.let {
                if (it.imageRes == null) {
                    AlertDialog.Builder(requireContext()).apply {
                        it.titleRes?.let { titleRes -> setTitle(titleRes) } ?: setTitle(it.title)
                        it.messageRes?.let { messageRes -> setMessage(messageRes) }
                            ?: setMessage(it.message)
                        it.positiveActionRes?.let { positiveActionRes ->
                            setPositiveButton(positiveActionRes) { _, _ ->
                                it.onPositiveClicked.invoke()
                            }
                        }
                        it.negativeActionRes?.let { negativeActionRes ->
                            setNegativeButton(negativeActionRes) { _, _ ->
                                it.onNegativeClicked.invoke()
                            }
                        }
                        setCancelable(false)
                    }.show()
                }
            }
        })

        viewModel.navigateEvent.observeSingle(viewLifecycleOwner, Observer {
            it.let { command ->
                when (command) {
                    is NavigationCommand.To -> findNavController().navigate(command.directions)
                    is NavigationCommand.BackTo -> findNavController().popBackStack(
                        command.destinationId,
                        command.inclusive
                    )
                    is NavigationCommand.Back -> findNavController().popBackStack()
                    else -> Log.e("NavigateEvent", "null")
                }
            }
        })

        viewModel.progressDialogEvent.observeSingle(viewLifecycleOwner, Observer {
            if (progressDialog != null && progressDialog!!.isShowing && !it) {
                progressDialog?.dismiss()
            } else if (it) {
                progressDialog = ProgressDialog(requireContext())
                progressDialog?.show()
            }
        })
    }

    fun onBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            })
    }
}