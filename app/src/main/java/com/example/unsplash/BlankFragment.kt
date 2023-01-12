package com.example.unsplash

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.FullScreenFragment.Companion.IMG_URL_ARGS
import com.example.unsplash.databinding.FragmentBlankBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BlankFragment : Fragment() {
    val adapter = PhotoGridAdapter(::openImage)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle_Tag", "onCreate")
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Lifecycle_Tag", "onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Lifecycle_Tag", "onViewCreated")

        val recyclerView = view.findViewById<RecyclerView>(R.id.photos_grid)
        recyclerView.adapter = adapter

        view.findViewById<Button>(R.id.load).setOnClickListener {
            loadUnsplash()
        }

        view.findViewById<RecyclerView>(R.id.photos_grid).setOnClickListener {
        }
    }

    fun loadUnsplash() {
        API.retrofitApi.getRandomImage()
            .enqueue(object : Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    val photo = response.body()
                    if (photo != null) {
                        adapter.data.add(photo)
                        adapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {
                }
            })
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
