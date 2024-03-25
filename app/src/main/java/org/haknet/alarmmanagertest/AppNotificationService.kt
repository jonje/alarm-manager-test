package org.haknet.alarmmanagertest

import android.content.Context
import androidx.core.app.NotificationCompat

class AppNotificationService(private val context: Context) {

    fun showNotification(counter: Int) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_adb_24)
            .setContentTitle("Increment Counter")
            .setContentText("The count is $counter")

    }
    companion object {
        const val CHANNEL_ID = "first_notification_channel"
    }
}