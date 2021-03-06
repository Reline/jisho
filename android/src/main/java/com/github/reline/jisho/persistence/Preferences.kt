/*
 * Copyright 2020 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho.persistence

import android.content.SharedPreferences
import javax.inject.Inject

class Preferences @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun setOfflineMode(enabled: Boolean) {
        sharedPreferences.edit()
                .putBoolean(OFFLINE_MODE, enabled)
                .apply()
    }

    fun isOfflineModeEnabled(): Boolean {
        return sharedPreferences.getBoolean(OFFLINE_MODE, OFFLINE_MODE_ENABLED_DEFAULT)
    }

    companion object {
        private const val OFFLINE_MODE = "OFFLINE_MODE"
        private const val OFFLINE_MODE_ENABLED_DEFAULT = false
    }
}
