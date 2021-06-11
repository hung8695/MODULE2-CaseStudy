package model;

public class Computer {
    private String production;
    private String name;
    private String code;
    private String date;
    private int price;

    public Computer(){}

    public Computer(String production, String name, String code, String date, int price) {
        this.production = production;
        this.name = name;
        this.code = code;
        this.date = date;
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Production: " + production +
                ", Name: " + name +
                ", Code: " + code +
                ", Date: " + date +
                ", Price: " + price +
                " }";
    }
}
