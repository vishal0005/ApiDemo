package com.api.demo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Geo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "lat")val lat: String?,
    @ColumnInfo(name = "lng")val lng: String?
)