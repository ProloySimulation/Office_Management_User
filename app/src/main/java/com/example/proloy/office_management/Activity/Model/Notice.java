package com.example.proloy.office_management.Activity.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Proloy on 4/17/2017.
 */
@Table(name = "Notices")
public class Notice extends Model {


    @Column(name = "noticeTitle")
    public String noticeTitle;

    @Column(name = "noticeTime")
    public String noticeTime;

    @Column(name = "noticeDetails")
    public String noticeDetails;



    public Notice() {
    }

    public Notice(String noticeTitle, String noticeTime, String noticeDetails) {
        this.noticeTitle = noticeTitle;
        this.noticeTime = noticeTime;
        this.noticeDetails = noticeDetails;
    }
}

