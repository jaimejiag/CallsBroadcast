package com.examle.jaime.callsbroadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;

/**
 * Created by usuario on 9/02/18.
 */

public class CallBroadcast extends BroadcastReceiver {
    public static final int CALLNOTIFICATION = 1;


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if (bundle!= null) {
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);

            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                //Recoger el número de teléfono
                String number = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

                Intent newIntent = new Intent(context, CallInformation.class);
                newIntent.putExtra("number", number);
                newIntent.putExtra("idNotification", CALLNOTIFICATION);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, CALLNOTIFICATION,
                        newIntent, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Inventory");
                builder.setContentTitle("CallBroadcast");
                builder.setSmallIcon(android.R.drawable.sym_call_incoming);
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), android.R.drawable.sym_call_incoming));
                builder.setContentIntent(pendingIntent);

                NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(CALLNOTIFICATION, builder.build());
            }
        }
    }
}
