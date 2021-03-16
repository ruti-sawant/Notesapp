package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Node

@Entity(tableName = "NotesTable")
class Note(@ColumnInfo(name="text") val text:String) {
    @PrimaryKey(autoGenerate = true)var id= 0
    override fun equals(other: Any?): Boolean {
        return this.text==(other as Note).text
    }
}