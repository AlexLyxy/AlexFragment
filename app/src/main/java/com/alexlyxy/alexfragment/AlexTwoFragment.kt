package com.alexlyxy.alexfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.alexlyxy.alexfragment.databinding.FragmentAlexTwoBinding

class AlexTwoFragment : Fragment() {

    lateinit var binding :FragmentAlexTwoBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater :LayoutInflater,container :ViewGroup?,
        savedInstanceState :Bundle?
    ) :View? {
        binding = FragmentAlexTwoBinding.inflate(inflater)
        return binding.root
        /*binding.bAlex.setOnClickListener {
            Log.d("MyLog", "This is Simple Alex")
        }*/

    }

    override fun onViewCreated(view :View,savedInstanceState :Bundle?) {
        dataModel.messageForAlexTwoFrag.observe(activity as LifecycleOwner) {
            binding.tvMessage.text = it
        }
        binding.sendToAlexTwo.setOnClickListener {
            dataModel.messageForAlexFrag.value = "Hello Fragment Alex From Fragment Alex Two"
        }
        binding.sendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello Activity From Fragment Alex Two"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AlexTwoFragment()
    }
}