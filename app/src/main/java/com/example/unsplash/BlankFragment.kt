package com.example.unsplash

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.FullScreenFragment.Companion.IMG_URL_ARGS
import com.example.unsplash.databinding.FragmentBlankBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlankFragment : Fragment() {
    val adapter = PhotoGridAdapter(::openImage)

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Lifecycle_Tag", "onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewModelData.observe(viewLifecycleOwner) { viewModelData ->
            adapter.data = viewModelData
            adapter.notifyDataSetChanged()
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.photos_grid)
        recyclerView.adapter = adapter
        binding.load.setOnClickListener { viewModel.loadUnsplash() }



        view.findViewById<RecyclerView>(R.id.photos_grid).setOnClickListener {}
    }


    private fun openImage(url: String) {
        val bundle = Bundle().apply {
            putString(IMG_URL_ARGS, url)
            // indNavController().navigate(R.id.action_homeFragment_to_fullscreenImageFragment, bundle)
        }
        findNavController().navigate(R.id.action_blankFragment_to_fullscreenimage2, bundle)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle_Tag", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle_Tag", "onResume")
    }


}
