package org.nathit.currencybtc.data.repository

import org.nathit.currencybtc.data.local.sharedpreeeeferences.SecurePreferences
import org.nathit.currencybtc.domain.repository.SecurePreferenceRepository

class SecurePreferenceRepositoryImpl(private val prefs: SecurePreferences) :
    SecurePreferenceRepository {
    override fun commitIntSharedPreference(prefKey: String, value: Int) {
        prefs.commitIntSharedPreference(prefKey, value)
    }

    override fun getIntSharedPreference(prefKey: String): Int? {
        return prefs.getIntSharedPreference(prefKey)
    }

    override fun commitBooleanSharedPreference(prefKey: String, value: Boolean) {
        prefs.commitBooleanSharedPreference(prefKey, value)
    }

    override fun getBooleanSharedPreference(prefKey: String): Boolean? {
        return prefs.getBooleanSharedPreference(prefKey)
    }

    override fun commitStringSharedPreference(prefKey: String, value: String?) {
        prefs.commitStringSharedPreference(prefKey, value)
    }

    override fun getStringSharedPreference(prefKey: String): String? {
        return prefs.getStringSharedPreference(prefKey)
    }

    override fun commitLongSharedPreference(prefKey: String, value: Long) {
        prefs.commitLongSharedPreference(prefKey, value)
    }

    override fun getLongSharedPreference(prefKey: String): Long? {
        return prefs.getLongSharedPreference(prefKey)
    }

    override fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>) {
        prefs.commitArrayStringSharedPreference(prefKey, value)
    }

    override fun getArrayStringSharedPreference(prefKey: String): ArrayList<*>? {
        return prefs.getArrayStringSharedPreference(prefKey)
    }

    override fun removeSharePreferenceByPrefKey(prefKey: String) {
        prefs.removeSharePreferenceByPrefKey(prefKey)
    }

}