package com.example.madlevel4task2

import android.content.Context

class GameRepository(context: Context) {
    private var gameDao: GameDao

    init {
        val database = GameListRoomDatabase.getDatabase(context)
        gameDao = database!!.productDao()
    }

    suspend fun getAllGames(): List<Game> {
        return gameDao.getAllGames()
    }

    suspend fun deleteAllGames() {
        return gameDao.deleteAllGames()
    }

    suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gameDao.deleteProduct(game)
    }

    suspend fun getLostGames(): String {
        return gameDao.getLostGames()
    }

    suspend fun getWonGames(): String {
        return gameDao.getWonGames()
    }

    suspend fun getDrawGames(): String {
        return gameDao.getDrawGames()
    }

}