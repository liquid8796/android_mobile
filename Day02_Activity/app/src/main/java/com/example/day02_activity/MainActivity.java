package com.example.day02_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private static final int REQ_CODE = 6789;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
//        Intent intent = this.getIntent();
//        String username = intent.getStringExtra("username");
//        String phoneNo = intent.getStringExtra("phoneNo");
//        String email = intent.getStringExtra("email");
//        String result = "Username: "+ username + "\n"
//                        + "Phone number: " + phoneNo + "\n"
//                        + "Email: " + email + "\n";
//        txtResult.setText(result);
    }


    public void clickToInput(View view) {
        Intent intent = new Intent(this, InputActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE){
            if(resultCode == RESULT_OK){
                String username = data.getStringExtra("username");
                String phoneNo = data.getStringExtra("phoneNo");
                String email = data.getStringExtra("email");
                String result = "Username: "+ username + "\n"
                        + "Phone number: " + phoneNo + "\n"
                        + "Email: " + email + "\n";
                txtResult.setText(result);
            }
        }
        System.out.println("        onActivityResult");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("        onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("        onStart");
    }
}
