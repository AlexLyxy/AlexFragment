package com.alexlyxy.alexfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.alexlyxy.alexfragment.databinding.FragmentAlexBinding

class AlexFragment : Fragment () {
    private val dataModel :DataModel by activityViewModels()
    lateinit var binding :FragmentAlexBinding

    override fun onCreateView(
        inflater :LayoutInflater,container :ViewGroup?,
        savedInstanceState :Bundle?,
    ) :View? {
        binding = FragmentAlexBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view :View,savedInstanceState :Bundle?) {
        dataModel.messageForAlexFrag.observe(activity as LifecycleOwner) {
            binding.tvMassage.text = it

            binding.sendToAlexTwo.setOnClickListener {
                dataModel.messageForAlexTwoFrag.value = "Hello Fragment Alex Two From Fragment Alex"
            }
            binding.sendToActivity.setOnClickListener {
                dataModel.messageForActivity.value = "Hello Activity From Fragment Alex"
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = AlexFragment()
    }
}

