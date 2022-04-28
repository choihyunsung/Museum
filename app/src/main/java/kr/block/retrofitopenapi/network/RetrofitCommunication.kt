package kr.block.retrofitopenapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCommunication {

    private lateinit var service:Retrofit

    fun getInstance(baseUrl:String):Retrofit {
       service = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return service
    }
}