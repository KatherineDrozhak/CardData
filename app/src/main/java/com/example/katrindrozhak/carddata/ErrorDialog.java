package com.example.katrindrozhak.carddata;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;


public class ErrorDialog extends DialogFragment {
    private ErrorDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle(R.string.error_title).setMessage(R.string.error_message)
                .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        dismiss();
                        if (listener != null) {
                            listener.okPressed();
                        }
                    }
                });

        return dialogBuilder.create();
    }

    public void setListener(ErrorDialogListener listener) {
        this.listener = listener;
    }
}
