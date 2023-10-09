package main;

import controller.DateTimeHandlers.DateHandler;
import controller.DateTimeHandlers.DateTimeHandler;
import controller.DateTimeHandlers.TimeHandler;
import controller.MainController;
import model.DateTimeManagers.DateTimeBase;
import model.DateTimeManagers.DateManager;
import model.DateTimeMode;
import model.DateTimeManagers.TimeManager;
import view.GUI;

import javax.swing.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final DateTimeBase myTime = new TimeManager(LocalDateTime.now(), DateTimeMode.DISPLAY_DATE);
            final DateTimeBase myDate = new DateManager(LocalDateTime.now(), DateTimeMode.CHANGE_MODE);

            final DateTimeHandler timeHandler = new TimeHandler(myTime, myDate);
            final DateTimeHandler dateHandler = new DateHandler(myTime, myDate);

            final MainController mainController = new MainController(timeHandler, dateHandler);
            new GUI(mainController);
        });
    }
}
