package com.ccdev.quality;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Coleby.Conner on 7/14/2016.
 */

public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final int RESULT_OK_WITH_INPUT = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_CANCEL = -1;

    public static final int ARGS_TITLE = 0;
    public static final int ARGS_PROMPT = 1;
    public static final int ARGS_INPUT = 2;
    public static final int ARGS_CONFIRM = 3;
    public static final int ARGS_CANCEL = 4;


    private TextView mTitleText, mPromptText;
    private EditText mInputText;
    private Button mConfirmButton, mCancelButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_confirm:
                Intent i = new Intent();
                i.putExtra("input", mInputText.getText().toString());
                getTargetFragment().onActivityResult(
                        getTargetRequestCode(), 0, i);
                break;
            case R.id.dialog_cancel:
                break;
        }
    }

    private void initializeView() {

        mTitleText = (TextView) getView().findViewById(R.id.dialog_title);
        mPromptText = (TextView) getView().findViewById(R.id.dialog_prompt);
        mInputText = (EditText) getView().findViewById(R.id.dialog_input);
        mConfirmButton = (Button) getView().findViewById(R.id.dialog_confirm);
        mCancelButton = (Button) getView().findViewById(R.id.dialog_cancel);

        mConfirmButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);

        Bundle args = getArguments();

        

        mTitleText.setText("test title");
        mPromptText.setText("prompt text");
        mInputText.setVisibility(View.GONE);
        mCancelButton.setVisibility(View.INVISIBLE);
    }
}
