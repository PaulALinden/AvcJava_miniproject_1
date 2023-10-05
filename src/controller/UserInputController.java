package controller;

import model.Date;
import model.DateTimeState;
import model.Time;

import java.time.LocalDateTime;

public class UserInputController {

    LocalDateTime currentDateTime = LocalDateTime.now();
    Time myTime = new Time(currentDateTime, DateTimeState.CHANGE_MODE);
    Date myDate = new Date(currentDateTime, DateTimeState.CHANGE_MODE);

    public void handelUserInput(@org.jetbrains.annotations.NotNull String input) {

        switch (input) {
            case "change" -> {
                myTime.setState(DateTimeState.CHANGE_MODE);
                myDate.setState(DateTimeState.CHANGE_MODE);
            }
            case "time" -> {
                if (myDate.getState() == DateTimeState.CHANGE_MODE) {

                    myTime.setState(DateTimeState.DISPLAY_TIME);
                    System.out.println(myTime.display());
                } else {
                    System.out.println("Error in state");
                }
            }
            case "date" -> {
                if (myTime.getState() == DateTimeState.CHANGE_MODE) {

                    myDate.setState(DateTimeState.DISPLAY_DATE);
                    System.out.println(myDate.display());
                } else {
                    System.out.println("Error in state");
                }
            }
            case "changetime" -> {
                if (myDate.getState() == DateTimeState.CHANGE_MODE) {
                    myTime.setState(DateTimeState.CHANGE_TIME);

                    int newHour = 1;
                    int newMinute = 1;
                    int newSecond = 0;

                    LocalDateTime modifiedDateTime = currentDateTime.withHour(newHour).withMinute(newMinute).withSecond(newSecond);

                    System.out.println(modifiedDateTime);
                    myTime.change(modifiedDateTime);
                } else {
                    System.out.println("Error in state");
                }
            }
            case "changedate" -> {
                if (myTime.getState() == DateTimeState.CHANGE_MODE) {
                    myDate.setState(DateTimeState.CHANGE_DATE);

                    int newYear = 1991;
                    int newMonth = 12;
                    int newDay = 27;

                    LocalDateTime modifiedDateTime = currentDateTime.withYear(newYear).withMonth(newMonth).withDayOfMonth(newDay);

                    myDate.change(modifiedDateTime);
                } else {
                    System.out.println("Error in state");
                }
            }
            default -> System.out.println("wrong input");
        }

        System.out.println(myTime.getState());
        System.out.println(myDate.getState());
    }
}
