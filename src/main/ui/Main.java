package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application implements Load, Save {

    public List<String> events;

    //start()
    Stage window;

    //mainpage()
    Scene main;
    Button createevent;
    Button checkevent;
    Button savenquitevent;

    //crateevent()
    Scene create1;
    Scene create2;
    Scene create3;
    Label monthLabel;
    Label dateLabel;
    Label dayLabel;
    Label hourLabel;
    Label minuteLabel;
    Label ampmLabel;
    TextField nameInput;
    TextField monthInput;
    TextField dateInput;
    TextField dayInput;
    TextField hourInput;
    TextField minuteInput;
    TextField ampmInput;
    private String task;
    private Time time;
    private Date date;
    private Event event;

    //checkevent()
    Scene check;

    //savenquit()
    Scene savenquit;


    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
        /*file = new Interaction();
        file.load();
        file.input();*/
    }

    //Requires valid txt file
    //Modifies this
    //Effect Assign the List<String> event the strings in the txt file
    public void load() throws IOException {
        events = Files.readAllLines(Paths.get("./data/eventlist.txt"));
    }

    //Requires extension to Application
    //Modifies none
    //Effect creates the stage and runs scenes
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Set up the Window
        window = primaryStage;
        window.setTitle(("Event List"));

        load();
        mainpage();
        createname();
        createdate();
        createtime();
        checkevent();
        savenquit();

        window.setScene(main);
        window.show();
    }

    //Modifies this
    //Effect creates the main page the scene
    private void mainpage() {
        //Set up the buttons
        createevent = new Button();
        createevent.setText("Create Event");

        checkevent = new Button();
        checkevent.setText("Check Event");

        savenquitevent = new Button();
        savenquitevent.setText("Save & Quit");

        //Set up Buttons
        createevent.setOnAction(e -> {
            task = "";
            time = new Time(0, 0, " ");
            date = new Date(0, 0, " ");
            event = new Event(task, time, date);
            window.setScene(create1);
        });
        checkevent.setOnAction(e -> window.setScene(check));
        savenquitevent.setOnAction(e -> window.setScene(savenquit));

        //Layout Main Page - children are laid out in vertical column
        HBox layoutmain = new HBox(20);
        layoutmain.getChildren().addAll(createevent, checkevent, savenquitevent);
        main = new Scene(layoutmain, 300, 30);
    }

    //Modifies this
    //Effect creates the first scene of the createevent where name is assigned to event
    private void createname() {
        //GridPane
        GridPane namegrid = new GridPane();
        namegrid.setPadding(new Insets(10, 10, 10, 10));
        namegrid.setVgap(8);
        namegrid.setHgap(10);

        //Name label
        Label nameLabel = new Label("Event name: ");
        GridPane.setConstraints(nameLabel,0,0);

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("ex.birthday");
        GridPane.setConstraints(nameInput,1,0);

        //To Date Button
        Button datebutton = new Button("Date");
        GridPane.setConstraints(datebutton, 1, 2);
        datebutton.setOnAction(e -> {
            event.settask(nameInput.getText());
            clearInput();
            window.setScene(create2);
        });

        namegrid.getChildren().addAll(nameLabel, nameInput, datebutton);

        create1 = new Scene(namegrid,300,200);
    }

    //Modifies this
    //Effect creates the second scene of the createevent where the date is assigned to event
    private void createdate() {
        GridPane dategrid = new GridPane();
        dategrid.setPadding(new Insets(10, 10, 10, 10));
        dategrid.setVgap(8);
        dategrid.setHgap(10);

        createdateLabel();
        createdateTextField();

        //To Time Button
        Button timebutton = new Button("time");
        GridPane.setConstraints(timebutton, 1, 3);
        timebutton.setOnAction(e -> {
            date.setMonth(Integer.parseInt(monthInput.getText()));
            date.setDate(Integer.parseInt(dateInput.getText()));
            date.setDay(dayInput.getText());
            clearInput();
            window.setScene(create3);
        });

        dategrid.getChildren().addAll(monthLabel, monthInput, dateLabel, dateInput, dayLabel, dayInput, timebutton);
        create2 = new Scene(dategrid,300,200);
    }

    //Modifies this
    //Effect helper function for createdate, Labels are created
    private void createdateLabel() {
        //Month label
        monthLabel = new Label("Month: ");
        GridPane.setConstraints(monthLabel, 0, 0);

        //Date label
        dateLabel = new Label("Date: ");
        GridPane.setConstraints(dateLabel, 0,1);

        //Day label
        dayLabel = new Label("Day: ");
        GridPane.setConstraints(dayLabel, 0,2);
    }

    //Modifies this
    //Effect helper function for createdate, TextFields are created
    private void createdateTextField() {
        //Month input
        monthInput = new TextField();
        monthInput.setPromptText("12");
        GridPane.setConstraints(monthInput,1,0);

        //Date input
        dateInput = new TextField();
        dateInput.setPromptText("31");
        GridPane.setConstraints(dateInput,1,1);

        //Day input
        dayInput = new TextField();
        dayInput.setPromptText("Monday");
        GridPane.setConstraints(dayInput,1,2);
    }

    //Modifies this
    //Effect creates the third scene of the createevent where the time is being assigned to the event
    private void createtime() throws IOException {
        //GridPane
        GridPane timegrid = new GridPane();
        timegrid.setPadding(new Insets(10, 10, 10, 10));
        timegrid.setVgap(8);
        timegrid.setHgap(10);
        createtimeLabel();
        createtimeTextField();
        //Done Button
        Button donebutton = new Button("Done");
        GridPane.setConstraints(donebutton, 1, 3);
        donebutton.setOnAction(e -> {
            time.setHour(Integer.parseInt(hourInput.getText()));
            time.setMinute(Integer.parseInt(minuteInput.getText()));
            time.setAmpm(ampmInput.getText());
            listView.getItems().add(event.getAll());
            clearInput();
            window.setScene(main);
        });

        timegrid.getChildren().addAll(hourLabel, hourInput, minuteLabel, minuteInput, ampmLabel, ampmInput, donebutton);

        create3 = new Scene(timegrid,300,200);

    }

    //Modifies this
    //Effect helper function for createtime, Labels are created
    private void createtimeLabel() {
        //Hour label
        hourLabel = new Label("Hour: ");
        GridPane.setConstraints(hourLabel, 0, 0);

        //Minute label
        minuteLabel = new Label("Minute: ");
        GridPane.setConstraints(minuteLabel, 0,1);

        //AMPM label
        ampmLabel = new Label("AMPM: ");
        GridPane.setConstraints(ampmLabel, 0,2);
    }

    //Modifies this
    //Effect helper function for createtime, TextFields are created
    private void createtimeTextField() {
        //Hour input
        hourInput = new TextField();
        hourInput.setPromptText("11");
        GridPane.setConstraints(hourInput,1,0);

        //Minute input
        minuteInput = new TextField();
        minuteInput.setPromptText("59");
        GridPane.setConstraints(minuteInput,1,1);

        //AMPM input
        ampmInput = new TextField();
        ampmInput.setPromptText("PM");
        GridPane.setConstraints(ampmInput,1,2);
    }

    private void clearInput() {
        nameInput.clear();
        monthInput.clear();
        dateInput.clear();
        dayInput.clear();
        hourInput.clear();
        minuteInput.clear();
        ampmInput.clear();
    }

    //Modifies this
    //Effect creates the checkevent scene
    private void checkevent() {

        Button returnmain = new Button("Done");
        returnmain.setOnAction(e -> window.setScene(main));

        listView = new ListView<>();
        listView.getItems().addAll(events);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Layout Return
        VBox checkLayout = new VBox(20);
        checkLayout.setPadding(new Insets(20,20,20,20));
        checkLayout.getChildren().addAll(listView, returnmain);
        check = new Scene(checkLayout, 400, 300);
    }

    //Modifies this
    //Effect saves the text from the checkevent to assigned txt file
    public void save(List<String> eventlist) throws IOException {
        PrintWriter writer = new PrintWriter("./data/eventlist.txt", "UTF-8");
        events = eventlist;
        for (String event : events) {
            writer.println(event);
        }
        writer.close();
    }

    //Modifies this
    //Effect creates the savenquit scene
    private void savenquit() {

        Button quit = new Button("Save & Quit");
        quit.setOnAction(e -> {
            try {
                closProgram();
            } catch (IOException i) {
                System.out.println("something is wrong");
            }
        });

        Button back = new Button("Back to Main Page");
        back.setOnAction(e -> window.setScene(main));

        HBox savenquitLayout = new HBox(20);
        savenquitLayout.getChildren().addAll(quit, back);
        savenquit = new Scene(savenquitLayout, 225,30);
    }

    //Effect prints "File is saved" then closes the program
    private void closProgram() throws IOException {
        System.out.println("File is saved");
        save(listView.getItems());
        window.close();
    }


}