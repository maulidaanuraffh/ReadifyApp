package com.maulida.readify.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maulida.readify.R
import com.maulida.readify.databinding.ItemNovelBinding
import com.maulida.readify.model.Novel

class NovelAdapter(c: Context) : RecyclerView.Adapter<NovelAdapter.NovelViewHolder>() {
    private var context: Context = c
    private var arrlist: List<Novel>? = ArrayList()

    private var mListenerButton: onButtonItemClickListener? = null
    private var mListener: onItemClickListener? = null
    private var mListenerLong: onItemLongClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelViewHolder {
        val binding = ItemNovelBinding.inflate(LayoutInflater.from(context), parent, false)

        return NovelViewHolder(binding)
    }

    class NovelViewHolder(val binding: ItemNovelBinding) : RecyclerView.ViewHolder(binding.root)

    fun setArray(dList: ArrayList<Novel>) {
        this.arrlist = dList
    }

    fun setButtonOnClickListener(listenerButton: onButtonItemClickListener) {
        mListenerButton = listenerButton
    }

    fun setOnClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    //setListener agar bisa di panggil di activity
    fun setOnLongClickListener(listener: onItemLongClickListener) {
        mListenerLong = listener
    }

    override fun onBindViewHolder(holder: NovelViewHolder, position: Int) {
        holder.binding.tvGenre.text = arrlist!![position].genreNovel
        holder.binding.tvJudul.text = arrlist!![position].judulNovel
        holder.binding.tvDesc.text = arrlist!![position].descNovel

        holder.itemView.setOnClickListener { view ->
            mListener?.setOnItemClickListener(position, arrlist!![position])
        }

    }

    interface onItemClickListener {
        fun setOnItemClickListener(position: Int, novel: Novel)
    }

    interface onButtonItemClickListener {
        fun setOnButtonItemClickListener(position: Int, novel: Novel)
    }

    //interface listener onLongClick
    interface onItemLongClickListener {
        fun setOnItemLongClickListener(position: Int, novel: Novel)
    }

    override fun getItemCount(): Int {
        return arrlist!!.size
    }


}