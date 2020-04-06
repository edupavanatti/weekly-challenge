package com.example.weeklychallenge.util.log;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Defines a proprietary log system for the application. */
public class MainLog {
    private static boolean enabled = true;

    /** Constructor */
    private MainLog() {
    }

    /** Enables the defined log system for the application. */
    public static void setLogEnabled(Context context) {
        Properties logProp = new Properties();
        String configName = "config.properties";
        if (context != null) {
            AssetManager assetManager = context.getAssets();
            if (assetManager != null) {
                try (final InputStream inputStream = assetManager.open(configName)) {
                    logProp.load(inputStream);
                    if (!logProp.getProperty("logEnabled").isEmpty()
                            && logProp.getProperty("logEnabled").equals("1")) {
                        enabled = true;
                        Log.d(LogTag.APPLICATION,
                                "The log for KidsBrowser has been enabled");
                    }
                } catch (IOException e) {
                    if (enabled) {
                        Log.e(LogTag.APPLICATION,
                                "Failed to read property list from input stream", e);
                    }
                } catch (IllegalArgumentException e) {
                    if (enabled) {
                        Log.e(LogTag.APPLICATION,
                                "Failed to read property list from input stream (malformed stream)",
                                e);
                    }
                }
            }
        }
    }

    /**
     * Checks if the application's log is enabled.
     *
     * @return Returns a boolean, true if it is enabled and false otherwise.
     */
    public static boolean getLogEnabled() {
        return enabled;
    }

    /** Defines a type of log. */
    public static void v(final String TAG, final String message) {
        if (enabled) {
            Log.v(TAG, message);
        }
    }

    /** Defines a type of log. */
    public static void d(final String TAG, final String message) {
        if (enabled) {
            Log.d(TAG, message);
        }
    }

    /** Defines a type of log. */
    public static void i(final String TAG, final String message) {
        if (enabled) {
            Log.i(TAG, message);
        }
    }

    /** Defines a type of log. */
    public static void w(final String TAG, final String message) {
        if (enabled) {
            Log.w(TAG, message);
        }
    }

    /** Defines a type of log with an exception. */
    public static void w(final String TAG, final String message, final Exception e) {
        if (enabled) {
            Log.w(TAG, message, e);
        }
    }

    /** Defines a type of log. */
    public static void e(final String TAG, final String message) {
        if (enabled) {
            Log.e(TAG, message);
        }
    }

    /** Defines a type of log with a throwable. */
    public static void e(final String TAG, final String message, final Throwable t) {
        if (enabled) {
            Log.e(TAG, message, t);
        }
    }

    /** Defines a type of log with an exception. */
    public static void e(final String TAG, final String message, final Exception e) {
        if (enabled) {
            Log.e(TAG, message, e);
        }
    }
}
