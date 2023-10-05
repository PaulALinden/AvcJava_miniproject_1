package controller;

import model.Date;
import model.DateTimeState;
import model.Time;

import java.time.LocalDateTime;

public class UserInputController {

    private final LocalDateTime currentDateTime = LocalDateTime.now();
    private final Time myTime = new Time(currentDateTime, DateTimeState.CHANGE_MODE);
    private final Date myDate = new Date(currentDateTime, DateTimeState.CHANGE_MODE);

    public String showFullTime(){
        return myDate.display() + " " + myTime.display();
    }

    public String handelUserInput(@org.jetbrains.annotations.NotNull String input) {
        String result = null;

            switch (input) {
                case "CHANGE_MODE" -> result = changeMode(myTime, myDate);
                case "DISPLAY_TIME" -> result = giveTime(myTime, myDate);
                case "DISPLAY_DATE" -> result = giveDate(myTime, myDate);
                case "CHANGE_TIME" -> {
                    if (newTime(myTime, myDate)) {
                        result = giveTime(myTime, myDate);
                    } else {
                        result = "Error";
                    }
                }
                case "CHANGE_DATE" -> {
                    if (newDate(myTime, myDate)) {
                        result = giveDate(myTime, myDate);
                    } else {
                        result = "Error";
                    }
                }
                case "TERMINATE" -> System.exit(0);
                default -> result = "wrong input";
            }
            return result;

    }

    private String changeMode(Time myTime, Date myDate) {
        myTime.setState(DateTimeState.CHANGE_MODE);
        myDate.setState(DateTimeState.CHANGE_MODE);

        return "CHOOSE MODE";
    }
    private String giveTime(Time myTime, Date myDate) {
        if (myDate.getState() == DateTimeState.CHANGE_MODE) {
            myTime.setState(DateTimeState.DISPLAY_TIME);
            return myTime.display();
        } else {
            return "Error in state";
        }
    }
    private String giveDate(Time myTime, Date myDate) {
        if (myTime.getState() == DateTimeState.CHANGE_MODE) {
            myDate.setState(DateTimeState.DISPLAY_DATE);
            return myDate.display();
        } else {
            return "Error in state";
        }
    }
    private boolean newDate(Time myTime, Date myDate) {
        if (myTime.getState() == DateTimeState.CHANGE_MODE) {
            myDate.setState(DateTimeState.CHANGE_DATE);

            int newYear = 1991;
            int newMonth = 12;
            int newDay = 27;

            LocalDateTime modifiedDateTime = currentDateTime.withYear(newYear).withMonth(newMonth).withDayOfMonth(newDay);

            myDate.change(modifiedDateTime);
            return true;
        } else {
            return false;
        }
    }
    private boolean newTime(Time myTime, Date myDate) {
        if (myDate.getState() == DateTimeState.CHANGE_MODE) {
            myTime.setState(DateTimeState.CHANGE_TIME);

            int newHour = 1;
            int newMinute = 1;
            int newSecond = 0;

            LocalDateTime modifiedDateTime = currentDateTime.withHour(newHour).withMinute(newMinute).withSecond(newSecond);

            System.out.println(modifiedDateTime);
            myTime.change(modifiedDateTime);

            return true;
        } else {
            return false;
        }
    }
}
