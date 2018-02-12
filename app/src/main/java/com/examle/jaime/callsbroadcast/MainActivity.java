package com.examle.jaime.callsbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendIntent();
    }


    public void sendIntent() {
        Intent intent = new Intent("com.examle.jaime.callsbroadcast.intent");
        Bundle bundle = new Bundle();
        bundle.putString(TelephonyManager.EXTRA_STATE, "RINGING");
        bundle.putString(TelephonyManager.EXTRA_INCOMING_NUMBER, "634578493");
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }
}
