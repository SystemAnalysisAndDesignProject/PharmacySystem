package com.psmodel;

import java.util.Calendar;
import javax.swing.JLabel;
 
public class Clock implements Runnable {
 
    JLabel clockLabel;
 
//Constructor takes the clock JLabel
    public Clock(JLabel clockLabel) {
        this.clockLabel = clockLabel;
    }
 
    public void run() {
        while (true) {
            try {
                //Thread sleeps & updates every 1 second, so the clock changes every 1 second.
                clockLabel.setText(getTime());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
 
//Gets the current time.
    public String getTime() {
        Calendar cal = Calendar.getInstance();
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        String time = zero(hours) + ":" + zero(minutes) + ":" + zero(seconds);
        return time;
    }
 
    //Sets the zeroes needed within our hh/mm/ss clock.
    public String zero(int number) {
        String num = (number < 10) ? ("0" + number) : ("" + number);
        return num;
    }
}