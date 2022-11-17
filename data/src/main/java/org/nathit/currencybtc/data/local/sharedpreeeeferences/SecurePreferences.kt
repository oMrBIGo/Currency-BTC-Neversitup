package org.nathit.currencybtc.data.local.sharedpreeeeferences

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.gson.Gson
import org.nathit.currencybtc.data.constant.Singleton

class SecurePreferences(context: Context) {

    private var securePreferences: SharedPreferences

    init {
        val spec = KeyGenParameterSpec.Builder(
            MasterKey.DEFAULT_MASTER_KEY_ALIAS,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setKeySize(MasterKey.DEFAULT_AES_GCM_MASTER_KEY_SIZE)
            .build()

        val masterKey = MasterKey.Builder(context)
            .setKeyGenParameterSpec(spec)
            .build()

        securePreferences = EncryptedSharedPreferences.create(
            context,
            Singleton.Preferences.fileName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
    }

    fun commitIntSharedPreference(prefKey: String, value: Int) {
        securePreferences.edit {
            putInt(prefKey , value)
        }
    }

    fun getIntSharedPreference(prefKey: String): Int? {
        return securePreferences.getInt(prefKey , -1)
    }

    fun commitBooleanSharedPreference(prefKey: String, value: Boolean) {
        securePreferences.edit {
            putBoolean(prefKey , value)
        }
    }

    fun getBooleanSharedPreference(prefKey: String): Boolean? {
        return securePreferences.getBoolean(prefKey , false)
    }

    fun commitStringSharedPreference(prefKey: String, value: String?) {
        securePreferences.edit {
            putString(prefKey , value)
        }
    }

    fun getStringSharedPreference(prefKey: String): String? {
        return securePreferences.getString(prefKey , "")
    }

    fun commitLongSharedPreference(prefKey: String, value: Long) {
        securePreferences.edit {
            putLong(prefKey , value)
        }
    }

    fun getLongSharedPreference(prefKey: String): Long? {
        return securePreferences.getLong(prefKey , -1)
    }

    fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>){
        val json = Gson().toJson(value)
        securePreferences.edit {
            putString(prefKey , json)
        }
    }

    fun getArrayStringSharedPreference(prefKey: String): ArrayList<*>?{
        val json = securePreferences.getString(prefKey , "")
        return Gson().fromJson(json , ArrayList::class.java) as ArrayList<*>
    }

    fun removeSharePreferenceByPrefKey(prefKey: String){
        securePreferences.edit {
            remove(prefKey)
        }
    }

    fun getAllKeyPreference(): MutableMap<String, *>? {
        return securePreferences.all
    }

}