package com.example.weeklychallenge.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.weeklychallenge.dialog.DialogUtils;
import com.example.weeklychallenge.util.ResourceUtils;
import com.example.weeklychallenge.util.UIUtils;
import com.example.weeklychallenge.MarginActivity;
import com.example.weeklychallenge.R;
import com.example.weeklychallenge.dialog.DialogFactory;

import com.example.weeklychallenge.util.log.LogTag;
import com.example.weeklychallenge.util.log.MainLog;

/** The application's main Activity. */
public class MainActivity extends AppCompatActivity implements //View.OnClickListener,
        MainContract.View {

    /** Holds the reference to Presenter that will control this View. */
    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter(this);
        // Setting the Activity layout.
        //setContentView(R.layout.activity_main);
        // Defining and assigning a click listener for each button.
        //Button firstButton = findViewById(R.id.firstButton);
        //firstButton.setOnClickListener(this);
        //Button secondButton = findViewById(R.id.secondButton);
        //secondButton.setOnClickListener(this);
        //Button thirdButton = findViewById(R.id.thirdButton);
        //thirdButton.setOnClickListener(this);
    }

    /*
    @Override
    public void onClick(final View view) {
        // TODO change hardcoded buttonId values.
        switch (view.getId()) {
            case (R.id.firstButton):
                mPresenter.handleButtonClicked(1);
                break;
            case (R.id.secondButton):
                mPresenter.handleButtonClicked(2);
                break;
            case (R.id.thirdButton):
                mPresenter.handleButtonClicked(3);
                break;
            default:
                mPresenter.handleButtonClicked(0);
                break;
        }
    }
    */

    public void showButtonToast(final View view) {
        Toast.makeText(this, ResourceUtils.getString(R.string.toast_message, this),
                Toast.LENGTH_LONG).show();
    }

    public void showButtonDialog(final View view) {
        final AlertDialog buttonDialog = DialogFactory.createDialog(this,
                DialogUtils.MainActivityDialog.BUTTON_DIALOG);
        //DialogFactory factory = new DialogFactory();
        //factory.show(getSupportFragmentManager(), "");
        DialogFactory.configureOneUIDialog(buttonDialog, this);
        buttonDialog.show();
    }

    public void loadNewScreen(final View view) {
        final Intent intent = new Intent(this, MarginActivity.class);
        final boolean result =
                UIUtils.safeStartActivityForResult(this, intent, UIUtils.DEFAULT_REQUEST_CODE);
        if (result) {
            MainLog.d(LogTag.UI, "New screen correctly loaded.");
        } else {
            MainLog.e(LogTag.UI, "Error loading new screen. Please try again.");
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == UIUtils.DEFAULT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_CANCELED) {
                MainLog.d(LogTag.UI, "MarginActivity finished.");
            } else {
                MainLog.e(LogTag.UI, "An error occurred when finishing MarginActivity.");
            }
        }
    }
}