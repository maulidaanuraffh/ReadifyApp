package com.maulida.readify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maulida.readify.R
import com.maulida.readify.databinding.ActivityHomeBinding
import com.maulida.readify.model.Novel
import com.maulida.readify.model.listDataDummy
import java.util.*

class HomeActivity : AppCompatActivity() {
    private val TAG: String="HomeActivity"
    private lateinit var novelAdapter: NovelAdapter
    private lateinit var binding: ActivityHomeBinding

    private var listNovel = ArrayList<Novel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listNovel.addAll(listDataDummy)
        novelAdapter = NovelAdapter(this)
        binding.rvNovel.layoutManager = LinearLayoutManager(this)
        novelAdapter.setArray(listNovel)
        binding.rvNovel.adapter = novelAdapter

        // Mengatur LinearLayoutManager dengan orientasi horizontal
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvNovel.layoutManager = layoutManager

        novelAdapter.setArray(listNovel)
        binding.rvNovel.adapter = novelAdapter
    }

}