package task4_v2;

public class Vehicle {
    private int id;
    private String brand;
    private String createdDate;
    private int cost;
    private int litersPerOneHundredKm;
    private int maxSpeed;

    public Vehicle(int id, String brand, String createdDate, int cost, int litersPerOneHundredKm, int maxSpeed) {
        this.id = id;
        this.brand = brand;
        this.createdDate = createdDate;
        this.cost = cost;
        this.litersPerOneHundredKm = litersPerOneHundredKm;
        this.maxSpeed = maxSpeed;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public int getCost() {
        return cost;
    }

    public int getLitersPerOneHundredKm() {
        return litersPerOneHundredKm;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setLitersPerOneHundredKm(int litersPerOneHundredKm) {
        this.litersPerOneHundredKm = litersPerOneHundredKm;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return id + ". brand=" + brand + ", createdDate=" + createdDate + ", cost=" + cost
                + ", litersPerOneHundredKm=" + litersPerOneHundredKm + ", maxSpeed=" + maxSpeed;
    }
}
