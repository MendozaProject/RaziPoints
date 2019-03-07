package com.computersquid.razipoints.ui.adapter

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.computersquid.razipoints.utils.FragmentlessViewPagerItem


class FragmentlessViewPagerAdapter(
        private val context: Context,
        private val pagerItems: List<FragmentlessViewPagerItem>
) : PagerAdapter() {

    val pages: MutableList<ViewGroup> = mutableListOf()


    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        assert(position < pagerItems.size)

        val inflater = LayoutInflater.from(context)
        val page = pagerItems[position]
        val layout = inflater.inflate(page.layoutResId, collection, false) as ViewGroup
        collection.addView(layout)
        pages.add(layout)
        return layout
    }


    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }


    override fun getCount(): Int {
        return pagerItems.size
    }


    override fun isViewFromObject(view: View, anObject: Any): Boolean {
        return view == anObject
    }


    override fun getPageTitle(position: Int): CharSequence? {
        val page = pagerItems[position]
        return page.title
    }
}