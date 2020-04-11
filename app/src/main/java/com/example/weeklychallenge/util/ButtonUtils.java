package com.example.weeklychallenge.util;

import com.example.weeklychallenge.R;

/**
 * Utility class for common Button operations.
 */
public class ButtonUtils {

    /**
     * The ID related to an invalid button.
     */
    private static final int INVALID_BUTTON_ID = 0;

    /**
     * The ID related to the first button.
     */
    private static final int FIRST_BUTTON_ID = 1;

    /**
     * The ID related to the second button.
     */
    private static final int SECOND_BUTTON_ID = 2;

    /**
     * The ID related to the third button.
     */
    private static final int THIRD_BUTTON_ID = 3;

    /**
     * Enum containing each button used by the MainActivity.
     */
    public enum MainActivityButton {
        INVALID_BUTTON(INVALID_BUTTON_ID),
        FIRST_BUTTON(FIRST_BUTTON_ID),
        SECOND_BUTTON(SECOND_BUTTON_ID),
        THIRD_BUTTON(THIRD_BUTTON_ID);
        private final int mID;

        MainActivityButton(final int id) {
            mID = id;
        }

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
