package com.example.weeklychallenge.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;

import com.example.weeklychallenge.util.log.LogTag;

/** Utility class for common UI operations. */
public class UIUtils {

    /** Minimum request code for starting a new Activity. */
    private static final int MINIMUM_REQUEST_CODE = 0;

    /** Default request code for starting a new Activity. */
    public static final int DEFAULT_REQUEST_CODE = 1;

    /**
     * Utility method used to start activity for result.
     *
     * @param activity    The current activity.
     * @param intent      The current intent.
     * @param requestCode The request code to be used.
     */
    public static boolean safeStartActivityForResult(final Activity activity, final Intent intent,
                                                  final int requestCode) {
        boolean result = false;
        if (activity == null) {
            android.util.Log.e(LogTag.UI, "Could not start Activity for result from null Activity.");
        } else if (intent == null) {
            android.util.Log.e(LogTag.UI, "Could not start Activity for result with null Intent.");
        } else if (requestCode < MINIMUM_REQUEST_CODE) {
            android.util.Log.e(LogTag.UI, "Could not start Activity for result with invalid" +
                    " request code: " + requestCode);
        } else {
            try {
                activity.startActivityForResult(intent, requestCode);
                result = true;
            } catch (final ActivityNotFoundException exception) {
                android.util.Log.e(LogTag.UI, "Could not start Activity for result.", exception);
            }
        }
        return result;
    }
}
