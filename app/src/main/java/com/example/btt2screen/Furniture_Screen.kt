package com.example.btt2screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btt2screen.home.Property
import com.example.btt2screen.service.Api
import com.example.btt2screen.service.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Furniture_Screen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture_screen)
        manager = GridLayoutManager(this,2)
        getAllData()
    }
    fun getAllData(){
        Api.retrofitService.getAllData().enqueue(object: Callback<List<Property>> {
            override fun onResponse(
                call: Call<List<Property>>,
                response: Response<List<Property>>
            ) {
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply{
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