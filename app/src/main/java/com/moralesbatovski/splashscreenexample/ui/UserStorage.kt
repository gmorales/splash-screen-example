package com.moralesbatovski.splashscreenexample.ui

import android.content.Context
import android.preference.PreferenceManager

/**
 * @author Gustavo Morales
 */
data class User(val login: String, val password: String)

private const val KEY_LOGIN = "login"
private const val KEY_PASSWORD = "password"

fun Context.getUser(): User? =
        PreferenceManager
                .getDefaultSharedPreferences(this)
                .let { sharedPreferences ->
                    val login = sharedPreferences.getString(KEY_LOGIN, null)
                    val password = sharedPreferences.getString(KEY_PASSWORD, null)
                    if (login?.isNotBlank() == true && password?.isNotBlank() == true) {
                        User(login, password)
                    } else {
                        null
                    }
                }

fun Context.saveUser(user: User) =
        PreferenceManager
                .getDefaultSharedPreferences(this)
                .edit()
                .also { sharedPreferences ->
                    sharedPreferences.putString(KEY_LOGIN, user.login)
                    sharedPreferences.putString(KEY_PASSWORD, user.password)
                }
                .apply()
