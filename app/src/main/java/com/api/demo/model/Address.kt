package com.api.demo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class Address(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "city") val city: String?,
    @TypeConverters(GeoConvertor::class) @ColumnInfo(name = "geo") val geo: Geo?,
    @ColumnInfo(name = "street") val street: String?,
    @ColumnInfo(name = "suite") val suite: String?,
    @ColumnInfo(name = "zipcode") val zipcode: String?
)