package com.ccdev.quality;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Coleby.Conner on 7/14/2016.
 */

public class LoginFragment extends Fragment {

    public static final String TAG = "LoginFragment";
    public static final int ERR_DIALOG = -1;

    private FragmentManager mFragmentManager;

    private ImageView mLogoView;
    private EditText mUsernameText, mPasswordText;
    private CheckBox mRememberMeCheck;
    private Button mConfirmButton, mSettingsButton;

    private OnLoginListener mCallback;
    public interface OnLoginListener {
        void onLoginError(int errorCode, ArrayList<String> errorMessage);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnLoginListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnLoginListener");
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeView() {

        mFragmentManager = getFragmentManager();

        mLogoView = (ImageView) getView().findViewById(R.id.login_logo);
        mUsernameText = (EditText) getView().findViewById(R.id.login_username);
        mPasswordText = (EditText) getView().findViewById(R.id.login_password);
        mRememberMeCheck = (CheckBox) getView().findViewById(R.id.login_rememberMe);
        mConfirmButton = (Button) getView().findViewById(R.id.login_confirm);
        mSettingsButton = (Button) getView().findViewById(R.id.login_settings);
    }
}
