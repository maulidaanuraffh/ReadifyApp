package com.maulida.readify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maulida.readify.R
import com.maulida.readify.adapter.GenreAdapter
import com.maulida.readify.adapter.NovelAdapter
import com.maulida.readify.databinding.ActivityMainBinding
import com.maulida.readify.model.Genre
import com.maulida.readify.model.Novel
import com.maulida.readify.model.listDataGenre
import com.maulida.readify.model.listDataNovel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.perpustakaan -> {
                    replaceFragment(PerpustakaanFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tulis -> {
                    replaceFragment(TulisFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.akun -> {
                    replaceFragment(AkunFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

        // Set the default fragment to be displayed
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

}