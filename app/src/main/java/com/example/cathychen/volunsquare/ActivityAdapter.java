package com.example.cathychen.volunsquare;

import android.content.Context;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Objects;
import android.util.Log;

public class ActivityAdapter extends ArrayAdapter<VolunteerActivity> {
    private final Context context;
    private final VolunteerActivity[] values;

    public ActivityAdapter(Context context, VolunteerActivity[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);
        TextView nameView = (TextView) rowView.findViewById(R.id.orgname);
        TextView placeView = (TextView) rowView.findViewById(R.id.place);
        RoundedImageView picView = (RoundedImageView) rowView.findViewById(R.id.orgpic);

        nameView.setText(values[position].name);
        placeView.setText(values[position].place);
        Log.d("PIC", values[position].pic);
        Log.d("IDENTIFY", Integer.toString(context.getResources().getIdentifier(values[position].pic, "drawable", context.getPackageName())));

        switch(values[position].pic) {
            case "arc.png":
                picView.setImageResource(R.drawable.arc);
                break;
            case "bank.png":
                picView.setImageResource(R.drawable.bank);
                break;
            case "food.png":
                picView.setImageResource(R.drawable.food);
                break;
            case "proj.png":
                picView.setImageResource(R.drawable.proj);
                break;
            case "gate.png":
                picView.setImageResource(R.drawable.gate);
                break;
            case "safe.png":
                picView.setImageResource(R.drawable.tsafe);
                break;
            default:
                picView.setImageResource(R.drawable.logo);

        }




        return rowView;
    }
}