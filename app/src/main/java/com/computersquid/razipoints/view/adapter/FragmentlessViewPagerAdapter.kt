package com.computersquid.razipoints.view.adapter

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View



class FragmentlessViewPagerItem(
        val layoutResId: Int,
        val title: String
)


class FragmentlessViewPagerAdapter(
        private val context: Context,
        private val layouts: List<FragmentlessViewPagerItem>) : PagerAdapter() {


    override fun instantiateItem(collection: ViewGroup, position: Int): Any {

        val inflater = LayoutInflater.from(context)
        val page = layouts[position]

        val layout = inflater.inflate(page.layoutResId, collection, false) as ViewGroup
        collection.addView(layout)
        return layout
    }


    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }


    override fun getCount(): Int {
        return layouts.count()
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun getPageTitle(position: Int): CharSequence? {
        val page = layouts[position]
        return page.title
    }
}