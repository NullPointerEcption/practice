package java8.chapter12;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate、 LocalTime、LocalDateTime
 * Instant、 Duration 以及 Period
 */
public class App1 {
    @Test
    public void test() throws Exception {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        System.out.println(String.format("%d",year));
    }

    @Test
    public void test2() throws Exception {
        Instant now = Instant.now();

        System.out.println(now);
    }

    @Test
    public void test3() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        System.out.println(date1);
        String formattedDate = date1.format(formatter);
        System.out.println(formattedDate);
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
        System.out.println(date2);

    }
}
