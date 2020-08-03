package model;

public class Date {

    private int month;
    private int date;
    private String day;

    public Date(int month, int date, String day) {
        this.month = month;
        this.date = date;
        this.day = day;
    }

    //Effect returns int month
    public int getMonth() {
        return month;
    }

    //Effect returns int date
    public int getDate() {
        return date;
    }

    //Effect returns String day
    public String getDay() {
        return day;
    }

    //Requires int
    //Modifies this
    //Effect changes the int month
    public void setMonth(int month) {
        this.month = month;
    }

    //Requires int
    //Modifies this
    //Effect changes the int date
    public void setDate(int date) {
        this.date = date;
    }

    //Requires String
    //Modifies this
    //Effect changes the String day
    public void setDay(String day) {
        this.day = day;
    }
}
