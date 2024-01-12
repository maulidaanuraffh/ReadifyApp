package com.maulida.readify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maulida.readify.databinding.ActivityHomeBinding
import com.maulida.readify.databinding.DetailNovelBinding

class DetailNovel : AppCompatActivity() {

    private lateinit var binding: DetailNovelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailNovelBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}