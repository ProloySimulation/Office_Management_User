package com.example.proloy.office_management.Activity.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.proloy.office_management.Activity.UI.ActivityComplain;
import com.example.proloy.office_management.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onComplain(View view) {
        startActivity(new Intent(getApplicationContext(), ActivityComplain.class));
    }

    public void onNotice(View view)
    {
        startActivity(new Intent(getApplicationContext(), ActivityNotice.class));
    }
    public void onChat(View view)
    {
        startActivity(new Intent(getApplicationContext(), SplashActivity.class));
    }

    public void onDrive(View view)
    {
        startActivity(new Intent(getApplicationContext(), ActivityDrive.class));
    }

    public void onNumber(View view)
    {
        startActivity(new Intent(getApplicationContext(), ActivityNumber.class));
    }
}
