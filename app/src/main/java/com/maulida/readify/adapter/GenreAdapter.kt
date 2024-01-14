package com.maulida.readify.adapter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maulida.readify.R
import com.maulida.readify.databinding.ItemGenreBinding
import com.maulida.readify.databinding.ItemNovelBinding
import com.maulida.readify.databinding.SplashscreenBinding
import com.maulida.readify.model.Genre
import com.maulida.readify.model.Novel
import com.squareup.picasso.LruCache
import com.squareup.picasso.Picasso

class GenreAdapter(c: Context) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {
    private var context: Context = c
    private var arrlist: List<Genre> = emptyList()
    private val memoryCacheSize = 1024 * 1024 * 10

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAdapter.GenreViewHolder {
        val binding = ItemGenreBinding.inflate(LayoutInflater.from(context), parent, false)
        return GenreViewHolder(binding)
    }

    class GenreViewHolder(val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root)

    fun setArray(dList: List<Genre>) {
        this.arrlist = dList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = arrlist.getOrNull(position)

        if (genre !=null){
            val picasso = Picasso.Builder(context)
                .memoryCache(LruCache(memoryCacheSize))
                .build()

            picasso.load(getImageForGenre(genre.idGenre))
                .into(holder.binding.imgGenre)

            holder.binding.tvGenre.text = genre.genre
        }
    }

    private fun getImageForGenre(genreId: String): Int {
        return when (genreId) {
            "1" -> R.drawable.romance
            "2" -> R.drawable.fantasi
            "3" -> R.drawable.horror
            "4" -> R.drawable.thriller
            "5" -> R.drawable.comedy
            "6" -> R.drawable.action
            "7" -> R.drawable.drama
            "8" -> R.drawable.history
            else -> R.drawable.bg_genre
        }
    }

    override fun getItemCount(): Int {
        return arrlist!!.size
    }


}