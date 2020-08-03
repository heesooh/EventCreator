package placeholder;

import model.Date;
import model.Event;
/*
import model.Interaction;
*/
import model.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class MainTest {

    private Event E;
    private Time T;
    private Date D;
/*
    private Interaction file;
*/
    private PrintWriter writer;
    private List<String> result;
    private Scanner scanner;

    @BeforeEach
    void Eventtest() {
        T = new Time(2, 19, "PM");
        D = new Date(11,16, "Saturday");
        E = new Event("", T, D);
/*
        file = new Interaction();
*/
        result = new ArrayList<>();
        scanner = new Scanner(System.in);

    }

    //Dates
    @Test
    void testgetMonth() {
        assertEquals(D.getMonth(), 11);
    }

    @Test
    void testgetDate() {
        assertEquals(D.getDate(), 16);
    }
    @Test
    void testgetDay() {
        assertEquals(D.getDay(), "Saturday");
    }

    @Test
    void testsetMonth() {
        D.setMonth(12);
        assertEquals(D.getMonth(), 12);
    }

    @Test
    void testsetDate() {
        D.setDate(25);
        assertEquals(D.getDate(), 25);
    }

    @Test
    void testsetDay() {
        D.setDay("Wednesday");
        assertEquals(D.getDay(), "Wednesday");
    }

    //Event
    @Test
    void testgettask() {
        assertEquals(E.gettask(), "");
        E.settask("Homework");
        assertEquals(E.gettask(), "Homework");
    }

    @Test
    void testgettime() {
        assertEquals(E.gettime(), "02:19 PM");
        T.setMinute(9);
        assertEquals(E.gettime(), "02:09 PM");
        T.setHour(11);
        assertEquals(E.gettime(), "11:09 PM");
    }

    @Test
    void testgetdate() {
        assertEquals(E.getdate(), "11 16 Saturday");
    }

    @Test
    void testgetAll() {
        assertEquals(E.getAll(), "Name:  " + "Date: 11 16 Saturday " + "Time: 02:19 PM");
    }

    @Test
    void testsettask() {
        E.settask("Homework");
        assertEquals(E.gettask(), "Homework");
    }

    //Time
    @Test
    void testgetHour() {
        assertEquals(T.getHour(), 2);
    }

    @Test
    void testgetMinute() {
        assertEquals(T.getMinute(), 19);
    }

    @Test
    void testgetAMPM() {
        assertEquals(T.getAmpm(), "PM");
    }

    @Test
    void testsetHour() {
        T.setHour(10);
        assertEquals(T.getHour(), 10);
    }

    @Test
    void testsetMinute() {
        T.setMinute(50);
        assertEquals(T.getMinute(), 50);
    }

    @Test
    void testsetAMPM() {
        T.setAmpm("AM");
        assertEquals(T.getAmpm(), "AM");
    }

    /*//Interaction
    @Test
    void tesetload() throws IOException {
        writer = new PrintWriter("./data/eventlist.txt","UTF-8");
        result.add("Hello");
        result.add("Friend");
        writer.println("Hello\n" + "Friend");
        writer.close();
        file.load();
        assertEquals(file.lines, result);
    }

    @Test
    void testsave() throws IOException {
        writer = new PrintWriter("./data/eventlist.txt","UTF-8");
        writer.println("Hello\n" + "Friend");
        writer.close();
        file.load();
        result.add("Hello");
        result.add("Friend");
        file.save("!");
        result.add("!");
        assertEquals(file.lines, result);
    }*/
}
