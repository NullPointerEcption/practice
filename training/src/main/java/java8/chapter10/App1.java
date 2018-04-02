package java8.chapter10;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class App1 {
    @Test
    public void test() throws Exception {
        //1.创建一个空的optional对象
        Optional<Car> car = Optional.empty();
        //2.创建一个非空的optional对象 如果car为null则会抛出异常
        Car car1 = null;//new Car();
//        Optional<Car> car2 = Optional.of(car1);
        //3.创建一个可以为空的optional对象,为null不会抛异常
        Optional<Car> car3 = Optional.ofNullable(car1);
    }

    @Test
    public void test2() throws Exception {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDuration(props, "a"));
        assertEquals(0, readDuration(props, "b"));
        assertEquals(0, readDuration(props, "c"));
        assertEquals(0, readDuration(props, "d"));

    }



//    public int readDuration(Properties props, String name) {
//        String value = props.getProperty(name);
//        if (value != null) {
//            try {
//                int i = Integer.parseInt(value);
//                if (i > 0) {
//                    return i;
//                }
//            } catch (NumberFormatException nfe) { }
//        }
//        return 0;
//    }

    public int readDuration(Properties props, String name) {

        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

        public String getCarInsuranceName(Person person) {

        return Optional.of(person).flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}

class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}

class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}
