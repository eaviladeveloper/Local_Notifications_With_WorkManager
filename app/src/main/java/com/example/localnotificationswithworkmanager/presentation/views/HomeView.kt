package com.example.localnotificationswithworkmanager.presentation.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.localnotificationswithworkmanager.R
import com.example.localnotificationswithworkmanager.core.NotificationService
import com.example.localnotificationswithworkmanager.core.NotificationWorker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.home_title),
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) { paddingValues ->
        val context = LocalContext.current
        val notificationService = NotificationService(context)

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { notificationService.showBasicNotification() }) {
                Text(text = stringResource(R.string.basic_notification_title))
            }

            Button(onClick = { notificationService.showLargeNotification() }) {
                Text(text = stringResource(R.string.large_notification_title))
            }

            Button(onClick = { notificationService.showInboxLineNotification() }) {
                Text(text = stringResource(R.string.inbox_notification_title))
            }

            Button(onClick = { notificationService.showImageNotification() }) {
                Text(text = stringResource(R.string.image_notification_title))
            }

            Button(onClick = {
                Toast.makeText(context, R.string.toast_messsage_notification, Toast.LENGTH_SHORT).show()
                NotificationWorker.releaseNotification(context)
            }) {
                Text(text = stringResource(R.string.background_notification_title))
            }
        }
    }

}