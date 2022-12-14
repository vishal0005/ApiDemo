package com.api.demo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.api.demo.model.*

@Database(
    entities = [UserModelItem::class, Address::class, Company::class, Geo::class],
    version = 1
)
@TypeConverters(AddressConvertor::class, CompanyConvertor::class, GeoConvertor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(cn: Context): AppDatabase {
            var addressConvertor = AddressConvertor()
            var companyConvertor = CompanyConvertor()
//            var geoConvertor = GeoConvertor()
            val db = Room.databaseBuilder(cn, AppDatabase::class.java, "UserModelItem")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .addTypeConverter(addressConvertor)
                .addTypeConverter(companyConvertor)
//                .addTypeConverter(geoConvertor)
                .build()
            return db
        }
    }

}