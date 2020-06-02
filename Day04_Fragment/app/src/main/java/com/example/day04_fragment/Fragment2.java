package com.example.day04_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    private EditText edtNumber1, edtNumber2;
    private TextView txtResult;
    private Button btnAdd;
    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        edtNumber1 = getActivity().findViewById(R.id.edtNumber1);
        edtNumber2 = getActivity().findViewById(R.id.edtNumber2);
        txtResult = getActivity().findViewById(R.id.txtResult);
        btnAdd = getActivity().findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(edtNumber1.getText().toString());
                int num2= Integer.parseInt(edtNumber2.getText().toString());
                int result = num1 + num2;
                txtResult.setText("Result = " + result);
            }
        });


    }

}
