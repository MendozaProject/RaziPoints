package com.computersquid.razipoints.ui.adapter

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.computersquid.razipoints.utils.FragmentlessViewPagerItem


class FragmentlessViewPagerAdapter(
        private val context: Context,
        private val layouts: List<FragmentlessViewPagerItem>
) : PagerAdapter() {


    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        assert(position < layouts.size)

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
        return layouts.size
    }


    override fun isViewFromObject(view: View, anObject: Any): Boolean {
        return view == anObject
    }


    override fun getPageTitle(position: Int): CharSequence? {
        val page = layouts[position]
        return page.title
    }
}