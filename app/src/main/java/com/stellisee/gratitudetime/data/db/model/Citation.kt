package com.stellisee.gratitudetime.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Citation(
        @ColumnInfo(name = "phrase") val phrase: String,
        @ColumnInfo(name = "author") val author: String,
        @PrimaryKey(autoGenerate = true) val id: Int = 0
)

