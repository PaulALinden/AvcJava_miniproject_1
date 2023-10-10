package main;

import controller.DateTimeHandlers.DateHandler;
import controller.DateTimeHandlers.DateTimeHandler;
import controller.DateTimeHandlers.TimeHandler;
import controller.MainController;
import model.DateTimeManagers.DateManager;
import model.DateTimeManagers.DateTimeBase;
import model.DateTimeManagers.TimeManager;
import utilitys.DateTimeUpdater;
import view.GUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final DateTimeBase myTime = TimeManager.getInstance();
            final DateTimeBase myDate = DateManager.getInstance();

            DateTimeUpdater.startUpdatingValue();

            final DateTimeHandler timeHandler = new TimeHandler(myTime, myDate);
            final DateTimeHandler dateHandler = new DateHandler(myTime, myDate);

            final MainController mainController = new MainController(timeHandler, dateHandler);
            new GUI(mainController);
        });
    }
}
