package task4;

public class Automobile {
    private int id;
    private String marka;
    private String createdDate;
    private int cost;
    private int litersPerOneHundredKm;
    private int maxSpeed;

    public int getId() {
        return id;
    }

    public String getMarka() {
        return marka;
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

    public void setMarka(String marka) {
        this.marka = marka;
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

    public Automobile(int id, String marka, String createdDate, int cost, int litersPerOneHundredKm, int maxSpeed) {
        this.id = id;
        this.marka = marka;
        this.createdDate = createdDate;
        this.cost = cost;
        this.litersPerOneHundredKm = litersPerOneHundredKm;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return id + ". marka=" + marka + ", createdDate=" + createdDate + ", cost=" + cost
                + ", litersPerOneHundredKm=" + litersPerOneHundredKm + ", maxSpeed=" + maxSpeed;
    }
}
