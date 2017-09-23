package com.falak_tejas.wonderlist;

/**
 * Created by Falak on 9/23/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    private TextView profile;
    private TextView account;
    private TextView notifications;
    private TextView permissionDataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        profile = (TextView) findViewById(R.id.profile);
        account = (TextView) findViewById(R.id.account);
        notifications = (TextView) findViewById(R.id.notifications);
        permissionDataStorage = (TextView) findViewById(R.id.permissions_data_storage);
        profile.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_person_black_24dp, 0, 0, 0);
        account.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_account_circle_black_24dp, 0,
                0, 0);
        notifications.setCompoundDrawablesWithIntrinsicBounds(R.drawable
                .ic_notifications_black_24dp, 0, 0, 0);
        permissionDataStorage.setCompoundDrawablesWithIntrinsicBounds(R.drawable
                .ic_perm_data_setting_black_24dp, 0, 0, 0);
    }
}
