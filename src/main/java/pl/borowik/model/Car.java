package pl.borowik.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "producer")
    private String producer;

    @NotNull
    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "daily_cost")
    private double dailyCost;

    @NotNull
    @Column(name = "rented")
    private Boolean rented;

    public Car(){

    }

    public Car(int carId, String type, String producer, String model, double dailyCost, Boolean rented) {
        this.carId= carId;
        this.type = type;
        this.producer = producer;
        this.model = model;
        this.dailyCost=dailyCost;
        this.rented = rented;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", dailyCost=" + dailyCost +
                ", isCarRented=" + rented +
                '}';
    }
}
