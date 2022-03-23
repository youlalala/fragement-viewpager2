package org.techtown.lab2_youla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import org.techtown.lab2_youla.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewpager=binding.viewpager;


        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_one -> {
                    viewpager.currentItem = 0
                }
                R.id.item_two -> {
                    viewpager.currentItem = 1
                }
                R.id.item_three -> {
                   viewpager.currentItem = 2
                }
                else -> {
                    false
                }
            }
            true
        }

        // 뷰페이저에 어댑터 연결
        viewpager.adapter = ViewPagerAdapter(this)

        viewpager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigation.menu.getItem(position).isChecked=true
                }
            }
        )
    }


}