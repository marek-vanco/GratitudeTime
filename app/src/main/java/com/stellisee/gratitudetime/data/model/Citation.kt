package com.stellisee.gratitudetime.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Citation(
        @PrimaryKey(autoGenerate = true) val uid: Int,
        @ColumnInfo(name = "phrase") val phrase: String?,
        @ColumnInfo(name = "author") val author: String?
)