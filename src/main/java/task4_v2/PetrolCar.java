package task4_v2;

public class PetrolCar extends Car{

    private String petrolType;

    private String engineCapacity;

    public PetrolCar(int id, String brand, String createdDate, int cost, int litersPerOneHundredKm, int maxSpeed,
                     boolean isTrailer, String petrolType, String engineCapacity) {
        super(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed, isTrailer);
        this.petrolType = petrolType;
        this.engineCapacity = engineCapacity;
    }

    public String getPetrolType() {
        return petrolType;
    }

    public void setPetrolType(String petrolType) {
        this.petrolType = petrolType;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return super.getId() + ". brand=" + super.getBrand() + ", createdDate=" + super.getCreatedDate() +
                ", cost=" + super.getCost() + ", litersPerOneHundredKm=" + super.getLitersPerOneHundredKm() +
                ", maxSpeed=" + super.getMaxSpeed() + ", isTrailer=" + super.isTrailer() +
                ", petrolType=" + petrolType + ", engineCapacity=" + engineCapacity;
    }
}
