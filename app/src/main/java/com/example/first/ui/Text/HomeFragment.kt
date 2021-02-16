package com.example.first.ui.Text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.first.DataAdapterText
import com.example.first.R

class HomeFragment : Fragment()
{
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
            recyclerView.adapter = DataAdapterText(fill())
        })
        return root
    }

    private fun fill() : List<String>
    {
        return this.resources.getStringArray(R.array.text).toList()
    }
}