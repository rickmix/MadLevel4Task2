package com.example.madlevel4task2

import android.util.Log
import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun otherDateConverter(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateConverter(date: Date?): Long? {
        return date?.time?.toLong()
    }
}