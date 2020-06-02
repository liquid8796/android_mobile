package com.example.day05_spinner_date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView txtBirthDay;
    private String selectedSpinner;
    private Spinner spNationality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBirthDay = findViewById(R.id.txtBirthday);
        spNationality = findViewById(R.id.spNationality);

        List<String> datasrc = new ArrayList<>();
        datasrc.add("Kinh");
        datasrc.add("Hoa");
        datasrc.add("Rau ma");
        datasrc.add("Dong Lao");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datasrc);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNationality.setAdapter(dataAdapter);
        spNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //selectedSpinner = parent.getItemAtPosition(position).toString();
                selectedSpinner = spNationality.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        int monthOfyear = month + 1;
        String result = dayOfMonth + "-" + monthOfyear + "-" + year;
        txtBirthDay.setText(result);
    }

    public void clickToGetDate(View view) {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "DatePicker");
    }

    public void clickToRegister(View view) {
        Intent intent = new Intent(this, ShowActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("birthday", txtBirthDay.getText().toString());
        bundle.putString("nationality", selectedSpinner);
        intent.putExtra("INFO", bundle);
        startActivity(intent);
    }
}

