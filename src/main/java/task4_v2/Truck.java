package task4_v2;

public class Truck extends Vehicle{

    private int maxLoadCapacity;

    public Truck(int id, String brand, String createdDate, int cost, int litersPerOneHundredKm, int maxSpeed,
                 int maxLoadCapacity) {
        super(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed);
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    public String toString() {
        return super.getId() + ". brand=" + super.getBrand() + ", createdDate=" + super.getCreatedDate() +
                ", cost=" + super.getCost() + ", litersPerOneHundredKm=" + super.getLitersPerOneHundredKm() +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", maxLoadCapacity=" + maxLoadCapacity;
    }
}
