package task4_v2;

public class Car extends Vehicle{

    private boolean isTrailer;

    public Car(int id, String brand, String createdDate, int cost, int litersPerOneHundredKm,
               int maxSpeed, boolean isTrailer) {
        super(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed);
        this.isTrailer = isTrailer;
    }

    public boolean isTrailer() {
        return isTrailer;
    }

    public void setTrailer(boolean trailer) {
        isTrailer = trailer;
    }

    @Override
    public String toString() {
        return super.getId() + ". brand=" + super.getBrand() + ", createdDate=" + super.getCreatedDate() +
                ", cost=" + super.getCost() + ", litersPerOneHundredKm=" + super.getLitersPerOneHundredKm() +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", isTrailer=" + isTrailer;
    }
}
