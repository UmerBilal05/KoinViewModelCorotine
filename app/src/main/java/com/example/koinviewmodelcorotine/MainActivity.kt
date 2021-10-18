package com.example.koinviewmodelcorotine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.koinviewmodelcorotine.databinding.ActivityMainBinding
import com.example.koinviewmodelcorotine.fragment.FragmentOne
import com.example.koinviewmodelcorotine.fragment.FragmentTwo
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val adpterinof=object :FragmentStateAdapter(this){
            override fun getItemCount(): Int =2

            override fun createFragment(position: Int): Fragment {
               return when(position){
                    0->{
                        FragmentOne()
                    }
                    1->{
                        FragmentTwo()
                    }
                    else->{
                        FragmentOne()
                    }
                }
            }
        }
        binding.viewpager2.adapter=adpterinof
        TabLayoutMediator(binding.tablayout, binding.viewpager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "FirstFrag"
                }
                1 -> {
                    tab.text = "SecondFrag"
                }
            }
        }.attach()
//binding.viewpager2.offscreenPageLimit=2
    }
}