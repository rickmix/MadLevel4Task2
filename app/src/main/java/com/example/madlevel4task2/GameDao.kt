package com.example.madlevel4task2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {
    @Query("SELECT * FROM game ORDER BY time DESC")
    suspend fun getAllGames(): List<Game>

    @Query("DELETE FROM game")
    suspend fun deleteAllGames()

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteProduct(game: Game)

    @Query("SELECT COUNT(*) FROM game WHERE stats = 'Computer wins!'")
    suspend fun getLostGames(): String

    @Query("SELECT COUNT(*) FROM game WHERE stats = 'You win!'")
    suspend fun getWonGames(): String

    @Query("SELECT COUNT(*) FROM game WHERE stats = 'Draw!'")
    suspend fun getDrawGames(): String
}