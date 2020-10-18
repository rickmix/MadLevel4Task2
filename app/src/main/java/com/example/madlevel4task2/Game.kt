package com.example.madlevel4task2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "game")
data class Game(
    @ColumnInfo(name = "stats")
    var gameStats: String?,
    @ColumnInfo(name = "time")
    var gameTime: Date?,
    @ColumnInfo(name = "player_move")
    var playerMove: String?,
    @ColumnInfo(name = "computer_move")
    var computerMove: String?,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)