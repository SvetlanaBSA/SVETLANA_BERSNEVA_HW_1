package task4_v2;

public class ElectricCar extends Car{

    private String typeOfBattery;

    private int maxHoursBattery;

    private int maxKmForOneCharge;

    public ElectricCar(int id, String brand, String createdDate, int cost, int litersPerOneHundredKm, int maxSpeed,
                       String typeOfBattery, int maxHoursBattery, int maxKmForOneCharge) {
        super(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed);
        this.typeOfBattery = typeOfBattery;
        this.maxHoursBattery = maxHoursBattery;
        this.maxKmForOneCharge = maxKmForOneCharge;
    }

    public String getTypeOfBattery() {
        return typeOfBattery;
    }

    public void setTypeOfBattery(String typeOfBattery) {
        this.typeOfBattery = typeOfBattery;
    }

    public int getMaxHoursBattery() {
        return maxHoursBattery;
    }

    public void setMaxHoursBattery(int maxHoursBattery) {
        this.maxHoursBattery = maxHoursBattery;
    }

    public int getMaxKmForOneCharge() {
        return maxKmForOneCharge;
    }

    public void setMaxKmForOneCharge(int maxKmForOneCharge) {
        this.maxKmForOneCharge = maxKmForOneCharge;
    }

    @Override
    public String toString() {
        return super.getId() + ". brand=" + super.getBrand() + ", createdDate=" + super.getCreatedDate() +
                ", cost=" + super.getCost() + ", litersPerOneHundredKm=" + super.getLitersPerOneHundredKm() +
                ", maxSpeed=" + super.getMaxSpeed() + ", typeOfBattery=" + typeOfBattery +
                ", maxHoursBattery=" + maxHoursBattery + ", maxKmForOneCharge=" + maxKmForOneCharge;
    }
}
