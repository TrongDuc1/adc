package com.example.btt2screen.tabview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.btt2screen.R
import com.google.android.material.tabs.TabLayout



class TabView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_view)

        initToolbar()
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = SampleAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_chair_white)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_sofa_white)
        tabLayout.getTabAt(3)!!.setIcon(R.drawable.ic_file_cabinet_white)
        tabLayout.getTabAt(4)!!.setIcon(R.drawable.ic_plant_pot_white)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
            }
            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELLCOME"
    }
}