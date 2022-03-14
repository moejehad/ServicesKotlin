package com.example.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            val i = Intent(this,MyService::class.java)
            i.putExtra("username","admin")
            startService(i)
        }

        btn_end.setOnClickListener {
            val i = Intent(this,MyService::class.java)
            stopService(i)
        }

        btn_Notification.setOnClickListener {
            val intent = Intent(this,NotificationActivity::class.java)
            intent.putExtra("data","notification intent")
            val mngr = MyNotificationManager(this)
            mngr.showSmallNotification(1,"Notification Lab","sdfsd fsdfsdf",intent)
        }

    }


}