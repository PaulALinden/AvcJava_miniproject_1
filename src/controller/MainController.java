package controller;

import controller.DateTimeHandlers.DateHandler;
import controller.DateTimeHandlers.DateTimeHandler;
import controller.DateTimeHandlers.TimeHandler;
import model.DateTimeMode;

public class MainController {

    private final DateTimeHandler dateHandler;
    private final DateTimeHandler timeHandler;

    public MainController(DateTimeHandler timeHandler, DateTimeHandler dateHandler) {
        this.timeHandler = timeHandler;
        this.dateHandler = dateHandler;
    }

    public String initClock() {
        return timeHandler.giveInfo();
    }

    public String handelUserAction(String input) {

        DateTimeHandler manager = (input.equals(DateTimeMode.DISPLAY_TIME.name()) ||
                input.equals(DateTimeMode.CHANGE_TIME.name())) ?
                timeHandler :
                dateHandler;


        return switch (DateTimeMode.valueOf(input)) {
            case CHANGE_MODE -> resetModeSelection();
            case DISPLAY_TIME, DISPLAY_DATE -> manager.giveInfo();
            case CHANGE_TIME, CHANGE_DATE -> manager.canChange() ? "true" : "false";
            case TERMINATE -> {
                System.exit(0);
                yield null;
            }
        };
    }

    public TimeHandler getTimeController() {
        return (TimeHandler) this.timeHandler;
    }

    public DateHandler getDateController() {
        return (DateHandler) this.dateHandler;
    }

    public String resetModeSelection() {
        timeHandler.resetState();
        dateHandler.resetState();
        return "Select mode";
    }
}


