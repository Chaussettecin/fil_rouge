package com.example.filrougemobile.data

import com.example.filrougemobile.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {

            val username = LoggedInUser(java.util.UUID.randomUUID().toString(), "Fabrice fabrice")
            return Result.Success(username)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {

    }
}

