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

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

}