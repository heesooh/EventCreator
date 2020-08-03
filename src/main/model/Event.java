package model;

public class Event {
    private String task;
    private Time time;
    private Date date;

    public Event(String task, Time time, Date date) {
        this.task = task;
        this.time = time;
        this.date = date;
    }

    //Effect returns String task
    public String gettask() {
        return task;
    }

    //Effect returns time and minute in String. If the int value's length is 1, 0 is added at the front
    public String gettime() {
        String hour = Integer.toString(time.getHour());
        String minute = Integer.toString(time.getMinute());
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        return hour + ":" + minute + " " + time.getAmpm();
    }

    //Effect returns Month Date and Day in String
    public String getdate() {
        return date.getMonth() + " " + date.getDate() + " " + date.getDay();
    }

    //Effect returns all values in String
    public String getAll() {
        return "Name: " + task + " " + "Date: " + getdate() + " " + "Time: " + gettime();
    }

    //Requires String
    //Modifies this
    //Effect changes the task name
    public void settask(String name) {
        this.task = name;
    }

}
