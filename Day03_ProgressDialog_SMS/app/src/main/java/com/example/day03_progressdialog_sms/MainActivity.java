package com.example.day03_progressdialog_sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnProgress;
    ProgressDialog myPro_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProgress = findViewById(R.id.btnProgress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPro_bar = new ProgressDialog(MainActivity.this);
                myPro_bar.setMessage("Loading...");
                myPro_bar.setTitle("Please wait...");
                myPro_bar.setProgressStyle(myPro_bar.STYLE_HORIZONTAL);
                myPro_bar.setProgress(0);
                myPro_bar.setMax(20);
                myPro_bar.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            while(myPro_bar.getProgress() < myPro_bar.getMax()){
                                Thread.sleep(1000);
                                handler.sendMessage(handler.obtainMessage());
                            }
                            if(myPro_bar.getProgress() == myPro_bar.getMax()){
                                myPro_bar.dismiss();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            Handler handler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    myPro_bar.incrementProgressBy(2);
                }
            };
        });
    }

    public void clickToSMS(View view) {
        Intent intent = new Intent(this, SendSMSActivity.class);
        startActivity(intent);
    }
}
