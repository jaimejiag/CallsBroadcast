package com.examle.jaime.callsbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by usuario on 9/02/18.
 */

public class CallBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Message", "Se ha recogido el Intent");
    }
}
