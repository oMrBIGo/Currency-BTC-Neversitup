package org.nathit.currencybtc.domain.repository

interface SecurePreferenceRepository {
    fun commitIntSharedPreference(prefKey: String, value: Int)
    fun getIntSharedPreference(prefKey: String): Int?
    fun commitBooleanSharedPreference(prefKey: String, value: Boolean)
    fun getBooleanSharedPreference(prefKey: String): Boolean?
    fun commitStringSharedPreference(prefKey: String, value: String?)
    fun getStringSharedPreference(prefKey: String): String?
    fun commitLongSharedPreference(prefKey: String, value: Long)
    fun getLongSharedPreference(prefKey: String): Long?
    fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>)
    fun getArrayStringSharedPreference(prefKey: String): ArrayList<*>?
    fun removeSharePreferenceByPrefKey(prefKey: String)

}