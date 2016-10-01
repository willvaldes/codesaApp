package co.com.codesa.codesaapp.fragments.producto;


import android.app.DatePickerDialog;

import android.app.Dialog;

import android.os.Bundle;

import android.support.v4.app.DialogFragment;

import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by jggomezt on 01/10/2016.
 */
public class DatePickerFragment extends DialogFragment

        implements DatePickerDialog.OnDateSetListener {
    private OnDialogDatePickerFragmentListener mListener;

    private int requestCode;

    @Override

    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        if (mListener != null) {

            mListener.onDateSet(year, monthOfYear, dayOfMonth, requestCode);

        }

    }

    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH);

        int day = c.get(Calendar.DAY_OF_MONTH);        // Create a new instance of DatePickerDialog and return it

        return new DatePickerDialog(getActivity(), this, year, month, day);

    }

    public void setCallback(OnDialogDatePickerFragmentListener listener, int requestCode) {

        mListener = listener;

        this.requestCode = requestCode;

    }

    public interface OnDialogDatePickerFragmentListener {

        void onDateSet(int year, int monthOfYear, int dayOfMonth, int requestCode);

    }
}