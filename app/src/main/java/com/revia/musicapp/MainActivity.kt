package com.revia.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.revia.musicapp.api.APIInterface
import com.revia.musicapp.responseData.MyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRecyclerView = findViewById(R.id.recyclerView)
        val retrofitBuilder = Retrofit.Builder()
                            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(APIInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList = response.body()?.data!!
                myAdapter = MyAdapter(this@MainActivity, dataList)
                myRecyclerView.adapter = myAdapter
                myRecyclerView.layoutManager= LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG: onFailure", "onFailure: $t")
            }
        })


    }
}