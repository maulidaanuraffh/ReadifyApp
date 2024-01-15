package com.maulida.readify.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.maulida.readify.R
import com.maulida.readify.adapter.GenreAdapter
import com.maulida.readify.adapter.NovelAdapter
import com.maulida.readify.databinding.FragmentHomeBinding
import com.maulida.readify.databinding.FragmentPerpustakaanBinding
import com.maulida.readify.model.Genre
import com.maulida.readify.model.Novel
import com.maulida.readify.model.listDataGenre
import com.maulida.readify.model.listDataNovel

class PerpustakaanFragment : Fragment() {
    private var _binding: FragmentPerpustakaanBinding? = null
    private val binding get() = _binding!!

    private lateinit var novelAdapter: NovelAdapter

    private var listNovel = ArrayList<Novel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerpustakaanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listNovel.addAll(listDataNovel)
        novelAdapter = NovelAdapter(requireContext())

        // Set RecyclerView untuk Novel
        binding.rvNovel.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        novelAdapter.setArray(listNovel)
        binding.rvNovel.adapter = novelAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}