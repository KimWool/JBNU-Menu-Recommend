package com.sogong.jbnu_menu_recommend

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sogong.jbnu_menu_recommend.databinding.FragmentWalletBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Wallet.newInstance] factory method to
 * create an instance of this fragment.
 */
class Wallet : Fragment() {
    var mainActivity: MainActivity? = null
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_wallet, container, false)
        val binding = FragmentWalletBinding.inflate(inflater, container, false)
        binding.Nbutton.setOnClickListener {mainActivity?.goN()}
        binding.Lbutton.setOnClickListener {mainActivity?.goL()}
        binding.Sbutton.setOnClickListener {mainActivity?.goS()}
        binding.Dbutton.setOnClickListener {mainActivity?.goD()}
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Wallet.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Wallet().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}