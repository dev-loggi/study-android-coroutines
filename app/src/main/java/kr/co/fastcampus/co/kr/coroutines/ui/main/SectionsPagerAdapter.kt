package kr.co.fastcampus.co.kr.coroutines.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(private val fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> ImageSearchFragment()
        1 -> FavoritesFragment()
        else -> throw IllegalArgumentException("position=$position")
    }

    override fun getItemCount(): Int {
        return 2
    }
}