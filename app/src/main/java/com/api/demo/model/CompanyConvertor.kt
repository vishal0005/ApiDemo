package com.api.demo.model

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class CompanyConvertor {

    @TypeConverter
    open fun storedStringToCompany(value: String): Company? {
        var company = Gson().fromJson<Company>(value, Company::class.java)
        return company
    }

    @TypeConverter
    open fun CompanyToStoredString(cl: Company): String {
        var value = Gson().toJson(cl)
        return value
    }
}