package com.api.demo.model

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class AddressConvertor {
    @TypeConverter
    open fun storedStringToAddress(value: String): Address? {
        var address = Gson().fromJson<Address>(value, Address::class.java)
//        val langs: List<String> = Arrays.asList(value.split("\\s*,\\s*").toTypedArray())
        return address
    }

    @TypeConverter
    open fun AddressToStoredString(cl: Address): String {
        var value = Gson().toJson(cl)
        return value
    }

}