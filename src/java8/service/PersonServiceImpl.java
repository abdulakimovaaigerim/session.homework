package java8.service;

import java8.classes.Car;
import java8.classes.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {

    private final List<Person> people = new ArrayList<>();

    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "Person  list was created successfully: ";
    }
    @Override
    public String removePerson(String name, List<Person> people) {
        String name1 = new Scanner(System.in).nextLine();
            for (Person p : people) {
                if (p.getName().equals(name1)){
                    people.remove(p);
                }
            }
        return "Name deleted!! ";
    }
    @Override
    public List<Person> getAll()   {
        return this.people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        ArrayList<Person> perList = new ArrayList<>();
        for (Person person : people) {
            if(person.getName().equals(name)){
                perList.add(person);
            }
        }
        return perList;
    }
    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
       ArrayList<Person> perCarList = new ArrayList<>();
       for (Person person:people){
           for (Car car: person.getCars()){
               if(car.getName().equals(name)){
                   perCarList.add(person);
               }
           }
        }
        return perCarList;
    }
    @Override
    public String payCars(String name, List<Person> person, String carName, List<Car> cars) {
        for (Person person1 : person) {
            if(person1.getName().equals(name)){
                for (Car car : cars) {
                    if(car.getName().equals(name)){
                        if (person1.getMoney().intValue() >= car.getPrice().intValue()){
                            ArrayList<Car> list = new ArrayList<>(person1.getCars());
                            list.add(car);
                            person1.setCars(list);
                        }
                    }
                }
            }
        }
        return "The car was sold! ";
    }
    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> persons) {
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
            }
        });
        return persons;
    }
    @Override
    public List<Person> sortPersonName(List<Person> persons) {
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return persons;
    }
    @Override
    public List<Person> sortGender(List<Person> person) {
        person.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getGender().compareTo(o1.getGender());
            }
        });
        return person;
    }

    @Override
    public int getAge(String name, List<Person> people) {
        for (Person person1 : people) {
            if(person1.getName().equals(name)){
                System.out.println(person1.getName()+ "age: ");
                return Period.between(person1.getDateOfBirth(), LocalDate.now()).getYears();
            }
        }
        return 0;
    }
}