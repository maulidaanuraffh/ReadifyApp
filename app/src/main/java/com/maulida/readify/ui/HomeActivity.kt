package com.maulida.readify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maulida.readify.adapter.GenreAdapter
import com.maulida.readify.adapter.NovelAdapter
import com.maulida.readify.databinding.ActivityHomeBinding
import com.maulida.readify.model.Genre
import com.maulida.readify.model.Novel
import com.maulida.readify.model.listDataGenre
import com.maulida.readify.model.listDataNovel
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {
    private val TAG: String="HomeActivity"
    private lateinit var novelAdapter: NovelAdapter
    private lateinit var genreAdapter: GenreAdapter
    private lateinit var binding: ActivityHomeBinding

    private var listNovel = ArrayList<Novel>()
    private var listGenre = ArrayList<Genre>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listNovel.addAll(listDataNovel)
        listGenre.addAll(listDataGenre)
        novelAdapter = NovelAdapter(this)
        genreAdapter = GenreAdapter(this)

        // Set RecyclerView untuk Novel
        binding.rvNovel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        novelAdapter.setArray(listNovel)
        binding.rvNovel.adapter = novelAdapter

        // Set RecyclerView untuk Genre
        binding.rvGenre.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        genreAdapter.setArray(listGenre)
        binding.rvGenre.adapter = genreAdapter
    }

}