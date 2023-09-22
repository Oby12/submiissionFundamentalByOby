package com.learn.submiissionfundamentalbyoby.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.submiissionfundamentalbyoby.data.response.ItemsItem
import com.learn.submiissionfundamentalbyoby.data.response.UserResponse
import com.learn.submiissionfundamentalbyoby.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Query

class MainUserModel :ViewModel() {

    /*val listUser = MutableLiveData<ArrayList<ItemsItem>>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun setUser (query: String){
        UserResponse.api
    }*/

    private val _ItemsItem = MutableLiveData<ItemsItem>()
    val itemsItem : LiveData<ItemsItem> = _ItemsItem

    private val _listUser = MutableLiveData<ArrayList<ItemsItem>>()
    val listUser : LiveData<ArrayList<ItemsItem>> =_listUser

    //loading
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "MainActivity"
        private const val USER_ID = "104689136"
    }

    init{
        findUser()
    }

    private fun findUser() {
        _isLoading.value =true
        val client = ApiConfig.getApiService().getUserOby(USER_ID)
        client.enqueue(object : Callback<List<UserResponse>>{
            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listUser.value = response.body()?.items?.
                    Log.e(TAG, "Tidak DI temukan : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG,"Tidak DI temukan : ${t.message.toString()}")
            }

        })
    }
}