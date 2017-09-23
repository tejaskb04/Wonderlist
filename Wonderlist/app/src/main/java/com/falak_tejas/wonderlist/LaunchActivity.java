package com.falak_tejas.wonderlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends AppCompatActivity {

    private Button registerBtn;
    private Button dashboardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        registerBtn = (Button) findViewById(R.id.register);
        dashboardBtn = (Button) findViewById(R.id.dashboard);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchActivity.this, RegisterActivity.class));
            }
        });
        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement "Check if User is Logged in" Logic
                startActivity(new Intent(LaunchActivity.this, DashboardActivity.class));
            }
        });
    }
}
