package com.example.proloy.office_management.Activity.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.activeandroid.query.Select;
import com.example.proloy.office_management.Activity.Model.Notice;
import com.example.proloy.office_management.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Proloy on 4/17/2017.
 */
public class ActivityNotice extends AppCompatActivity{

    private List<Notice> notices = new ArrayList<Notice>();
    private static final String TAG = "ActivityNotice";
    RecyclerView recyclerView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void addNotice() {

        // AA get all data from db
        List<Notice> noticesList = new Select().from(Notice.class).execute();
        notices.addAll(noticesList);
    }

}
