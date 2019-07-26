package com.example.proloy.office_management.Activity.UI;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.proloy.office_management.Activity.Fragment.LoginFragment;
import com.example.proloy.office_management.R;


/**
 * Created by Proloy on 5/4/2017.
 */



public class ActivityChatLogin extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void startIntent(Context context) {
        Intent intent = new Intent(context, ActivityChatLogin.class);
        context.startActivity(intent);
    }

    public static void startIntent(Context context, int flags) {
        Intent intent = new Intent(context, ActivityChatLogin.class);
        intent.setFlags(flags);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_login);
        bindViews();
        init();
    }

    private void bindViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init() {
        // set the toolbar
//        setSupportActionBar(mToolbar);

        // set the login screen fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_login,
                LoginFragment.newInstance(),
                LoginFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
