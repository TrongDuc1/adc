package com.example.btt2screen.fragmentscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btt2screen.R
import com.example.btt2screen.home.Property
import com.example.btt2screen.service.Api
import com.example.btt2screen.service.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentSofa : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sofa, container, false)
    }
    companion object {
        fun newInstance(): FragmentSofa = FragmentSofa()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view) // Thay vì requireView()
        manager = GridLayoutManager(activity,2)
        getsofaData()
    }
    fun getsofaData(){
        Api.retrofitService.getsofaData().enqueue(object: Callback<List<Property>> {
            override fun onResponse(
                call: Call<List<Property>>,
                response: Response<List<Property>>
            ) {
                if(response.isSuccessful){
                    recyclerView =  requireView().findViewById<RecyclerView>(R.id.recycler_view).apply{
                        myAdapter = MyAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = myAdapter
                    }
                }
            }
            override fun onFailure(call: Call<List<Property>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}