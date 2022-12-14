package com.api.demo.model

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class GeoConvertor {
    @TypeConverter
    open fun storedStringToGeo(value: String): Geo? {
        var geo = Gson().fromJson<Geo>(value, Geo::class.java)
        return geo
    }

    @TypeConverter
    open fun GeoToStoredString(cl: Geo): String {
        var value = Gson().toJson(cl)
        return value
    }

}