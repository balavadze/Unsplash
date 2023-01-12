package com.example.unsplash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide
import com.example.unsplash.databinding.FragmentFullScreenBinding

class FullScreenFragment : Fragment() {

    private lateinit var binding: FragmentFullScreenBinding

    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUrl = it.getString(FullScreenFragment.IMG_URL_ARGS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFullScreenBinding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageFullscreen)
    }

    companion object {
        const val IMG_URL_ARGS = "IMG_URL_ARGS"


    }
}