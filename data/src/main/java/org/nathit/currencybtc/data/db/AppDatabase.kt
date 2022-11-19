package org.nathit.currencybtc.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.nathit.currencybtc.data.db.dao.EurDao
import org.nathit.currencybtc.data.db.model.Eur

@Database(entities = [Eur::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getEurDao(): EurDao

    companion object {

        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:  synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app-database"
        ).build()
    }
}