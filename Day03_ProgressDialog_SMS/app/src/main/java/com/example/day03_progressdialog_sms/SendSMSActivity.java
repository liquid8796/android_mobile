package com.example.day03_progressdialog_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends AppCompatActivity {
    private EditText edtPhoneNo, edtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        edtPhoneNo = findViewById(R.id.edtPhoneNo);
        edtContent = findViewById(R.id.edtContent);
    }

    public void clickToSend(View view) {
        String phone = edtPhoneNo.getText().toString();
        String content = edtContent.getText().toString();
        final SmsManager smsManager = SmsManager.getDefault();
        Intent intent = new Intent("NamTLH_Send_SMS");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Send OK";
                if(result != Activity.RESULT_OK){
                    msg = "Send failed";
                }
                Toast.makeText(SendSMSActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("NamTLH_Send_SMS"));
        smsManager.sendTextMessage(phone, null, content, pendingIntent, null);
        finish();
    }
}
