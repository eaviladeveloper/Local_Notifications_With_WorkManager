package com.example.localnotificationswithworkmanager.core

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.localnotificationswithworkmanager.R
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class NotificationWorker(appContext: Context, params: WorkerParameters): Worker(appContext, params) {

    override fun doWork(): Result {
        showBasicNotification()
        return Result.success()
    }

    private fun showBasicNotification(){
        val notification = NotificationCompat.Builder(applicationContext, "123")
            .setContentTitle(applicationContext.getString(R.string.background_notification_title))
            .setContentText(applicationContext.getString(R.string.background_notification_body))
            .setSmallIcon(R.drawable.icon_notification)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(Random.nextInt(), notification)
    }

    companion object {
        fun releaseNotification(context: Context){
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .setRequiresCharging(false)
                .setRequiresBatteryNotLow(false)
                .build()

            val notificationWork = OneTimeWorkRequestBuilder<NotificationWorker>()
                .setConstraints(constraints)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(context).enqueue(notificationWork)
        }
    }
}
