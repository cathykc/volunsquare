package com.example.cathychen.volunsquare;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by cathychen on 8/20/15.
 */
public class DetailDial extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.hourspopup, null);

        NumberPicker hourPicker = (NumberPicker) v.findViewById(R.id.hoursPick);
        NumberPicker minutePicker = (NumberPicker) v.findViewById(R.id.minutesPick);

        hourPicker.setMaxValue(10);
        hourPicker.setMinValue(0);
        hourPicker.setWrapSelectorWheel(true);

        minutePicker.setMaxValue(59);
        minutePicker.setMinValue(0);
        minutePicker.setWrapSelectorWheel(true);

        VolunteerActivity[] values = (VolunteerActivity[]) getArguments().getSerializable("val");
        int position = (int) getArguments().getInt("position");

        TextView nameDetail = (TextView) v.findViewById(R.id.detailName);
        nameDetail.setText(values[position].name);
        TextView descriptionDetail = (TextView) v.findViewById(R.id.detailDescription);
        descriptionDetail.setText(values[position].description);
        TextView placeDetail = (TextView) v.findViewById(R.id.detailsPlace);
        placeDetail.setText(values[position].place);
        TextView timeDetail = (TextView) v.findViewById(R.id.detailsTime);
        //DateFormat df = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm");
        timeDetail.setText(values[position].stime);


        builder.setView(v)
                // Add action buttons
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // POST NEW HOURS
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // CANCEL
                    }
                });
        return builder.create();
    }

}
