package com.alexlyxy.alexfragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alexlyxy.alexfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState :Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(AlexFragment.newInstance(), R.id.place_holder1)
        openFrag(AlexTwoFragment.newInstance(), R.id.place_holder2)
        dataModel.messageForActivity.observe(this) {
            binding.textView.text = it
        }

        /*   binding.bAlexTwo.setOnClickListener {
               supportFragmentManager
                   .beginTransaction()
                   .replace(R.id.place_holder, AlexTwoFragment.newInstance())
                   .commit()
               Log.d("Mylog", "This is AlexTwo")
           } */
    }
    private fun openFrag(f :Fragment, idHolder: Int)  {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}