package com.example.cathychen.volunsquare;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

/**
 * Created by cathychen on 8/19/15.
 */
public class VolunteerActivity implements Serializable {

    public String name;
    public String pic;
    public String description;
    public String place;
    public String stime;
    public String etime;
    public Date starttime;
    public Date endtime;
    public long hours;

    public VolunteerActivity(String name, String pic, String description, String place, String starttime, String endtime) {
        this.name = name;
        this.pic = pic;
        this.description = description;
        this.place = place;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSZ");
        this.stime = starttime;
        this.etime = endtime;

        try {
            this.starttime = format.parse(starttime);
            this.endtime = format.parse(endtime);

            long diff = this.endtime.getTime() - this.starttime.getTime();

            hours = TimeUnit.MILLISECONDS.toHours(diff);


        }
        catch (Exception e) {

        }





    }

}
