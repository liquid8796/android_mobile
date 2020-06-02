package com.example.day04_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtNumber1, edtNumber2;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        txtResult = findViewById(R.id.txtResult);
    }

    public void clickToSub(View view) {
        int num1 = Integer.parseInt(edtNumber1.getText().toString());
        int num2= Integer.parseInt(edtNumber2.getText().toString());
        int result = num1 - num2;
        txtResult.setText("Result = " + result);
    }
}
