package model;

import java.time.LocalDateTime;
import java.util.Date;

public class History {
    private String date;
    private String name;
    private String status;
    private String infomation;

    public History(){

    }

    public History(String date, String name, String status, String infomation) {
        this.date = date;
        this.name = name;
        this.status = status;
        this.infomation = infomation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation;
    }

    @Override
    public String toString() {
        return
                "Date: " + date +
                ", Name: " + name +
                ", Status: " + status +
                ", Infomation: " + infomation +
                '}';
    }
}
