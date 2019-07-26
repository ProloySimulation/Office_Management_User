package com.example.proloy.office_management.Activity;

import android.app.Application;

/**
 * Created by Proloy on 5/4/2017.
 */
public class FireBaseChatApp extends Application {
    private static boolean sIsChatActivityOpen = false;

    public static boolean isChatActivityOpen() {
        return sIsChatActivityOpen;
    }

    public static void setChatActivityOpen(boolean isChatActivityOpen) {
        FireBaseChatApp.sIsChatActivityOpen = isChatActivityOpen;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
