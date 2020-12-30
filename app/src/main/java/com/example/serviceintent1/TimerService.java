package com.example.serviceintent1;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class TimerService extends IntentService {


    public TimerService() {
        super("Timer Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("timer", "Timer service has started.");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null) {
            int time = 5;

            for (int i = 0; i < time; i++) {
                Log.v("timer", "i(intent is null) = " + i);

                try {

                    Thread.sleep(1000);

                } catch (Exception e) {

                }
            }

            NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
            nb.setContentText("Timer done.");
            nb.setContentTitle("Hi!");
            nb.setSmallIcon(R.mipmap.ic_launcher);

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(1, nb.build());
            return;

        }
        ResultReceiver receiver = intent.getParcelableExtra("receiver");
        int time = intent.getIntExtra("time", 0);

        for (int i = 0; i < time; i++) {
            Log.v("timer", "i(intent is not null) = " + i);

            try {

                Thread.sleep(1000);

            } catch (Exception e) {

            }
        }

        Bundle bundle = new Bundle();
        bundle.putString("message", "counting done...");

        receiver.send(1234, bundle);

    }
}
