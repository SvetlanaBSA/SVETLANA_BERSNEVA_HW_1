package task4_v2;

public class PetrolCar extends Car{

    private String petrolType;

    private String engineCapacity;

    public PetrolCar(int id, String brand, String createdDate, int cost, int litersPerOneHundredKm,
                     int maxSpeed, String petrolType, String engineCapacity) {
        super(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed);
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
        return ", petrolType=" + petrolType + ", engineCapacity=" + engineCapacity;
    }
}
