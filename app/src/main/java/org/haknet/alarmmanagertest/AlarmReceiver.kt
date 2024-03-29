package org.haknet.alarmmanagertest

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class AlarmReceiver() : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("EXTRA_MESSAGE") ?: return

        context?.let {

            val notification = NotificationCompat.Builder(it, NotificationConstants.CHANNEL_ID)
                .setContentText(message)
                .setContentTitle("Scheduled Notification")
                .setSmallIcon(R.drawable.baseline_adb_24)
                .build()
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.notify(1, notification)
        }

        println("Alarm Triggered: $message")
    }
}