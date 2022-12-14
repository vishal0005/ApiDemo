package com.api.demo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import org.jetbrains.annotations.NotNull

@Entity
data class UserModelItem(
    @TypeConverters(AddressConvertor::class) @ColumnInfo(name = "address") val address: Address?,
    @TypeConverters(CompanyConvertor::class) @ColumnInfo(name = "company") val company: Company?,
    @ColumnInfo(name = "email") val email: String?,
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "website") val website: String?
)