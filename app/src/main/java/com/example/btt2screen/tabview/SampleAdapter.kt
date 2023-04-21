package com.example.btt2screen.tabview


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.btt2screen.fragmentscreen.*

class SampleAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> FragmentAllitem.newInstance()
        1 -> FragmentSofa.newInstance()
        2 -> FragmentChair.newInstance()
        3 -> FragmentCabinet.newInstance()
        4 -> FragmentPlantpot.newInstance()
        else ->
            getItem(position)
    }
    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "All"
        1 -> "Chair"
        2 -> "Sofa"
        3 -> "Wardrobe"
        4-> "Plantpot"
        else -> ""
    }
    override fun getCount(): Int = 5

}