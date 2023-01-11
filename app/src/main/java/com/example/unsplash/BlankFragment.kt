package com.example.unsplash

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlankFragment : Fragment() {
    val adapter = PhotoGridAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle_Tag", "onCreate")


        // setContentView(R.layout.activity_main)
    }

    fun loadUnsplash() {
        API.retrofitApi.getRandomImage()
            .enqueue(object : Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    val photo = response.body()
                    if (photo != null) {
                        adapter.list.add(photo)
                        adapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {
                }
            })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Lifecycle_Tag", "onAttach")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Lifecycle_Tag", "onViewCreated")

        val recyclerView = view.findViewById<RecyclerView>(R.id.photos_grid)
        recyclerView.adapter = adapter

        view.findViewById<Button>(R.id.load).setOnClickListener {
            loadUnsplash()
        }

        view.findViewById<ImageView>(R.id.photos_grid).setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_blankFragment2)



            // findNavController().navigate(R.id.action_blankFragment_to_blankFragment2)
            /*parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SecondFragment())
                .addToBackStack(null)
                .commit()*/

        }


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
