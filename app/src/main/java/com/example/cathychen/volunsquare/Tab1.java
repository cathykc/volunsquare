package com.example.cathychen.volunsquare;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.io.InputStream;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;



/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab1 extends Fragment {


    private FragmentActivity myContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


       VolunteerActivity[] values = new VolunteerActivity[1];
       try {
           JSONObject obj = new JSONObject(loadJSONFromAsset());
           JSONArray organizations = obj.getJSONArray("activities");

           values = new VolunteerActivity[organizations.length()];


           for (int i = 0; i < organizations.length(); i++) {
               JSONObject activity = organizations.getJSONObject(i);

               VolunteerActivity newActivity = new VolunteerActivity(activity.getString("organization"), activity.getString("pic"), activity.getString("description"), activity.getString("place"), activity.getString("starttime"), activity.getString("endtime"));
               values[i] = newActivity;

           }

       }
       catch(JSONException e) {
            // do something
       }


       View v = inflater.inflate(R.layout.tab_1, container, false);
        ListView tl = (ListView) v.findViewById(R.id.listview);
       ActivityAdapter adapter = new ActivityAdapter(myContext, values);
       tl.setAdapter(adapter);

       tl.setOnItemClickListener(new OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view,
                                   int position, long id) {
               Log.d("CLICKED", "LALLA");
               DialogFragment dialog = new DetailDial();
                Bundle args = new Bundle();

               VolunteerActivity[] values = new VolunteerActivity[1];
               try {
                   JSONObject obj = new JSONObject(loadJSONFromAsset());
                   JSONArray organizations = obj.getJSONArray("activities");

                   values = new VolunteerActivity[organizations.length()];


                   for (int i = 0; i < organizations.length(); i++) {
                       JSONObject activity = organizations.getJSONObject(i);

                       VolunteerActivity newActivity = new VolunteerActivity(activity.getString("organization"), activity.getString("pic"), activity.getString("description"), activity.getString("place"), activity.getString("starttime"), activity.getString("endtime"));
                       values[i] = newActivity;

                   }

               }
               catch(JSONException e) {
                   // do something
               }

               Log.d("why", Integer.toString(values.length));



               args.putSerializable("val", values);
               args.putInt("position", position);
               dialog.setArguments(args);

               dialog.show(myContext.getSupportFragmentManager(), "hours");


           }
       });


       return v;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getActivity().getAssets().open("dummy.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


}