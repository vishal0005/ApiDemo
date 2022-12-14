package com.api.demo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Company(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "bs")val bs: String?,
    @ColumnInfo(name = "catchPhrase")val catchPhrase: String?,
    @ColumnInfo(name = "name")val name: String?
)