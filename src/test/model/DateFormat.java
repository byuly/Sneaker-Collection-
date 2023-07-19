package model;

public class DateFormat {
    private int month;
    private int day;
    private int year;

    public DateFormat(){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String dateToString(){
        return Integer.toString(year)+"/"+ Integer.toString(month)+"/"+ Integer.toString(day);
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setDay(int day){
        this.day = day;
    }

}