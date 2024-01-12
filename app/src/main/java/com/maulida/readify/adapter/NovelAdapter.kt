package com.maulida.readify.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maulida.readify.databinding.ItemNovelBinding
import com.maulida.readify.model.Novel
import com.squareup.picasso.Picasso

class NovelAdapter(c: Context) : RecyclerView.Adapter<NovelAdapter.NovelViewHolder>() {
    private var context: Context = c
    private var arrlist: List<Novel> = emptyList()

    private var mListenerButton: onButtonItemClickListener? = null
    private var mListener: onItemClickListener? = null
    private var mListenerLong: onItemLongClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelViewHolder {
        val binding = ItemNovelBinding.inflate(LayoutInflater.from(context), parent, false)
        return NovelViewHolder(binding)
    }

    class NovelViewHolder(val binding: ItemNovelBinding) : RecyclerView.ViewHolder(binding.root)

    fun setArray(dList: List<Novel>) {
        this.arrlist = dList
        notifyDataSetChanged()
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
        val novel = arrlist.getOrNull(position)

        if (novel != null){
            Picasso.get().load(getImageUrlForNovel(novel.idNovel)).into(holder.binding.imageView)

            holder.binding.tvGenre.text = novel.genreNovel
            holder.binding.tvJudul.text = novel.judulNovel
            holder.binding.tvDesc.text = novel.descNovel

            holder.itemView.setOnClickListener { view ->
                mListener?.setOnItemClickListener(position, novel)
            }
        }

//        holder.binding.tvGenre.text = arrlist!![position].genreNovel
//        holder.binding.tvJudul.text = arrlist!![position].judulNovel
//        holder.binding.tvDesc.text = arrlist!![position].descNovel

//        holder.itemView.setOnClickListener { view ->
//            mListener?.setOnItemClickListener(position, arrlist!![position])
//        }
    }

    private fun getImageUrlForNovel(novelId: String): String {
        return when (novelId) {
            "1" -> "https://swebtoon-phinf.pstatic.net/20161006_64/1475757064923Cg5u7_JPEG/Details_mobile.jpg?type=crop540_540"
            "2" -> "https://swebtoon-phinf.pstatic.net/20220426_265/1650933464241MLrcs_JPEG/828720x123029Blue_mobile_landingpage.jpg?type=crop540_540"
            "3" -> "https://swebtoon-phinf.pstatic.net/20210331_138/1617152372024Dq7Wb_JPEG/4WeakHero_mobile_landingpage.jpg?type=crop540_540"
            "4" -> "https://swebtoon-phinf.pstatic.net/20210423_257/16191575697620smLg_JPEG/504_EC9E91ED9288EC8381EC84B8_mobile2B28129+28129.jpg?type=crop540_540"
            "5" -> "https://swebtoon-phinf.pstatic.net/20210422_231/1619017421879FrCh3_JPEG/8M_details.jpg?type=crop540_540"
            else -> "DEFAULT_URL_GAMBAR"
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