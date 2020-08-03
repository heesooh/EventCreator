/*
package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Interaction implements Load, Save, Input {

    private Event event;
    private String task;
    private Time time;
    private Date date;
    public List<String> lines;

    public void load() throws IOException {
        lines = Files.readAllLines(Paths.get("./data/eventlist.txt"));
        for (int index = 0; index < lines.size(); index++) {
            System.out.println(lines.get(index));
        }
    }

    public void save(String string) throws IOException {
        PrintWriter writer = new PrintWriter("./data/eventlist.txt", "UTF-8");
        lines.add(string);
        for (String event : lines) {
            writer.println(event);
        }
        writer.close();
    }

    public void input() throws IOException {
        String inputs;
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to create an event, 2 to see your events and 3 to quit!");
            Scanner scanner = new Scanner(System.in);
            inputs = scanner.nextLine();
            if (inputs.equals("1")) {
                eventcreator(scanner);
                save(event.getAll());
            }
            if (inputs.equals("2")) {
                load();
            }
            if (inputs.equals("3")) {
                System.out.println("Thank you!");
                break;
            }
        }
    }

    public void eventcreator(Scanner scanner) {
        task = "";
        time = new Time(0, 0, " ");
        date = new Date(0, 0, " ");
        event = new Event(task, time, date);
        eventname(scanner);
        eventdate(scanner);
        eventtime(scanner);
        System.out.println("Your next event summary:\n" + event.getAll());
    }

    public void eventname(Scanner scanner) {
        System.out.println("What is happening?");
        event.settask(scanner.nextLine());
    }

    public void eventdate(Scanner scanner) {
        System.out.println("When is it happening?");
        System.out.println("Month:");
        date.setMonth(Integer.parseInt(scanner.nextLine()));
        System.out.println("Date:");
        date.setDate(Integer.parseInt(scanner.nextLine()));
        System.out.println("Day:");
        date.setDay(scanner.nextLine());
    }

    public void eventtime(Scanner scanner) {
        System.out.println("What time is it happening?");
        System.out.println("Hour:");
        time.setHour(Integer.parseInt(scanner.nextLine()));
        System.out.println("Minute:");
        time.setMinute(Integer.parseInt(scanner.nextLine()));
        System.out.println("AM/PM:");
        time.setAmpm(scanner.nextLine());
    }
}

*/
