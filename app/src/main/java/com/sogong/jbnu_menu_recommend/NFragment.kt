package com.sogong.jbnu_menu_recommend

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sogong.jbnu_menu_recommend.databinding.FragmentNBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
//fragment 화면 전환: walletFragment -> NFragment(1/N 계산하기 화면)
class NFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

//NFragment.kt의 버튼을 클릭했을 때 WalletFragment.kt로 돌아감
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNBinding.inflate(inflater, container, false)
        binding.Back.setOnClickListener{mainActivity.goBack()}
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_n, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}