package web.model;

public class Car {
    private String carModel;
    private String carColor;
    private int carRun;

    public Car(){

    }
    public Car(String carModel, String carColor, int carRun) {
        this.carModel = carModel;
        this.carColor = carColor;
        this.carRun = carRun;  //пробег
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getCarRun() {
        return carRun;
    }

    public void setCarRun(int carRun) {
        this.carRun = carRun;
    }

    @Override
    public String toString() {
        return String.format("Car model = %s; color = %s; run = %d ages", getCarModel(),
            getCarColor(), getCarRun());
    }
}
