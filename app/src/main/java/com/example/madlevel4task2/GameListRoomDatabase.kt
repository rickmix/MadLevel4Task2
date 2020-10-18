package com.example.madlevel4task2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameListRoomDatabase : RoomDatabase() {
    abstract fun productDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAME_LIST_DATABASE"

        @Volatile
        private var shoppingListRoomDatabaseInstance: GameListRoomDatabase? = null

        fun getDatabase(context: Context): GameListRoomDatabase? {
            if(shoppingListRoomDatabaseInstance == null) {
                synchronized(GameListRoomDatabase::class.java) {
                    if(shoppingListRoomDatabaseInstance == null) {
                        shoppingListRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            GameListRoomDatabase::class.java, DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return shoppingListRoomDatabaseInstance
        }
    }
}