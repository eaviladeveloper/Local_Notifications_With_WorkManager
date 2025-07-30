package com.example.localnotificationswithworkmanager.core

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.example.localnotificationswithworkmanager.R
import kotlin.random.Random

class NotificationService(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun showBasicNotification(){
        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle(context.getString(R.string.basic_notification_title))
            .setContentText(context.getString(R.string.basic_notification_body))
            .setSmallIcon(R.drawable.icon_notification)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
    }

    fun showLargeNotification(){
        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle(context.getString(R.string.large_notification_title))
            .setContentText(context.getString(R.string.large_notification_body))
            .setSmallIcon(R.drawable.icon_notification)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(
                NotificationCompat
                    .BigTextStyle()
                    .bigText(context.getString(R.string.large_notification_content))
            )
            .setAutoCancel(true)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
    }

    fun showInboxLineNotification(){
        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle(context.getString(R.string.inbox_notification_title))
            .setContentText(context.getString(R.string.inbox_notification_body))
            .setSmallIcon(R.drawable.icon_notification)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(
                NotificationCompat
                    .InboxStyle()
                    .addLine("1.- "+context.getString(R.string.notifications_detail))
                    .addLine("2.- "+context.getString(R.string.notifications_detail))
                    .addLine("3.- "+context.getString(R.string.notifications_detail))
                    .addLine("4.- "+context.getString(R.string.notifications_detail))
                    .addLine("5.- "+context.getString(R.string.notifications_detail))
            )
            .setAutoCancel(true)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
    }

    private fun Context.bitmapFromResource(@DrawableRes resId : Int) = BitmapFactory.decodeResource(resources, resId)

    fun showImageNotification(){
        val image = context.bitmapFromResource(R.drawable.image_notification)
        val notification = NotificationCompat.Builder(context,"123")
            .setContentTitle(context.getString(R.string.image_notification_title))
            .setContentText(context.getString(R.string.image_notification_body))
            .setSmallIcon(R.drawable.icon_notification)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setLargeIcon(image)
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(image)
                    .bigLargeIcon(null as Bitmap?)
            )
            .setAutoCancel(true)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
    }

}