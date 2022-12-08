import java8.classes.Car;
import java8.classes.Person;
import java8.enums.Colour;
import java8.enums.Country;
import java8.enums.Gender;
import java8.service.CarServiceImpl;
import java8.service.PersonServiceImpl;
import org.ietf.jgss.GSSContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Tayota", "camry", new BigDecimal(900000),
                Year.of(2002), Colour.WHITE, Country.TURKEY));
        cars.add(new Car("BMW", "X7", new BigDecimal(700000),
                Year.of(2004), Colour.BLACK, Country.GERMANY));
        cars.add(new Car("Honda", "accord", new BigDecimal(500000),
                Year.of(2000), Colour.GREEN, Country.KYRGYZSTAN));


        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Kanykei", LocalDate.of(2006, 3, 19),
                Gender.F, new BigDecimal(700000), "+996708541398", cars));
        people.add(new Person("Aigerim", LocalDate.of(2005, 6, 21),
                Gender.F, new BigDecimal(9000000), "+996700875997", cars));
        people.add(new Person("Altynbek", LocalDate.of(2004, 5, 13),
                Gender.M, new BigDecimal(5000000), "+996221348657", cars));

        Scanner scanner = new Scanner(System.in);

        PersonServiceImpl personService = new PersonServiceImpl();

        CarServiceImpl carService = new CarServiceImpl();

        System.out.println("Whichever method you choose:");
        System.out.println("""
                    1 -> PersonServiceImpl,
                    2 -> CarServiceImpl,
                    """);

        int number = scanner.nextInt();
        if (number == 1) {
            System.out.println("""
                    1 -> createPerson,
                    2 -> removePerson,
                    3 -> getAll,
                    4 -> findByName,
                    5 -> findByCarName,
                    6 -> payCars,
                    7 -> sortPersonDateOfBirth,
                    8 -> sortPersonName,
                    9 -> sortGender,
                    10 -> getAge
                    11 -> Break;
                     """);

            while (true) {
                int i = new Scanner(System.in).nextInt();
                switch (i) {
                    case 1 -> System.out.println(personService.createPerson(people));
                    case 2 -> {
                        System.out.println("Enter a Person name: ");
                        String nameP = scanner.nextLine();
                        System.out.println(personService.removePerson(nameP,people));
                    }
                    case 3 -> System.out.println(personService.getAll());
                    case 4 -> {
                        System.out.println("Enter a name: ");
                        String name = scanner.nextLine();
                        System.out.println(personService.findByName(name, people));
                    }
                    case 5 -> {
                        System.out.println("Enter a car name: ");
                        String name1 = scanner.nextLine();
                        System.out.println(personService.findByCarName(name1, people));
                    }
                    case 6 -> System.out.println("");
                    case 7 -> System.out.println(personService.sortPersonDateOfBirth(people));
                    case 8 -> System.out.println(personService.sortPersonName(people));
                    case 9 -> System.out.println(personService.sortGender(people));
                    case 10 -> {
                        System.out.println("Enter a name: ");
                        String name2 = scanner.nextLine();
                        System.out.println(personService.getAge(name2, people));
                    }
                }
            }

        }
        if(number == 2){
            System.out.println("""
                    1 -> createCar,
                    2 -> removeCar,
                    3 -> getAll,
                    4 -> findByName,
                    5 -> findByCountry,
                    6 -> Break;
                     """);
            while (true){
                int j = new Scanner(System.in).nextInt();
                switch (j){
                    case 1:
                        System.out.println(carService.createCar(cars));
                        break;
                    case 2:
                        System.out.println("Enter a name ");
                        String carN = scanner.nextLine();
                        System.out.println(carService.removeCar(carN, cars));
                        break;
                    case 3:
                        System.out.println(carService.getAll());
                    case 4:
                        System.out.println("Enter a name: ");
                        String name = scanner.nextLine();
                        System.out.println(carService.findByName(name, cars));
                        break;
                    case 5:
                        System.out.println("Enter a Country name: ");
                        String nameC = scanner.nextLine();
                        System.out.println(carService.findByCountry(nameC,people));

                }
            }

        }

    }
}