package kr.co.fastcampus.co.kr.coroutines.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.co.fastcampus.co.kr.coroutines.R
import kr.co.fastcampus.co.kr.coroutines.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var imageSearchViewModel: ImageSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageSearchViewModel = ViewModelProvider(requireActivity())[ImageSearchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val adapter = FavoritesAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context, 4)

        viewLifecycleOwner.lifecycleScope.launch {
            imageSearchViewModel.favoritesFlow.collectLatest {
                adapter.setItems(it)
            }
        }

        return binding.root
    }
}