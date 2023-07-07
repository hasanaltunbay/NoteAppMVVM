package com.hasanaltunbay.notlarmapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTLAR")
data class Notlar(

    @ColumnInfo("noteid")
    @PrimaryKey(autoGenerate = true)
    val notid:Int,

    @ColumnInfo("notbaslik")
    val notbaslik:String,

    @ColumnInfo("notaltbaslik")
    val notaltbaslik:String,

    @ColumnInfo("notgir")
    val notgir:String
)