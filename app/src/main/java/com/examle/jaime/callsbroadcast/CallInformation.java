package com.examle.jaime.callsbroadcast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CallInformation extends AppCompatActivity {
    private TextView txvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_information);

        txvNumber = findViewById(R.id.txv_number);

        if (getIntent().getExtras() != null) {
            txvNumber.setText(getIntent().getStringExtra("number"));
        }
    }
}
