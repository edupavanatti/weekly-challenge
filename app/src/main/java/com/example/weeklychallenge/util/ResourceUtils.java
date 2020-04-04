package com.example.weeklychallenge.util;

import android.content.Context;
import android.content.res.Resources;

import com.example.weeklychallenge.util.log.LogTag;
import com.example.weeklychallenge.util.log.MainLog;

/**
 * Utility class to get resources (dimensions, animations, drawables, etc) from '/res/' folder.
 */
public final class ResourceUtils {

    /**
     * Gets a specific string value from resources ('/res' folder).
     *
     * @param stringId the ID of the desired string value.
     * @param context the {@link Context} instance.
     * @return the desired string value or null if string does not exist.
     */
    public static String getString(final int stringId, final Context context) {
        String result = null;

        if (null != context) {
            final Resources resources = context.getResources();

            if (null != resources) {
                try {
                    result = resources.getString(stringId);
                } catch (final Resources.NotFoundException nfe) {
                    MainLog.e(LogTag.EXCEPTION,
                            "Error getting string from resources. String ID: " + stringId,
                            nfe);
                }
            } else {
                MainLog.e(LogTag.RESOURCES,
                        "Error getting string from resources. Resources instance is null. " +
                                "String ID: " + stringId);
            }
        } else {
            MainLog.e(LogTag.RESOURCES,
                    "Error getting string from resources. Context instance is null. String " +
                            "ID: " + stringId);
        }

        return result;
    }
}