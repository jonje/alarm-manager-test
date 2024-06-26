package org.haknet.alarmmanagertest

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val channel = NotificationChannel(
            NotificationConstants.CHANNEL_ID,
            "First_Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}