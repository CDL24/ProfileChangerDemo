package com.example.climbachiya.profilechangerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by C.limbachiya on 6/15/2016.
 */
public class CustomBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "CustomBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, "WE ARE INSIDE!!!!!!!!!!!");
        TelephonyManager telephony = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        CustomPhoneStateListener customPhoneListener = new CustomPhoneStateListener(context);

        telephony.listen(customPhoneListener, PhoneStateListener.LISTEN_CALL_STATE);


        Bundle bundle = intent.getExtras();
        String phoneNr= bundle.getString("incoming_number");
        Log.v(TAG, "phoneNr: "+phoneNr);

    }
}
