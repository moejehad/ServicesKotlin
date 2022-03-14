package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    lateinit var mp:MediaPlayer
    var MyNotificationManager:MyNotificationManager? = null

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        MyNotificationManager = MyNotificationManager(this)

        Toast.makeText(this,"Service is Created",Toast.LENGTH_SHORT).show()
        mp = MediaPlayer.create(this,R.raw.moe)
        mp.isLooping = true

        startForeground(MyNotificationManager!!.getNotificationID(),MyNotificationManager!!.getNotification(this))
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val s = intent!!.getStringExtra("username")
        Toast.makeText(this,"username = $s",Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"Service is Started",Toast.LENGTH_SHORT).show()
        mp.start()
        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        Toast.makeText(this,"Service is Destroy",Toast.LENGTH_SHORT).show()
        mp.pause()
        super.onDestroy()
    }
}
