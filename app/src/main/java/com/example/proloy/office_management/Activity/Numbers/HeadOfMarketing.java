package com.example.proloy.office_management.Activity.Numbers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.proloy.office_management.R;

/**
 * Created by Proloy on 5/7/2017.
 */
public class HeadOfMarketing extends AppCompatActivity {

    ImageButton call ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing);

        call = (ImageButton)findViewById(R.id.img_Call_plumber);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialContactPhone1("01987982903");
            }
        });
    }


    private void dialContactPhone1(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));

    }

}
