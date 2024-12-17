package com.example.myapplicatior;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import okhttp3.HttpUrl;

public class NotificationService extends NotificationListenerService {
    Context context;
    String idData = HttpUrl.FRAGMENT_ENCODE_SET;
    String textData = HttpUrl.FRAGMENT_ENCODE_SET;
    String titleData = HttpUrl.FRAGMENT_ENCODE_SET;

    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
    }

    public void onNotificationPosted(StatusBarNotification sbn) {
        String packageName = sbn.getPackageName();
        Bundle bundle = sbn.getNotification().extras;
        if (bundle.getString(NotificationCompat.EXTRA_TITLE) != null) {
            this.titleData = bundle.getString(NotificationCompat.EXTRA_TITLE);
        } else {
            this.titleData = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (bundle.getCharSequence(NotificationCompat.EXTRA_TEXT) != null) {
            this.textData = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT).toString();
        } else {
            this.textData = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (bundle.getCharSequence("android.id ") != null) {
            this.idData = bundle.getCharSequence("android.id ").toString();
        } else {
            this.idData = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Log.d("Package", packageName);
        Log.d("Title", this.titleData);
        Log.d("Text", this.textData);
        Log.d("ID", this.idData);
        Intent intent = new Intent("Msg");
        intent.putExtra("package", packageName);
        intent.putExtra("title", this.titleData);
        intent.putExtra("text", this.textData);
        intent.putExtra("id", this.idData);
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.d("Msg", "Notification Removed");
    }
}
