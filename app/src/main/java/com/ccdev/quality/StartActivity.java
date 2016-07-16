package com.ccdev.quality;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity implements
        LoginFragment.OnLoginListener {

    private static final String TAG = "StartActivity";

    private FragmentManager mFragmentManager;
    private Fragment mLoginFragment;
    private Fragment mSettingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initializeView();
        determineLandingPage();
    }

    private void initializeView() {

        mFragmentManager = getSupportFragmentManager();

        mLoginFragment = new LoginFragment();
    }

    private void determineLandingPage() {

        // TODO check for prefs

        mFragmentManager
                .beginTransaction()
                .replace(R.id.start_content, mLoginFragment)
                .commit();
    }

    @Override
    public void onLoginError(int errorCode, ArrayList<String> errorMessage) {
        for (int i = 0; i < errorMessage.size(); i++) {
            Log.e(TAG, errorMessage.get(i));
        }
        Log.e(TAG, TAG + ".onLoginError(" + errorCode + ")");
    }
}
