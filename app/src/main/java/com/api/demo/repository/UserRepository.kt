package com.api.demo.repository

import androidx.lifecycle.MutableLiveData
import com.api.demo.model.UserModel
import com.api.demo.model.UserModelItem
import kotlinx.coroutines.*

class UserRepository {
    var jobUser: Job? = null
    fun getOnlineUser(scope: CoroutineScope, liveUser: MutableLiveData<UserModel>) {
        jobUser = scope.launch {
            var response = RetrofitHelper.getInstance().create(ApiInterface::class.java).getUser()
            CoroutineScope(Dispatchers.Main).launch {
                var fff = response.body()
                liveUser.postValue(fff)
            }
        }
    }
}