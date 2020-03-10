package com.example.myapplication.data;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.FullscreenActivity;
import com.example.myapplication.R;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationHelper {

    private static String CHANNEL_ID = "Service";
    private static String ACTION_CLOSE = "ACTION_CLOSE";

    public static void showNotification(Context context, RemoteMessage remoteMessage) {
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);

        NotificationCompat.Builder builder = createNotification(context);
        builder.setContentText(remoteMessage.getNotification().getBody());
        builder.setContentTitle(remoteMessage.getNotification().getTitle());

        managerCompat.notify(1, builder.build());
    }

    public static NotificationCompat.Builder createNotification(Context context) {
        createNotificationChannel(context);


        Intent intent = new Intent(context, FullscreenActivity.class);

        intent.setAction(ACTION_CLOSE);
        PendingIntent pendingIntent = PendingIntent
                .getActivity(context, 0, intent, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("First notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .addAction(R.mipmap.ic_launcher, "stop", pendingIntent)
                .setContentText("hellloooooooooooo ooo ");

        return builder;
    }


    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "asdasdasdasdasdad";
            String description = "asdasfasdasfasdasf";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
