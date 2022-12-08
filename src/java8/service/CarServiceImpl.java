package java8.service;

import java8.classes.Car;
import java8.classes.Person;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    ArrayList<Car> cars = new ArrayList<>();

    @Override
    public String createCar(List<Car> cars) {
        this.cars.add((Car) cars);
        return "Cars list was created successfully";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public ArrayList<Car> findByName(String name, List<Car> cars) {
        ArrayList<Car> list = new ArrayList<>();
        for (Car car : cars) {
            if (car.getName().equals(name)){
                list.add(car);
            }

        }
        return list;
    }

    @Override
    public List<Car> findByCountry(String name, List<Person> persons) {
        ArrayList<Car> list = new ArrayList<>();
        for (Car car : cars) {
            if(car.getCountryOfOrigin().name().equals(name)){
                list.add(car);
            }

        }
        return list;
    }
}
