package com.example.weeklychallenge.mainscreen;

import com.example.weeklychallenge.util.ButtonUtils;
import com.example.weeklychallenge.util.log.LogTag;
import com.example.weeklychallenge.util.log.MainLog;

/** This specifies the Presenter for MainActivity. */
class MainPresenter implements MainContract.Presenter {

    /** Holds the reference to the Activity that will be controlled by this presenter. */
    private MainContract.View mView;

    /** Constructor. */
    MainPresenter(final MainContract.View view) {
        mView = view;
    }

    /*
    @Override
    public void handleButtonClicked(final int buttonId) {
        final ButtonUtils.MainActivityButton mainActivityButton =
                ButtonUtils.MainActivityButton.forCode(buttonId);

        switch (mainActivityButton) {
            case FIRST_BUTTON:
                mView.showButtonToast();
                break;
            case SECOND_BUTTON:
                mView.showButtonDialog();
                break;
            case THIRD_BUTTON:
                mView.loadNewScreen();
                break;
            case INVALID_BUTTON:
            default:
                MainLog.e(LogTag.UI, "Error processing 'handleButtonClicked." +
                        " 'buttonId' is invalid: " + buttonId);
                break;
        }
    }
    */
}
