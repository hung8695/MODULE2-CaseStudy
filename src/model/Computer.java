package model;

public class Computer {
    public static final String NAME="COM";
    public static int mId;
    private String id=NAME+mId;
    private String product;
    private String name;
    private String chip;
    private int ram;
    private String hardDisk;
    private String color;
    private int amount;

    public Computer() {
        mId++;
    }

    public Computer(String product, String name, String chip, int ram, String hardDisk, String color, int amount) {
        this.product = product;
        this.name = name;
        this.chip = chip;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.color = color;
        this.amount=amount;
        mId++;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "Id: " + id +
                ", Product='" + product +
                ", Name='" + name +
                ", Chip='" + chip +
                ", Ram=" + ram +"GB"+
                ", HardDisk='" + hardDisk +
                ", Color='" + color +
                ", Amount=" + amount +
                '}';
    }
}
