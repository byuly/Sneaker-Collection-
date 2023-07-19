package model;

public class DateForSneaker {
    private int month;
    private int day;
    private int year;

    public DateForSneaker() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    public String dateToString() {
        return Integer.toString(year) + "/" + Integer.toString(month) + "/" + Integer.toString(day);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

}