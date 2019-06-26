package com.example.filrougemobile.data.model

import java.net.PasswordAuthentication

// Class Log useur -
data class LoggedInUser(
    val userId: String,
    val passwordAuthentication: PasswordAuthentication
)
