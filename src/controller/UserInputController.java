package controller;

import model.Date;
import model.DateTimeState;
import model.Time;

import java.time.LocalDateTime;

public class UserInputController {

    private final LocalDateTime currentDateTime = LocalDateTime.now();
    private final Time myTime = new Time(currentDateTime, DateTimeState.CHANGE_MODE);
    private final Date myDate = new Date(currentDateTime, DateTimeState.CHANGE_MODE);

    public String handelUserInput(@org.jetbrains.annotations.NotNull String input) {
        String result = null;

        switch (input) {
            case "CHANGE_MODE" -> changeMode();
            case "DISPLAY_TIME" -> result = giveTime();
            case "DISPLAY_DATE" -> result = giveDate();
            case "CHANGE_TIME" -> result = newTime();
            case "CHANGE_DATE" -> result = newDate();
            default -> result = "wrong input";
        }
        return result;
    }

    private void changeMode() {
        myTime.setState(DateTimeState.CHANGE_MODE);
        myDate.setState(DateTimeState.CHANGE_MODE);
    }
    private String giveTime() {
        if (myDate.getState() == DateTimeState.CHANGE_MODE) {
            myTime.setState(DateTimeState.DISPLAY_TIME);
            return myTime.display();
        } else {
            return "Error in state";
        }
    }
    private String giveDate() {
        if (myTime.getState() == DateTimeState.CHANGE_MODE) {
            myDate.setState(DateTimeState.DISPLAY_DATE);
            return myDate.display();
        } else {
            return "Error in state";
        }
    }
    private String newDate() {
        if (myTime.getState() == DateTimeState.CHANGE_MODE) {
            myDate.setState(DateTimeState.CHANGE_DATE);

            int newYear = 1991;
            int newMonth = 12;
            int newDay = 27;

            LocalDateTime modifiedDateTime = currentDateTime.withYear(newYear).withMonth(newMonth).withDayOfMonth(newDay);

            myDate.change(modifiedDateTime);
            return "Date changed";
        } else {
            return "Error in state";
        }
    }
    private String newTime() {
        if (myDate.getState() == DateTimeState.CHANGE_MODE) {
            myTime.setState(DateTimeState.CHANGE_TIME);

            int newHour = 1;
            int newMinute = 1;
            int newSecond = 0;

            LocalDateTime modifiedDateTime = currentDateTime.withHour(newHour).withMinute(newMinute).withSecond(newSecond);

            System.out.println(modifiedDateTime);
            myTime.change(modifiedDateTime);

            return "Time changed";
        } else {
            return "Error in state";
        }
    }
}
