package com.example.proloy.office_management.Activity.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.proloy.office_management.Activity.Fragment.RegisterFragment;
import com.example.proloy.office_management.R;

//  import com.delaroystudios.firebasechat.R;
//  import com.delaroystudios.firebasechat.ui.fragments.RegisterFragment;

/**
 * Created by Proloy on 5/4/2017.
 */



public class ActivityRegister extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ActivityRegister.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindViews();
        init();
    }

    private void bindViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init() {
        // set the toolbar
//        setSupportActionBar(mToolbar);

        // set the register screen fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_register,
                RegisterFragment.newInstance(),
                RegisterFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
