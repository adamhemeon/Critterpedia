package com.critterpedia

/**
 * Display data from Google Sheets into your android app
 * Retrieved from: https://medium.com/fabcoding/display-data-from-google-sheets-into-your-android-app-without-authorization-a7ffdb1ac14f
 */


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//import android.util.Log
//import android.widget.Toast
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//
//import kotlinx.android.synthetic.main.activity_launch.*
//
//import com.myapplication.R
//import com.myapplication.models.*
//import com.myapplication.helpers.*
//import com.myapplication.services.*
//
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        //loadCritters()

    }

//    private fun loadCritters() {
//        //initiate the service
//        val destinationService  = ServiceBuilder.buildService(CritterService::class.java)
//        val requestCall =destinationService.getCritterList()
//        //make network call asynchronously
//        requestCall.enqueue(object : Callback<List<CritterItem>>{
//            override fun onResponse(call: Call<List<CritterItem>>, response: Response<List<CritterItem>>) {
//                Log.d("Response", "onResponse: ${response.body()}")
//                if (response.isSuccessful){
//                    val critterList = response.body()!!
//                    Log.d("Response", "critterList size : ${critterList.size}")
////                    country_recycler.apply {
////                        setHasFixedSize(true)
////                        layoutManager = GridLayoutManager(this@LaunchActivity,2)
////                        adapter = CountriesAdapter(response.body()!!)
////                    }
//                }else{
//                    Toast.makeText(this@LaunchActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
//                }
//            }
//            override fun onFailure(call: Call<List<CritterItem>>, t: Throwable) {
//                Toast.makeText(this@LaunchActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }

}
