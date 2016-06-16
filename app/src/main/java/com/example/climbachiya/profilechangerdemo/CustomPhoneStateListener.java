package com.example.climbachiya.profilechangerdemo;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by C.limbachiya on 6/15/2016.
 */
public class CustomPhoneStateListener extends PhoneStateListener {

    private static final String TAG = "CustomPhoneStateListener";
    private Context mContext;
    public CustomPhoneStateListener(Context context) {
        mContext = context;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        //super.onCallStateChanged(state, incomingNumber);

        Toast.makeText(mContext, "onCallStateChanged : incomingNumber :"+incomingNumber, Toast.LENGTH_SHORT).show();
        Log.v(TAG, "WE ARE INSIDE!!!!!!!!!!!");
        Log.v(TAG, incomingNumber);

        switch (state) {
            case TelephonyManager.CALL_STATE_RINGING:
                Log.d(TAG, "RINGING");
                AudioManager audio = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
                //int currentVolume = audio.getStreamVolume(AudioManager.STREAM_RING);
                int max = audio.getStreamMaxVolume(AudioManager.STREAM_RING);
                audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                audio.setStreamVolume(AudioManager.STREAM_RING, max, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                Log.d(TAG, "IDLE");
                AudioManager audioVibrate = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
                //int currentVolumeVibrate = audioVibrate.getStreamVolume(AudioManager.STREAM_RING);
                int maxVibrate = audioVibrate.getStreamMaxVolume(AudioManager.STREAM_RING);
                audioVibrate.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                audioVibrate.setStreamVolume(AudioManager.STREAM_RING, maxVibrate-maxVibrate, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.d(TAG, "OFFHOOK");
                break;
        }
    }

    /*public void onCallStateChanged(int state, String incomingNumber) {

        Log.v(TAG, "WE ARE INSIDE!!!!!!!!!!!");
        Log.v(TAG, incomingNumber);

        switch (state) {
            case TelephonyManager.CALL_STATE_RINGING:
                Log.d(TAG, "RINGING");
                break;
        }
    }*/
}
