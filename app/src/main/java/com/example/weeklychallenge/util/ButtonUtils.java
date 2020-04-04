package com.example.weeklychallenge.util;

import androidx.annotation.NonNull;

import com.example.weeklychallenge.R;

/**
 * Utility class for common Button operations.
 */
public class ButtonUtils {

    /**
     *
     */
    private static final int INVALID_BUTTON_ID = 0;

    /**
     *
     */
    private static final int FIRST_BUTTON_ID = R.id.firstButton;

    /**
     *
     */
    private static final int SECOND_BUTTON_ID = R.id.secondButton;

    /**
     *
     */
    private static final int THIRD_BUTTON_ID = R.id.thirdButton;

    public enum MainActivityButton {
        INVALID_BUTTON(INVALID_BUTTON_ID),
        FIRST_BUTTON(FIRST_BUTTON_ID),
        SECOND_BUTTON(SECOND_BUTTON_ID),
        THIRD_BUTTON(THIRD_BUTTON_ID);
        private final int mID;

        MainActivityButton(final int id) {
            mID = id;
        }

        @NonNull
        public static MainActivityButton forCode(final int code) {
            for (final MainActivityButton mainActivityButton : MainActivityButton.values()) {
                if (mainActivityButton.mID == code) {
                    return mainActivityButton;
                }
            }
            return INVALID_BUTTON;
        }
    }
}
