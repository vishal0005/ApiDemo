package com.api.demo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.api.demo.model.UserModelItem

@Dao
interface UserDao {

    @Query("select * from UserModelItem")
    fun getAllUser(): List<UserModelItem>

    @Insert
    fun addUser(allUser: ArrayList<UserModelItem>)

    @Query("delete from UserModelItem")
    fun clearAllData()

}