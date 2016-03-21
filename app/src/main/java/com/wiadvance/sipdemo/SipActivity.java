package com.wiadvance.sipdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;


public class SipActivity extends SingleFragmentActivity {

    private String TAG = "SipActivity";
    private BroadcastReceiver mNotificationReceiver;

    private SIPFragment mSipFragment;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, SipActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {

        String name = UserPreference.getName(getApplicationContext());
        String email = UserPreference.getEmail(getApplicationContext());
        String sipNumber = UserPreference.getSip(getApplicationContext());

        mSipFragment = SIPFragment.newInstance(name, email, sipNumber);
        return mSipFragment;
    }

    @Override
    protected void onStart() {
        super.onStart();

        mNotificationReceiver = new NotificationReceiver();
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);

        IntentFilter notify_filter = new IntentFilter(NotificationUtil.ACTION_NOTIFICATION);
        manager.registerReceiver(mNotificationReceiver, notify_filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mNotificationReceiver != null){
            LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);
            manager.unregisterReceiver(mNotificationReceiver);
        }
    }

    class NotificationReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "NotificationReceiver, onReceive()");
            String message = intent.getStringExtra(NotificationUtil.NOTIFY_MESSAGE);
            Toast.makeText(SipActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
