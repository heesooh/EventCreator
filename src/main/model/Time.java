package model;

public class Time {

    private int hour;
    private int minute;
    private String ampm;

    public Time(int hour, int minute, String ampm) {
        this.hour = hour;
        this.minute = minute;
        this.ampm = ampm;
    }

    //Effect returns int hour
    public int getHour() {
        return hour;
    }

    //Effect returns int minute
    public int getMinute() {
        return minute;
    }

    //Effect returns String ampm
    public String getAmpm() {
        return ampm;
    }

    //Requires int
    //Modifies this
    //Effect changes the int hour value
    public void setHour(int hour) {
        this.hour = hour;
    }

    //Requires int
    //Modifies this
    //Effect changes the int minute value
    public void setMinute(int minute) {
        this.minute = minute;
    }

    //Requires String
    //Modifies this
    //Effect changes the String ampm value
    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

}
