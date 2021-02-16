package com.example.first.ui.Gallery

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.first.DataAdapterGallery
import com.example.first.R
import com.example.first.ui.Text.HomeViewModel

class GalleryFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home_text, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_view)

        homeViewModel.text.observe(viewLifecycleOwner, Observer
        {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = DataAdapterGallery(fill())
        })
        return root
    }

    private fun fill() : IntArray
    {
        return this.getImageId(R.array.cat_image)
    }

    fun getImageId(imageArrayId:Int) : IntArray
    {
        val tar: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tar.length()
        val counts = IntArray(count)
        for (i in counts.indices)
        {
            counts[i] = tar.getResourceId(i,0)
        }
        tar.recycle()
        return counts
    }

}