package entities;

import java.util.Date;

public class HourContract {
    private Date date;
    private Integer hour;
    private Double valuePerHour;

    public HourContract() {
    }

    public HourContract(Date date, double valuePerHour, int hour) {
        this.date = date;
        this.hour = hour;
        this.valuePerHour = valuePerHour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Double totalValue (){
        return valuePerHour * hour;
    }

}
