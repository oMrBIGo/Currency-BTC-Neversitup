package org.nathit.currencybtc.domain.usecase

import org.nathit.currencybtc.domain.repository.SecurePreferenceRepository

class SecurePreferencesUseCase(private val repo: SecurePreferenceRepository) {

    fun commitIntSharedPreference(prefKey: String, value: Int) =
        repo.commitIntSharedPreference(prefKey, value)

    fun getIntSharedPreference(prefKey: String) = repo.getIntSharedPreference(prefKey)

    fun commitBooleanSharedPreference(prefKey: String, value: Boolean) =
        repo.commitBooleanSharedPreference(prefKey, value)

    fun getBooleanSharedPreference(prefKey: String) = repo.getBooleanSharedPreference(prefKey)

    fun commitStringSharedPreference(prefKey: String, value: String?) =
        repo.commitStringSharedPreference(prefKey, value)

    fun getStringSharedPreference(prefKey: String) =
        repo.getStringSharedPreference(prefKey)

    fun commitLongSharedPreference(prefKey: String, value: Long) =
        repo.commitLongSharedPreference(prefKey, value)

    fun getLongSharedPreference(prefKey: String) = repo.getLongSharedPreference(prefKey)

    fun commitArrayStringSharedPreference(prefKey: String, value: ArrayList<*>) =
        repo.commitArrayStringSharedPreference(prefKey, value)

    fun getArrayStringSharedPreference(prefKey: String) = repo.getArrayStringSharedPreference(prefKey)

    fun removeSharePreferenceByPrefKey(prefKey: String) = repo.removeSharePreferenceByPrefKey(prefKey)

}