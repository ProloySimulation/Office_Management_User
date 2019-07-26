package com.example.proloy.office_management.Activity.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.proloy.office_management.R;

public class ActivityComplain extends AppCompatActivity {

    ImageView ivNewComplain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        ivNewComplain = (ImageView)findViewById(R.id.iv_complain);

        ivNewComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityNewComplain.class));
            }
        });
    }
}
