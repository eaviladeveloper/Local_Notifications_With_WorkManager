package com.example.localnotificationswithworkmanager

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

class NotificationApplication : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        val notificationsChannel = NotificationChannel(
            "123",
            "notifications",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationsChannel.description = "Notifications channel"
        val notificationsManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationsManager.createNotificationChannel(notificationsChannel)
    }
}