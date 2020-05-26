package com.example.day02_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private EditText edtUsername, edtPhoneNo, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        edtUsername = findViewById(R.id.edtUsername);
        edtPhoneNo = findViewById(R.id.edtPhoneNo);
        edtEmail = findViewById(R.id.edtEmail);
    }

    public void clickToDone(View view) {
        String username = edtUsername.getText().toString();
        String phoneNo = edtPhoneNo.getText().toString();
        String email = edtEmail.getText().toString();
        Intent intent = this.getIntent();
        //Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("phoneNo", phoneNo);
        intent.putExtra("email", email);
        //startActivity(intent);
        this.setResult(RESULT_OK, intent);
        finish();
    }
}
