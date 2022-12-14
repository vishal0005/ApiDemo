package com.api.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.api.demo.activity.MainActivity
import com.api.demo.model.UserModel
import com.api.demo.model.UserModelItem
import com.api.demo.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MainViewModel(mainActivity: MainActivity) : ViewModel() {
    var scope = CoroutineScope(Dispatchers.IO)
    var liveUser = MutableLiveData<UserModel>()
    var userJob: Job? = null

    fun getAllUser() {
        var userRepo = UserRepository()
        userRepo.getOnlineUser(scope,liveUser)
        userJob = userRepo.jobUser
    }

}