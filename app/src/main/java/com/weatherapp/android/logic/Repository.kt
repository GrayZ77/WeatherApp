package com.weatherapp.android.logic

import androidx.lifecycle.liveData
import com.weatherapp.android.logic.model.Place
import com.weatherapp.android.logic.network.WeatherNetwork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {//自动构建并返回一个LiveData对象
        //下面的内容都在子线程中进行
        val result = try {
            val placeResponse = WeatherNetwork.searchPlace(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)//将包装的结果发射出去
    }
}