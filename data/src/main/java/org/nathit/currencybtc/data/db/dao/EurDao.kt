package org.nathit.currencybtc.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.nathit.currencybtc.data.db.model.Eur

@Dao
interface EurDao {

    //@Insert
    //suspend fun addEur(eur: Eur)

    //@Query("SELECT * FROM Eur ORDER BY id DESC")
    //suspend fun getEur(): List<Eur>

   // @Delete
    //suspend fun deleteEur(eur: Eur)
}