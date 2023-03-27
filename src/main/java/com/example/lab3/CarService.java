package com.example.lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final ObjectOutputStream objectOutputStream;
    private List<Car> cars;

    public CarService(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            cars = (ArrayList<Car>) objectInputStream.readObject();
        } catch (Exception e) {
            if (!(e instanceof EOFException)) {
                throw new RuntimeException(e);
            }
            cars = new ArrayList<>();
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    synchronized public void addCar(Car car) {
        cars.add(car);
    }

    public void saveCars() {
        try {
            objectOutputStream.writeObject(cars);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
