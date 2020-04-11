package com.example.weeklychallenge.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.Window;

import androidx.core.content.ContextCompat;

import com.example.weeklychallenge.R;
import com.example.weeklychallenge.util.ResourceUtils;
import com.example.weeklychallenge.util.log.LogTag;
import com.example.weeklychallenge.util.log.MainLog;

/**
 * Factory used to create Dialogs for the application.
 */
public class DialogFactory {

    /**
     * Method that builds an application Dialog.
     *
     * @param context The Context that will be used to create the Dialog.
     *
     * @return Returns a Dialog created or null in case of error.
     */
    public static AlertDialog createDialog(final Context context,
                                           final DialogUtils.MainActivityDialog dialogType) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        final DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                dialog.dismiss();
            }
        };
        dialog.setCancelable(false);

        // TODO transfer this check to a helper method.
        if (dialogType == DialogUtils.MainActivityDialog.BUTTON_DIALOG) {
                dialog.setTitle(ResourceUtils.getString(R.string.dialog_title, context));
                dialog.setMessage(ResourceUtils.getString(R.string.dialog_message, context));
                dialog.setPositiveButton(ResourceUtils.getString(R.string.dialog_positive_button,
                        context), listener);
                dialog.setNegativeButton(ResourceUtils.getString(R.string.dialog_negative_button,
                        context), listener);
        } else {
            MainLog.e(LogTag.UI, "Could not set dialog information. 'dialogType' is invalid: "
            + dialogType);
        }

        return dialog.create();
    }

    /**
     * Method to configure a Dialog following the One UI standards.
     *
     * @param dialog The Dialog which will be configured.
     * @param context The Context that will be used to configure the Dialog.
     */
    public static void configureOneUIDialog(final AlertDialog dialog, final Context context) {
        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            dialogWindow.setBackgroundDrawable(ResourceUtils.getDrawable(R.drawable.dialog_background,
                    context.getTheme(), context));
            dialogWindow.setGravity(Gravity.BOTTOM);
        } else {
            MainLog.e(LogTag.UI, "Failed to set gravity. Window is null.");
        }
    }
}
