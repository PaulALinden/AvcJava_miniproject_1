package controller;

import model.AbstractDateTime;
import model.Date;
import model.DateTimeState;
import model.Time;

import java.time.LocalDateTime;

public class UserInputController {

    private final LocalDateTime CURRENTDATETIME = LocalDateTime.now();
    private final Time MYTIME = new Time(CURRENTDATETIME, DateTimeState.CHANGE_MODE);
    private final Date MYDATE = new Date(CURRENTDATETIME, DateTimeState.CHANGE_MODE);

    public String handelUserInput(@org.jetbrains.annotations.NotNull String input) {
        String result = null;

            switch (input) {
                case "CHANGE_MODE" -> result = changeMode(MYTIME, MYDATE);
                case "DISPLAY_TIME" -> result = giveTime(MYTIME, MYDATE);
                case "DISPLAY_DATE" -> result = giveDate(MYTIME, MYDATE);
                case "CHANGE_TIME" -> {
                    if (newTime(MYTIME, MYDATE)) {
                        result = giveTime(MYTIME, MYDATE);
                    } else {
                        result = "Error";
                    }
                }
                case "CHANGE_DATE" -> {
                    if (newDate(MYTIME, MYDATE)) {
                        result = giveDate(MYTIME, MYDATE);
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

            LocalDateTime modifiedDateTime = CURRENTDATETIME.withYear(newYear).withMonth(newMonth).withDayOfMonth(newDay);

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

            LocalDateTime modifiedDateTime = CURRENTDATETIME.withHour(newHour).withMinute(newMinute).withSecond(newSecond);

            System.out.println(modifiedDateTime);
            myTime.change(modifiedDateTime);

            return true;
        } else {
            return false;
        }
    }
}
